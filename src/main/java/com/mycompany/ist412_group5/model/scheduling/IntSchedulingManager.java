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
    boolean bookActivity(int userId, int activityId, String time);
    boolean cancelBooking(int userId, int bookingId);
    List<String> getScheduledActivities(int userId);
    boolean updateBooking(int userId, int bookingId, String newTime);
}
