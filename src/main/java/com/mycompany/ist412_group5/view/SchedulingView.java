package com.mycompany.ist412_group5.view;
/**
 *
 * @author Scott St. Clair
 */

import java.util.List;

/**
 * View - all scheduling functions 
 */
public class SchedulingView {
    
    /**
     * display activities 
     * @param activities - list of activities 
     */
    public void displayScheduledActivities(List<String> activities) {
        System.out.println("Scheduled Activities:");
        for (String activity : activities) {
            System.out.println(activity);
        }
    }

    /**
     * Displays scheduling message
     * @param message the message to be displayed
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
