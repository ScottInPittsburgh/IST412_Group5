package com.mycompany.ist412_group5.model.userprofile;

import java.io.*;

/**
 * Manages user profile data. Saves to file and loads from file user.ser
 */
public class UserProfileManager implements IntUserProfileManager, Serializable {
    private UserProfile user;

    /**
     * Constructs a UserProfileManager and loads the user data from the file.
     */
    public UserProfileManager() {
        // Load user from stored file user.ser
        loadFromFile();
        // Create file if it does not exist
        if (user == null) {
            user = new UserProfile();
            user.setUserId("jdd5003");
            user.setName("John Doe");
            user.setEmail("jdd5003@gmail.com");
            user.setPhone("592-931-1213");
            user.setEmergencyContact(new EmergencyContact("Jane Doe", "123-456-7890"));
            saveToFile();
        }
    }

        /**
         * Returns the user profile.
         *
         * @return the user profile
         */
    public UserProfile getUser() {
        return user;
    }

    /**
     * Saves the user profile to a file.
     */
    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.ser"))) {
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads the user profile from a file.
     */
    public void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.ser"))) {
            user = (UserProfile) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves a user profile based on user ID.
     *
     * @param userId The ID of the user.
     * @return The user profile or null if not found.
     */
    @Override
    public UserProfile viewUserProfile(String userId) {
        if (user.getUserId().equals(userId)) {
            return user;
        }
        return null; // User not found
    }

    /**
     * Updates the emergency contact information in the user profile.
     *
     * @param userId  The ID of the user.
     * @param contact The new emergency contact details.
     * @return A confirmation message or an error message.
     */
    @Override
    public String updateEmergencyContact(String userId, EmergencyContact contact) {
        if (user.getUserId().equals(userId)) {
            user.setEmergencyContact(contact);
            saveToFile();
            return "Emergency contact updated successfully";
        }
        return "User not found";
    }
}
