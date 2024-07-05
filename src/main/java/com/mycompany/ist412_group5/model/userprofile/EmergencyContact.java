package com.mycompany.ist412_group5.model.userprofile;

import java.io.Serializable;

/**
 * Represents an emergency contact for a user profile.
 * Implements Serializable for saving and loading the contact information.
 */
public class EmergencyContact implements Serializable {
    private String name;
    private String phone;

    /**
     * Constructs an EmergencyContact instance with the specified name and phone number.
     *
     * @param name  the name of the emergency contact
     * @param phone the phone number of the emergency contact
     */
    public EmergencyContact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    /**
     * Gets the name of the emergency contact.
     *
     * @return the name of the emergency contact
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the emergency contact.
     *
     * @param name the new name of the emergency contact
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the phone number of the emergency contact.
     *
     * @return the phone number of the emergency contact
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the emergency contact.
     *
     * @param phone the new phone number of the emergency contact
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
