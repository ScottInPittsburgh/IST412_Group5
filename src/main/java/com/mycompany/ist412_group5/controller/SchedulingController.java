/**
 * Package contains controllers for managing operations within project.
 * Controllers: scheduling, ticket management, statistics, and user profiles.
 */
package com.mycompany.ist412_group5.controller;
/**
 *
 * @author Scott St. Clair
 */
import com.mycompany.ist412_group5.model.scheduling.IntSchedulingManager;
import com.mycompany.ist412_group5.model.scheduling.SchedulingManager;
import com.mycompany.ist412_group5.view.SchedulingView;

/**
 * Controller - manages all scheduling operations
 */
public class SchedulingController {
    private IntSchedulingManager schedulingManager;
    private SchedulingView schedulingView;
 /**
     * Constructs new SchedulingController instance
     */
    public SchedulingController() {
        this.schedulingManager = new SchedulingManager();
        this.schedulingView = new SchedulingView();
    }

    /**
     * Books activity for user
     * @param userId - user id
     * @param activityId - activity id
     * @param time - time of booking
     * @return true for success, else fail 
     */
    public boolean bookActivity(int userId, int activityId, String time) {
        return schedulingManager.bookActivity(userId, activityId, time);
    }

    /**
     * Cancels activity for user 
     * @param userId -user id
     * @param bookingId - booking id 
     * @return true for success, else fail 
     */
    public boolean cancelBooking(int userId, int bookingId) {
        return schedulingManager.cancelBooking(userId, bookingId);
    }

    /**
     * view schedule by user
     * @param userId - user id
     */
    public void viewScheduledActivities(int userId) {
        schedulingView.displayScheduledActivities(schedulingManager.getScheduledActivities(userId));
    }

    /**
     * update booking by user/id
     * @param userId - user id
     * @param bookingId - booking id
     * @param newTime - revised time for booking 
     * @return true for success, else fail 
     */
    public boolean updateBooking(int userId, int bookingId, String newTime) {
        return schedulingManager.updateBooking(userId, bookingId, newTime);
    }
}
