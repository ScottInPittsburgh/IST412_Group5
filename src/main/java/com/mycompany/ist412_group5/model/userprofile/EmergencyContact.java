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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}