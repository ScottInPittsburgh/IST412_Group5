/**
 * Package provides classes and interfaces for scheduling activities in the park.
 * Includes classes for managing and viewing schedules.
 */
package com.mycompany.ist412_group5.model.scheduling;
/**
 *
 * @author Scott St. Clair
 * Interface for activity scheduling
 */

import java.util.List;

/**
 * Interface - scheduling
 */
public interface IntSchedulingManager {
    /**
     * Books activity for user.
     * @param userId The ID of the user.
     * @param activityId The ID of the activity.
     * @param time The time at which the activity is scheduled.
     * @return True if the booking is successful, else false
     */
    boolean bookActivity(int userId, int activityId, String time);
   /**
     * Cancels booking for user.
     * @param userId The ID of the user.
     * @param bookingId The ID of the booking.
     * @return True if the cancellation is successful, else false
     */
    boolean cancelBooking(int userId, int bookingId);
     /**
     * Retrieves scheduled activities user. 
     * @param userId The ID of the user.
     * @return A list of scheduled activities.
     */
    List<String> getScheduledActivities(int userId);
   /**
     * Updates booking for user. 
     * @param userId The ID of the user.
     * @param bookingId The ID of the booking.
     * @param newTime The new time for the booking.
     * @return True if the update is successful, else false
     */
    boolean updateBooking(int userId, int bookingId, String newTime);
}
