package com.mycompany.ist412_group5.model.userprofile;

/**
 * @author Frank I
 *
 * This class represents a user profile.
 * It contains information about the user's name, email, phone, and emergency contact.
 *
 */

public class UserProfile {
    private String name;
    private String email;
    private String phone;
    private String emergencyContact;

    /**
     * Gets the name of the user.
     *
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name the new name of the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email of the user.
     *
     * @return the email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     *
     * @param email the new email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone number of the user.
     *
     * @return the phone number of the user
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the user.
     *
     * @param phone the new phone number of the user
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the emergency contact of the user.
     *
     * @return the emergency contact of the user
     */
    public String getEmergencyContact() {
        return emergencyContact;
    }

    /**
     * Sets the emergency contact of the user.
     *
     * @param emergencyContact the new emergency contact of the user
     */
    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }
}
