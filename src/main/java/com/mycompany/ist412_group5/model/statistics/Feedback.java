package com.mycompany.ist412_group5.model.statistics;

import java.io.Serializable;

/**
 * Model class representing user feedback.
 *
 * @author Bright Darko
 */
public class Feedback implements Serializable {
    private String userId;
    private String text;

    /**
     * Constructs a Feedback instance.
     *
     * @param userId the ID of the user providing the feedback
     * @param text   the text of the feedback
     */
    public Feedback(String userId, String text) {
        this.userId = userId;
        this.text = text;
    }

    /**
     * Gets the ID of the user providing the feedback.
     *
     * @return the user ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Gets the text of the feedback.
     *
     * @return the feedback text
     */
    public String getText() {
        return text;
    }
}
