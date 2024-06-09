/**
 * Package contains the view components of the application.
 * Includes classes for displaying information to the user and collecting user input.
 */
package com.mycompany.ist412_group5.view;
/**
 *
 * @author Frank I
 */
import com.mycompany.ist412_group5.model.userprofile.UserProfile;
import com.mycompany.ist412_group5.model.userprofile.EmergencyContact;

/**
 * View - all user profile functions
 */
public class UserProfileView {

    /**
     * Displays the user profile details.
     * @param userProfile The profile details to be displayed.
     */
    public void displayUserProfile(UserProfile userProfile) {
        System.out.println("User Profile:");
        System.out.println("Name: " + userProfile.getName());
        System.out.println("Email: " + userProfile.getEmail());
        System.out.println("Phone: " + userProfile.getPhone());
        System.out.println("Emergency Contact: " + userProfile.getEmergencyContact());
    }

    /**
     * Prompts the user to enter their user ID.
     * @return The entered user ID.
     */
    public String promptForUserId() {
        // Placeholder for user input - in a real application, this would gather input from the user
        System.out.println("Enter User ID:");
        return "user123";
    }

    /**
     * Prompts the user to enter emergency contact details.
     * @return The entered emergency contact details.
     */
    public EmergencyContact promptForEmergencyContact() {
        // Placeholder for user input - in a real application, this would gather input from the user
        EmergencyContact contact = new EmergencyContact();
        contact.setName("Frank Imbrunone");
        contact.setPhone("586-945-1374");
        return contact;
    }

    /**
     * Displays a message to the user.
     * @param message The message to be displayed.
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
