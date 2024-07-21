package com.mycompany.ist412_group5.view;

import com.mycompany.ist412_group5.controller.SchedulingController;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * SchedulingView class represents GUI for scheduling
 * @author Scott St. Clair
 */
public class SchedulingView {
    private JPanel mainPanel;
    private JList<String> bookingsList;
    private DefaultListModel<String> bookingsListModel;
    private JComboBox<String> activityComboBox;
    private JSpinner datePicker;
    private JComboBox<String> timePicker;
    private JButton bookButton;
    private JButton cancelButton;
    private JButton updateButton;
    private SchedulingController controller;

    /**
     * construct new SchedulingView
     *
     * @param controller controller this view interacts with
     */
    public SchedulingView(SchedulingController controller) {
        this.controller = controller;
        initializeComponents();
    }

    /**
     * initialize and arrange view components
     */
    private void initializeComponents() {
        mainPanel = new JPanel(new BorderLayout());

        //setup booking panel
        JPanel bookingPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        activityComboBox = new JComboBox<>();

        //setup date picker
        SpinnerDateModel dateModel = new SpinnerDateModel();
        datePicker = new JSpinner(dateModel);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(datePicker, "MM/dd/yyyy");
        datePicker.setEditor(dateEditor);

        //setup time picker
        timePicker = new JComboBox<>();
        for (int hour = 9; hour <= 17; hour++) {
            timePicker.addItem(String.format("%02d:00", hour));
            timePicker.addItem(String.format("%02d:30", hour));
        }

        bookButton = new JButton("Book Activity");

        //add components to panel
        gbc.gridx = 0; gbc.gridy = 0;
        bookingPanel.add(new JLabel("Select Activity:"), gbc);
        gbc.gridx = 1;
        bookingPanel.add(activityComboBox, gbc);
        gbc.gridx = 0; gbc.gridy = 1;
        bookingPanel.add(new JLabel("Select Date:"), gbc);
        gbc.gridx = 1;
        bookingPanel.add(datePicker, gbc);
        gbc.gridx = 0; gbc.gridy = 2;
        bookingPanel.add(new JLabel("Select Time:"), gbc);
        gbc.gridx = 1;
        bookingPanel.add(timePicker, gbc);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        bookingPanel.add(bookButton, gbc);

        //scheduled activities panel setup
        JPanel scheduledPanel = new JPanel(new BorderLayout());
        bookingsListModel = new DefaultListModel<>();
        bookingsList = new JList<>(bookingsListModel);
        JScrollPane bookingsScrollPane = new JScrollPane(bookingsList);
        scheduledPanel.add(bookingsScrollPane, BorderLayout.CENTER);

        JLabel instructionLabel = new JLabel("Click Booking to Cancel or Update");
        scheduledPanel.add(instructionLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        cancelButton = new JButton("Cancel Booking");
        updateButton = new JButton("Update Booking");
        buttonPanel.add(cancelButton);
        buttonPanel.add(updateButton);
        scheduledPanel.add(buttonPanel, BorderLayout.SOUTH);

        //add to main panel
        mainPanel.add(bookingPanel, BorderLayout.WEST);
        mainPanel.add(scheduledPanel, BorderLayout.CENTER);

        //add action listeners
        bookButton.addActionListener(e -> bookActivity());
        cancelButton.addActionListener(e -> cancelBooking());
        updateButton.addActionListener(e -> updateBooking());

        //disable cancel/update by default
        cancelButton.setEnabled(false);
        updateButton.setEnabled(false);

        //add list listener
        bookingsList.addListSelectionListener(e -> {
            boolean isSelected = !bookingsList.isSelectionEmpty();
            cancelButton.setEnabled(isSelected);
            updateButton.setEnabled(isSelected);
        });
    }

    /**
     * returns main panel view
     *
     * @return main JPanel
     */
    public JPanel getPanel() {
        return mainPanel;
    }

    /**
     * updates displayed scheduled activities
     *
     * @param activities list of scheduled activities
     */
    public void updateScheduledActivities(List<String> activities) {
        bookingsListModel.clear();
        for (String activity : activities) {
            bookingsListModel.addElement(activity);
        }
    }

    /**
     * updates available activities in the selection (combo) box
     *
     * @param activities list of available activities
     */
    public void updateAvailableActivities(List<String> activities) {
        activityComboBox.removeAllItems();
        for (String activity : activities) {
            activityComboBox.addItem(activity);
        }
    }

    /**
     * admin view - updates list of scheduled activities for all users
     *
     * @param activities list of schedule activities for all users
     */
    public void updateAllScheduledActivities(List<String> activities) {
        bookingsListModel.clear();
        for (String activity : activities) {
            bookingsListModel.addElement(activity);
        }
    }

    /**
     * handles new activity booking, sends pass/fail message upon completion
     */
    private void bookActivity() {
        String selectedActivity = (String) activityComboBox.getSelectedItem();
        String dateTime = getSelectedDateTime();

        if (selectedActivity != null && dateTime != null) {
            int activityId = activityComboBox.getSelectedIndex() + 1;
            boolean success = controller.bookActivity(activityId, dateTime);
            if (success) {
                JOptionPane.showMessageDialog(mainPanel, "Activity booked successfully!");
                resetDateTimePickers();
            } else {
                JOptionPane.showMessageDialog(mainPanel, "Failed to book activity.");
            }
        } else {
            JOptionPane.showMessageDialog(mainPanel, "Please select an activity, date, and time.");
        }
    }

    /**
     * handles booking cancellation
     */
    private void cancelBooking() {
        String selectedBooking = bookingsList.getSelectedValue();
        if (selectedBooking != null) {
            int bookingId = extractBookingId(selectedBooking);
            boolean success = controller.cancelBooking(bookingId);
            if (success) {
                JOptionPane.showMessageDialog(mainPanel, "Booking cancelled successfully!");
            } else {
                JOptionPane.showMessageDialog(mainPanel, "Failed to cancel booking.");
            }
        }
    }

    /**
     * handles update of booking
     */
    private void updateBooking() {
        String selectedBooking = bookingsList.getSelectedValue();
        if (selectedBooking != null) {
            int bookingId = extractBookingId(selectedBooking);

            // open new dialog, recreates the time/date selection as the main screen
            JDialog updateDialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(mainPanel), "Update Booking", true);
            updateDialog.setLayout(new BorderLayout());

            JPanel updatePanel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);

            JSpinner updateDatePicker = new JSpinner(new SpinnerDateModel());
            JSpinner.DateEditor updateDateEditor = new JSpinner.DateEditor(updateDatePicker, "MM/dd/yyyy");
            updateDatePicker.setEditor(updateDateEditor);

            JComboBox<String> updateTimePicker = new JComboBox<>();
            for (int hour = 9; hour <= 17; hour++) {
                updateTimePicker.addItem(String.format("%02d:00", hour));
                updateTimePicker.addItem(String.format("%02d:30", hour));
            }

            gbc.gridx = 0; gbc.gridy = 0;
            updatePanel.add(new JLabel("Select New Date:"), gbc);
            gbc.gridx = 1;
            updatePanel.add(updateDatePicker, gbc);
            gbc.gridx = 0; gbc.gridy = 1;
            updatePanel.add(new JLabel("Select New Time:"), gbc);
            gbc.gridx = 1;
            updatePanel.add(updateTimePicker, gbc);

            JButton confirmUpdateButton = new JButton("Confirm Update");
            gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
            updatePanel.add(confirmUpdateButton, gbc);

            updateDialog.add(updatePanel, BorderLayout.CENTER);

            confirmUpdateButton.addActionListener(e -> {
                Date selectedDate = (Date) updateDatePicker.getValue();
                String selectedTime = (String) updateTimePicker.getSelectedItem();

                if (selectedDate != null && selectedTime != null) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(selectedDate);
                    String[] timeParts = selectedTime.split(":");
                    calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeParts[0]));
                    calendar.set(Calendar.MINUTE, Integer.parseInt(timeParts[1]));

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    String newDateTime = sdf.format(calendar.getTime());

                    boolean success = controller.updateBooking(bookingId, newDateTime);
                    if (success) {
                        JOptionPane.showMessageDialog(updateDialog, "Booking updated successfully!");
                        updateDialog.dispose();
                    } else {
                        JOptionPane.showMessageDialog(updateDialog, "Failed to update booking.");
                    }
                } else {
                    JOptionPane.showMessageDialog(updateDialog, "Please select a date and time.");
                }
            });

            updateDialog.pack();
            updateDialog.setLocationRelativeTo(mainPanel);
            updateDialog.setVisible(true);
        }
    }

    /**
     * gets booking id from string
     *
     * @param booking booking string
     * @return the ID from the string
     */
    private int extractBookingId(String booking) {
        // Assuming the booking string starts with "Booking ID: X"
        String[] parts = booking.split(":");
        return Integer.parseInt(parts[1].trim().split(" - ")[0]);
    }

    /**
     * get and format date formatted date
     *
     * @return date/time
     */
    private String getSelectedDateTime() {
        Date selectedDate = (Date) datePicker.getValue();
        String selectedTime = (String) timePicker.getSelectedItem();

        if (selectedDate != null && selectedTime != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(selectedDate);
            String[] timeParts = selectedTime.split(":");
            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeParts[0]));
            calendar.set(Calendar.MINUTE, Integer.parseInt(timeParts[1]));

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            return sdf.format(calendar.getTime());
        }
        return null;
    }

    /**
     * reset pickers to default value
     */
    private void resetDateTimePickers() {
        datePicker.setValue(new Date());
        timePicker.setSelectedIndex(0);
    }
}