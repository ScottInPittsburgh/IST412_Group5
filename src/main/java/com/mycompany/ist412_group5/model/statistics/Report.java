package com.mycompany.ist412_group5.model.statistics;

/**
 * Report class representing a generated report.
 *
 * @author Bright Darko
 */
public class Report {
    private String content;


    /**
     * Default constructor for Report.
     * Initializes a new instance of the Report class.
     */
    public Report() {
        // Default constructor
    }

    /**
     * Retrieves the content of the report.
     *
     * @return the content of the report
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the report.
     *
     * @param content the new content of the report
     */
    public void setContent(String content) {
        this.content = content;
    }
}