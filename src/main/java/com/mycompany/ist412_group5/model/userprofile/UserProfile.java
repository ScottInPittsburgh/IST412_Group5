package com.mycompany.ist412_group5.model.userprofile;

import java.io.Serializable;

/**
 * This class represents a user profile.
 * It contains information about the user's ID, password, name, email, phone, role, and emergency contact.
 */
public class UserProfile implements Serializable {
    private String userId;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String role;
    private EmergencyContact emergencyContact;

    /**
     * Constructs a UserProfile instance.
     *
     * @param userId           the user's ID
     * @param password         the user's password
     * @param name             the user's name
     * @param email            the user's email
     * @param phone            the user's phone number
     * @param role             the user's role (e.g., admin or regular user)
     * @param emergencyContact the user's emergency contact details
     */
    public UserProfile(String userId, String password, String name, String email, String phone, String role, EmergencyContact emergencyContact) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.emergencyContact = emergencyContact;
    }

    /**
     * Gets the user's ID.
     *
     * @return the user's ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Gets the user's password.
     *
     * @return the user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the user's name.
     *
     * @return the user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the user's email.
     *
     * @return the user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the user's phone number.
     *
     * @return the user's phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the user's phone number.
     *
     * @param phone the new phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the user's role.
     *
     * @return the user's role
     */
    public String getRole() {
        return role;
    }

    /**
     * Gets the user's emergency contact details.
     *
     * @return the user's emergency contact details
     */
    public EmergencyContact getEmergencyContact() {
        return emergencyContact;
    }
}
