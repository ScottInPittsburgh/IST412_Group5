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

    // Private constructor to prevent direct instantiation
    private ParkStatistics(Builder builder) {
        this.attendance = builder.attendance;
        this.rideWaitTimes = builder.rideWaitTimes;
        this.userFeedback = builder.userFeedback;
    }

    public int getAttendance() {
        return attendance;
    }

    public int getRideWaitTimes() {
        return rideWaitTimes;
    }

    public String getUserFeedback() {
        return userFeedback;
    }

    // Builder Class
    public static class Builder {
        private int attendance;
        private int rideWaitTimes;
        private String userFeedback;

        public Builder setAttendance(int attendance) {
            this.attendance = attendance;
            return this;
        }

        public Builder setRideWaitTimes(int rideWaitTimes) {
            this.rideWaitTimes = rideWaitTimes;
            return this;
        }

        public Builder setUserFeedback(String userFeedback) {
            this.userFeedback = userFeedback;
            return this;
        }

        public ParkStatistics build() {
            return new ParkStatistics(this);
        }
    }
}