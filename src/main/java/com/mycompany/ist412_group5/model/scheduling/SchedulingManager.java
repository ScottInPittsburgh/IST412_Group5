package com.mycompany.ist412_group5.model.scheduling;

import java.util.*;
import java.io.*;

/**
 * SchedulingManager class activity scheduling.  Implements IntSchedulingManager interface,
 * provides functionality for all booking functions (CRUD)
 * @author Scott St. Clair
 */
public class SchedulingManager implements IntSchedulingManager, Serializable {
    private static final long serialVersionUID = 1L;
    private Map<String, List<Booking>> userSchedules;
    private List<Activity> availableActivities;
    private static final String FILE_NAME = "schedules.ser";
    private int nextBookingId = 1;

    /**
     * construct SchedulingManager
     * Initializes data, accesses save file or creates new one if needed
     */
    public SchedulingManager() {
        loadData();
        if (userSchedules == null) {
            userSchedules = new HashMap<>();
        }
        if (availableActivities == null || availableActivities.isEmpty()) {
            initializeAvailableActivities();
        }
    }

    /**
     * book activity for a user
     */
    @Override
    public boolean bookActivity(String userId, int activityId, String time) {
        Booking newBooking = new Booking(nextBookingId++, activityId, time);
        userSchedules.computeIfAbsent(userId, k -> new ArrayList<>()).add(newBooking);
        saveData();
        return true;
    }

    /**
     * cancel booking for a user
     */
    @Override
    public boolean cancelBooking(String userId, int bookingId) {
        List<Booking> userBookings = userSchedules.get(userId);
        if (userBookings != null) {
            boolean removed = userBookings.removeIf(booking -> booking.getId() == bookingId);
            if (removed) {
                saveData();
                return true;
            }
        }
        return false;
    }

    /**
     * update booking for a user
     */
    @Override
    public boolean updateBooking(String userId, int bookingId, String newTime) {
        List<Booking> userBookings = userSchedules.get(userId);
        if (userBookings != null) {
            for (Booking booking : userBookings) {
                if (booking.getId() == bookingId) {
                    booking.setTime(newTime);
                    saveData();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * retrieve bookings for user
     */
    @Override
    public List<String> getScheduledActivities(String userId) {
        List<String> activities = new ArrayList<>();
        List<Booking> userBookings = userSchedules.get(userId);
        if (userBookings != null) {
            for (Booking booking : userBookings) {
                String activityName = getActivityName(booking.getActivityId());
                activities.add("Booking ID: " + booking.getId() + " - " + activityName + " at " + booking.getTime());
            }
        }
        return activities;
    }

    /**
     * retrieve available activities
     */
    @Override
    public List<String> getAvailableActivities() {
        List<String> activities = new ArrayList<>();
        for (Activity activity : availableActivities) {
            activities.add(activity.getName());
        }
        return activities;
    }

    /**
     * admin use - get scheduled activities for all users
     */
    @Override
    public List<String> getAllScheduledActivities() {
        List<String> allActivities = new ArrayList<>();
        for (Map.Entry<String, List<Booking>> entry : userSchedules.entrySet()) {
            String userId = entry.getKey();
            for (Booking booking : entry.getValue()) {
                String activityName = getActivityName(booking.getActivityId());
                allActivities.add("User " + userId + ": Booking ID: " + booking.getId() + " - " + activityName + " at " + booking.getTime());
            }
        }
        return allActivities;
    }

    /**
     * retrieve activity name based on id, mostly used to enhance user view
     *
     * @param activityId id of activity
     * @return name of activity
     */
    private String getActivityName(int activityId) {
        for (Activity activity : availableActivities) {
            if (activity.getId() == activityId) {
                return activity.getName();
            }
        }
        return "Unknown Activity";
    }

    /**
     * initializes list of available activities, used if no activities found during initialization as a catch all
     */
    private void initializeAvailableActivities() {
        availableActivities = new ArrayList<>();
        availableActivities.add(new Activity(1, "Roller Coaster Ride"));
        availableActivities.add(new Activity(2, "Water Park Adventure"));
        availableActivities.add(new Activity(3, "Magic Show"));
        saveData();
    }

    /**
     * save data to file
     */
    private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * load state of schedulingManager from file, will load a new empty file in the event of error
     */
    private void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            SchedulingManager loadedManager = (SchedulingManager) ois.readObject();
            this.userSchedules = loadedManager.userSchedules;
            this.availableActivities = loadedManager.availableActivities;
            this.nextBookingId = loadedManager.nextBookingId;
        } catch (IOException | ClassNotFoundException e) {
            this.userSchedules = new HashMap<>();
            this.availableActivities = new ArrayList<>();
            this.nextBookingId = 1;
        }
    }

    /**
     * represents a booking
     */
    private static class Booking implements Serializable {
        private static final long serialVersionUID = 1L;
        private int id;
        private int activityId;
        private String time;

        public Booking(int id, int activityId, String time) {
            this.id = id;
            this.activityId = activityId;
            this.time = time;
        }

        public int getId() { return id; }
        public int getActivityId() { return activityId; }
        public String getTime() { return time; }
        public void setTime(String time) { this.time = time; }
    }

    /**
     * represents available activity
     */
    private static class Activity implements Serializable {
        private static final long serialVersionUID = 1L;
        private int id;
        private String name;

        public Activity(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() { return id; }
        public String getName() { return name; }
    }
}
