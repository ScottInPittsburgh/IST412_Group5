package com.mycompany.ist412_group5.model.scheduling;

import java.util.List;

/**
 * This interface handles scheduling operations, with methods for managing bookings
 * @author Scott St. Clair
 */
public interface IntSchedulingManager {

    /**
     * book activity for user
     *
     * @param userId     id of user
     * @param activityId id of activity
     * @param time       time slot
     * @return success/fail
     */
    boolean bookActivity(String userId, int activityId, String time);

    /**
     * cancel booking for user
     *
     * @param userId    id of user
     * @param bookingId id of booking reservation
     * @return success/fail
     */
    boolean cancelBooking(String userId, int bookingId);

    /**
     * updates booking for user
     *
     * @param userId    id of user
     * @param bookingId id of booking reservation
     * @param newTime   adjusted time slot
     * @return success/fail
     */
    boolean updateBooking(String userId, int bookingId, String newTime);

    /**
     * gets list of scheduled activities
     *
     * @param userId id of user
     * @return list of strings with booking details
     */
    List<String> getScheduledActivities(String userId);

    /**
     * get list of available activities
     *
     * @return list of strings of activities available for booking
     */
    List<String> getAvailableActivities();

    /**
     * admin use - get list of all users' scheduled activities
     *
     * @return list of strings of all user bookings
     */
    List<String> getAllScheduledActivities();
}