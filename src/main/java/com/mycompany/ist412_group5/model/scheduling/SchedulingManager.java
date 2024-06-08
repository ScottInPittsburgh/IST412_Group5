package com.mycompany.ist412_group5.model.scheduling;
/**
 *
 * @author Scott St. Clair
 */

import java.util.List;
import java.util.ArrayList;

/**
 * Implements scheduling functions 
 */
public class SchedulingManager implements IntSchedulingManager {

    @Override
    public boolean bookActivity(int userId, int activityId, String time) {
        // do a booking
        return true; 
    }

    @Override
    public boolean cancelBooking(int userId, int bookingId) {
        // undo a booking 
        return true;  
    }

    @Override
    public List<String> getScheduledActivities(int userId) {
        // schedule! 
        return new ArrayList<>(); 
    }

    @Override
    public boolean updateBooking(int userId, int bookingId, String newTime) {
        // Re-schedule! 
        return true;
    }
}
