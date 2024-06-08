package com.mycompany.ist412_group5.model.statistics;

/**
 * ParkStatistics class representing real-time statistics of the park.
 */
public class ParkStatistics {
    private int attendance;
    private int rideWaitTimes;
    private String userFeedback;

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getRideWaitTimes() {
        return rideWaitTimes;
    }

    public void setRideWaitTimes(int rideWaitTimes) {
        this.rideWaitTimes = rideWaitTimes;
    }

    public String getUserFeedback() {
        return userFeedback;
    }

    public void setUserFeedback(String userFeedback) {
        this.userFeedback = userFeedback;
    }
}
