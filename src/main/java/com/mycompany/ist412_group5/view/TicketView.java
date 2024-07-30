package com.mycompany.ist412_group5.view;

import com.mycompany.ist412_group5.controller.TicketController;
import com.mycompany.ist412_group5.model.ticketing.Price;
import com.mycompany.ist412_group5.model.userprofile.UserProfile;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

/**
 * View class for ticket operations.
 */
public class TicketView extends JPanel {
    private TicketController ticketController;
    private HomeView homeView;
    private JTextField textField2 = new JTextField(10);
    private JComboBox<String> jComboBox1 = new JComboBox<>();
    private JTextField priceField = new JTextField(10);
    private JTextField taxField = new JTextField(10);
    private JTextField totalField = new JTextField(10);
    private JSpinner datePicker;
    private JButton confirmationButton = new JButton("Confirm Purchase");

    /**
     * Creates a new TicketView instance.
     *
     * @param homeView         the home view instance
     * @param ticketController the ticket controller instance
     */
    public TicketView(HomeView homeView, TicketController ticketController) {
        this.homeView = homeView;
        this.ticketController = ticketController;
        this.ticketController.setTicketView(this);
    }

    /**
     * Initializes the components of the ticket view.
     */
    public void initComponents() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel quantityLabel = new JLabel("Quantity Tickets: ");
        JLabel paymentLabel = new JLabel("Payment Method: ");
        JLabel priceLabel = new JLabel("Price: ");
        JLabel taxLabel = new JLabel("Tax: ");
        JLabel totalLabel = new JLabel("Total: ");
        JLabel dateLabel = new JLabel("Visit Date: ");

        priceField.setEditable(false);
        taxField.setEditable(false);
        totalField.setEditable(false);

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[]{"VISA", "MasterCard", "Amex"}));

        // Date Picker
        SpinnerDateModel dateModel = new SpinnerDateModel();
        datePicker = new JSpinner(dateModel);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(datePicker, "MM/dd/yyyy");
        datePicker.setEditor(dateEditor);

        confirmationButton.setPreferredSize(new Dimension(160, 30));
        confirmationButton.addActionListener(this::jButtonOKActionPerformed);

        textField2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updatePrice();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updatePrice();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updatePrice();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(quantityLabel, gbc);

        gbc.gridx = 1;
        panel.add(textField2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(paymentLabel, gbc);

        gbc.gridx = 1;
        panel.add(jComboBox1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(priceLabel, gbc);

        gbc.gridx = 1;
        panel.add(priceField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(taxLabel, gbc);

        gbc.gridx = 1;
        panel.add(taxField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(totalLabel, gbc);

        gbc.gridx = 1;
        panel.add(totalField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(dateLabel, gbc);

        gbc.gridx = 1;
        panel.add(datePicker, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(confirmationButton, gbc);

        homeView.updateMainContentPanel(panel);
    }

    /**
     * Updates the price, tax, and total fields based on the quantity of tickets.
     */
    private void updatePrice() {
        try {
            int quantity = Integer.parseInt(textField2.getText());
            Price price = new Price();
            double basePrice = price.getPrice() * quantity;
            double tax = price.calculateTax(basePrice);
            double total = basePrice + tax;
            priceField.setText(String.format("$%.2f", basePrice));
            taxField.setText(String.format("$%.2f", tax));
            totalField.setText(String.format("$%.2f", total));
        } catch (NumberFormatException e) {
            priceField.setText("");
            taxField.setText("");
            totalField.setText("");
        }
    }

    /**
     * Handles the action when the "Confirm Purchase" button is clicked.
     *
     * @param evt the action event
     */
    private void jButtonOKActionPerformed(ActionEvent evt) {
        try {
            int amountTickets = Integer.parseInt(textField2.getText());
            if (amountTickets <= 0) {
                throw new NumberFormatException();
            }
            String paymentMethod = String.valueOf(jComboBox1.getSelectedItem());
            double totalPrice = Double.parseDouble(totalField.getText().replace("$", ""));
            Date visitDate = (Date) datePicker.getValue();

            if (visitDate == null) {
                JOptionPane.showMessageDialog(this, "Please select a visit date.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String visitDateString = new SimpleDateFormat("yyyy-MM-dd").format(visitDate);

            // Get the current user and add the ticket purchase
            UserProfile user = homeView.getUserProfileManager().getUser("user");
            String purchase = "Purchased " + amountTickets + " tickets for $" + totalPrice + " using " + paymentMethod;
            String purchaseDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
            user.addTicketPurchase("Purchase Date: " + purchaseDate + " | " + "Tickets: " + amountTickets + " | " + "Price: $" + totalPrice + " | " + "Visit Date: " + visitDateString);

            // Save the updated user profile
            homeView.getUserProfileManager().saveToFile();

            // Display the result and clear the panel
            displayPurchaseResult(purchase + " on " + purchaseDate + " for visit on " + visitDateString);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for the quantity of tickets.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Displays the purchase result in a dialog and clears the panel.
     *
     * @param result the result message to display
     */
    public void displayPurchaseResult(String result) {
        JOptionPane.showMessageDialog(this, result);
        homeView.updateMainContentPanel(new JPanel());
    }
}
