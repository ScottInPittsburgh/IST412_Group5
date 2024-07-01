package com.mycompany.ist412_group5.model.userprofile;

import java.io.Serializable;

/**
 * Represents an emergency contact for a user.
 * Contains information about the emergency contact's name and phone number.
 */
public class EmergencyContact implements Serializable {
    private String name;
    private String phone;

    // Default constructor
    public EmergencyContact() {}

    public EmergencyContact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

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
