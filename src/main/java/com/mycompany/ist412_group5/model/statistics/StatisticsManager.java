package com.mycompany.ist412_group5.model.statistics;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages statistics-related operations.
 *
 * @author Bright Darko
 */
public class StatisticsManager implements IntStatisticsManager, Serializable {

    private List<Feedback> feedbackList;

    /**
     * Default constructor for StatisticsManager.
     * Initializes a new instance of the StatisticsManager class and loads feedback from a file.
     */
    public StatisticsManager() {
        loadFeedbackFromFile();
        if (feedbackList == null) {
            feedbackList = new ArrayList<>();
        }
    }

    /**
     * Retrieves real-time statistics for the park.
     *
     * @return A ParkStatistics object containing real-time statistics.
     */
    @Override
    public ParkStatistics getRealTimeStatistics() {
        return new ParkStatistics.Builder()
                .setAttendance(5000)
                .setRideWaitTimes(30)
                .setUserFeedback("Very positive")
                .build();
    }

    /**
     * Generates a report based on the park statistics.
     *
     * @return A Report object containing the report content.
     */
    @Override
    public Report generateReport() {
        Report report = new Report();
        report.setContent("Sample report content");
        return report;
    }

    /**
     * Adds feedback to the feedback list and saves it to a file.
     *
     * @param feedback The feedback to be added.
     */
    @Override
    public void addFeedback(Feedback feedback) {
        feedbackList.add(feedback);
        saveFeedbackToFile();
    }

    /**
     * Deletes feedback from the feedback list and saves the updated list to a file.
     *
     * @param feedbackText The text of the feedback to be deleted.
     * @return true if the feedback was deleted, false otherwise
     */
    public boolean deleteFeedback(String feedbackText) {
        feedbackText = feedbackText.replaceAll("^user:|admin:", "").trim();
        for (Feedback feedback : feedbackList) {
            String storedFeedbackText = feedback.getText().replaceAll("^user:|admin:", "").trim();
            System.out.println("Comparing with: " + storedFeedbackText);
            if (storedFeedbackText.equalsIgnoreCase(feedbackText)) {
                feedbackList.remove(feedback);
                saveFeedbackToFile();
                return true;
            }
        }
        return false;
    }

    public void removeFeedback(Feedback feedback) {
        feedbackList.remove(feedback);
        saveFeedbackToFile();
    }


    /**
     * Retrieves all feedback from the feedback list.
     *
     * @return A list of all feedback.
     */
    @Override
    public List<Feedback> getAllFeedback() {
        return feedbackList;
    }


    /**
     * Saves the feedback list to a file.
     */
    public void saveFeedbackToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("feedback.ser"))) {
            oos.writeObject(feedbackList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Loads the feedback list from a file.
     */
    private void loadFeedbackFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("feedback.ser"))) {
            feedbackList = (List<Feedback>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            feedbackList = new ArrayList<>();
        }
    }
}
