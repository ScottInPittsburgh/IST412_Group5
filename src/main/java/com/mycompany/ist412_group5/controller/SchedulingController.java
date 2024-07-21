package com.mycompany.ist412_group5.controller;

import com.mycompany.ist412_group5.model.scheduling.IntSchedulingManager;
import com.mycompany.ist412_group5.model.scheduling.SchedulingManager;
import com.mycompany.ist412_group5.view.SchedulingView;
import com.mycompany.ist412_group5.view.HomeView;
import com.mycompany.ist412_group5.model.userprofile.UserProfile;

import java.util.List;

/**
 * Controller class manages scheduling operations.
 * This actions as an intermediary between View & Manager to handle user interactions and update the view.
 * @author Scott St. Clair
 */
public class SchedulingController {
    private IntSchedulingManager schedulingManager;
    private SchedulingView schedulingView;
    private HomeView homeView;
    private UserProfile user;

    /**
     * constructs SchedulingController
     *
     * @param homeView main app view
     * @param user current user profile
     */
    public SchedulingController(HomeView homeView, UserProfile user) {
        this.schedulingManager = new SchedulingManager();
        this.homeView = homeView;
        this.user = user;
        this.schedulingView = new SchedulingView(this);
    }

    /**
     * display scheduling view, shows all schedules activities if an admin
     */
    public void showSchedulingView() {
        homeView.updateMainContentPanel(schedulingView.getPanel());
        if ("admin".equals(user.getRole())) {
            viewAllScheduledActivities();
        } else {
            viewScheduledActivities();
        }
        viewAvailableActivities();
    }

    /**
     * books activity for user
     *
     * @param activityId id of the activity
     * @param time booking time slot
     * @return success/fail
     */
    public boolean bookActivity(int activityId, String time) {
        boolean result = schedulingManager.bookActivity(user.getUserId(), activityId, time);
        if (result) {
            viewScheduledActivities();
        }
        return result;
    }

    /**
     * cancels baoking for user
     *
     * @param bookingId id of activity
     * @return success/fail
     */
    public boolean cancelBooking(int bookingId) {
        boolean result = schedulingManager.cancelBooking(user.getUserId(), bookingId);
        if (result) {
            viewScheduledActivities();
        }
        return result;
    }

    /**
     * updates booking for user
     *
     * @param bookingId id of activity
     * @param newTime adjusted time slot
     * @return success/fail
     */
    public boolean updateBooking(int bookingId, String newTime) {
        boolean result = schedulingManager.updateBooking(user.getUserId(), bookingId, newTime);
        if (result) {
            viewScheduledActivities();
        }
        return result;
    }

    /**
     * displays users currently scheduled activities
     */
    public void viewScheduledActivities() {
        List<String> activities = schedulingManager.getScheduledActivities(user.getUserId());
        schedulingView.updateScheduledActivities(activities);
    }

    /**
     * displays all available activities
     */
    public void viewAvailableActivities() {
        List<String> activities = schedulingManager.getAvailableActivities();
        schedulingView.updateAvailableActivities(activities);
    }

    /**
     * admin view function to see all scheduled activities
     */
    public void viewAllScheduledActivities() {
        List<String> activities = schedulingManager.getAllScheduledActivities();
        schedulingView.updateAllScheduledActivities(activities);
    }

    /**
     * check if user has admin credentials
     *
     * @return success/fail
     */
    public boolean isAdmin() {
        return "admin".equals(user.getRole());
    }
}