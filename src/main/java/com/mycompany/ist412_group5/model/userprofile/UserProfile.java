package com.mycompany.ist412_group5.model.userprofile;

import java.io.Serializable;

/**
 * This class represents a user profile.
 * It contains information about the user's name, email, phone, and emergency contact.
 */
public class UserProfile implements Serializable {
    private String userId;
    private String name;
    private String email;
    private String phone;
    private EmergencyContact emergencyContact;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public EmergencyContact getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(EmergencyContact emergencyContact) {
        this.emergencyContact = emergencyContact;
    }
}
