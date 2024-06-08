package com.mycompany.ist412_group5.model.statistics;

/**
 * ParkStatistics class representing real-time statistics of the park.
 *
 * @author Bright Darko
 */
public class ParkStatistics {
    private int attendance;
    private int rideWaitTimes;
    private String userFeedback;


    /**
     * Default constructor for ParkStatistics.
     * Initializes a new instance of the ParkStatistics class.
     */
    public ParkStatistics() {
        // Default constructor
    }

    /**
     * Gets the attendance of the park.
     *
     * @return the attendance of the park.
     */
    public int getAttendance() {
        return attendance;
    }

    /**
     * Sets the attendance of the park.
     *
     * @param attendance the attendance to set.
     */
    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    /**
     * Gets the ride wait times in the park.
     *
     * @return the ride wait times in the park.
     */
    public int getRideWaitTimes() {
        return rideWaitTimes;
    }

    /**
     * Sets the ride wait times in the park.
     *
     * @param rideWaitTimes the ride wait times to set.
     */
    public void setRideWaitTimes(int rideWaitTimes) {
        this.rideWaitTimes = rideWaitTimes;
    }

    /**
     * Gets the user feedback.
     *
     * @return the user feedback.
     */
    public String getUserFeedback() {
        return userFeedback;
    }

    /**
     * Sets the user feedback.
     *
     * @param userFeedback the user feedback to set.
     */
    public void setUserFeedback(String userFeedback) {
        this.userFeedback = userFeedback;
    }
}
