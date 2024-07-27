package com.mycompany.ist412_group5.model.userprofile;

import java.util.Map;

/**
 * Interface for managing user profiles.
 *
 * @author Frank Imbrunone
 *
 */
public interface IntUserProfileManager {

    /**
     * Authenticates a user based on user ID and password.
     *
     * @param userId   the user ID
     * @param password the password
     * @return the authenticated UserProfile, or null if authentication fails
     */
    UserProfile authenticate(String userId, String password);

    /**
     * Saves the user profiles to a file.
     */
    void saveToFile();

    /**
     * Loads the user profiles from a file.
     */
    void loadFromFile();

    /**
     * Gets all user profiles.
     *
     * @return a map of user IDs to UserProfiles
     */
    Map<String, UserProfile> getAllUsers();

    /**
     * Deletes a user profile based on user ID.
     *
     * @param userId the user ID
     * @return true if the user was successfully deleted, false otherwise
     */
    boolean deleteUser(String userId);

    /**
     * Registers a new user profile.
     *
     * @param userProfile the user profile to register
     */
    void registerUser(UserProfile userProfile);

    /**
     * Views a user profile based on user ID.
     *
     * @param userId the user ID
     * @return the UserProfile
     */
    UserProfile viewUserProfile(String userId);

    /**
     * Gets a user profile based on user ID.
     *
     * @param userId the user ID
     * @return the UserProfile
     */
    UserProfile getUser(String userId); // Ensure this line exists
}
