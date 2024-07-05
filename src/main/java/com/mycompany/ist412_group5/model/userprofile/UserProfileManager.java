package com.mycompany.ist412_group5.model.userprofile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Manages user profiles and handles persistence.
 */
public class UserProfileManager implements IntUserProfileManager, Serializable {
    private Map<String, UserProfile> users;

    /**
     * Constructs a UserProfileManager instance and loads user profiles from a file.
     * If no file is found, initializes with default users.
     */
    public UserProfileManager() {
        loadFromFile();
        if (users == null) {
            users = new HashMap<>();
            // Add some initial users
            users.put("admin", new UserProfile("admin", "admin", "Admin User", "admin@example.com", "123-456-7890", "admin", new EmergencyContact("Admin Contact", "098-765-4321")));
            users.put("user", new UserProfile("user", "user", "Regular User", "user@example.com", "123-456-7890", "user", new EmergencyContact("User Contact", "098-765-4321")));
            saveToFile();
        }
    }

    /**
     * Authenticates a user based on user ID and password.
     *
     * @param userId   The user ID.
     * @param password The password.
     * @return The authenticated UserProfile or null if authentication fails.
     */
    @Override
    public UserProfile authenticate(String userId, String password) {
        UserProfile user = users.get(userId);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    /**
     * Saves user profiles to a file.
     */
    @Override
    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users.ser"))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads user profiles from a file.
     */
    @Override
    public void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("users.ser"))) {
            users = (Map<String, UserProfile>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            users = new HashMap<>();
        }
    }

    /**
     * Retrieves all user profiles.
     *
     * @return A map of user IDs to UserProfile objects.
     */
    @Override
    public Map<String, UserProfile> getAllUsers() {
        return users;
    }

    /**
     * Deletes a user profile based on user ID.
     *
     * @param userId The user ID.
     * @return true if the user was successfully deleted, false otherwise.
     */
    @Override
    public boolean deleteUser(String userId) {
        if (users.containsKey(userId)) {
            users.remove(userId);
            saveToFile();
            return true;
        }
        return false;
    }

    /**
     * Registers a new user profile.
     *
     * @param userProfile The user profile to register.
     */
    @Override
    public void registerUser(UserProfile userProfile) {
        users.put(userProfile.getUserId(), userProfile);
        saveToFile();
    }

    /**
     * Retrieves a user profile based on user ID.
     *
     * @param userId The user ID.
     * @return The UserProfile object or null if not found.
     */
    @Override
    public UserProfile viewUserProfile(String userId) {
        return users.get(userId);
    }

    /**
     * Retrieves a user profile based on user ID.
     *
     * @param userId The user ID.
     * @return The UserProfile object or null if not found.
     */
    @Override
    public UserProfile getUser(String userId) {
        return users.get(userId);
    }
}
