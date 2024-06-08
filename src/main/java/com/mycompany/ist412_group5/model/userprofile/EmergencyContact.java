package com.mycompany.ist412_group5.model.userprofile;
/**
 * @author Frank I
 *
 * Represents an emergency contact for a user.
 * Contains information about the emergency contact's name and phone number.
 *
 */
public class EmergencyContact {
    private String name;
    private String phone;

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