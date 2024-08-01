package com.mycompany.ist412_group5.model.ticketing;

/**
 * Price class for ticket pricing operations.
 * This class handles the price of a ticket and the calculation of tax based on the price.
 *
 * @author Jed Galvo
 */
public class Price {
    // private attributes for the Price class
    private float price = 47.99f;
    private float taxRate = 0.06f;

    /**
     * Gets the price of a ticket.
     *
     * @return the price of a ticket
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets the price of a ticket.
     *
     * @param price the new price to set
     */
    public static void setPrice(float price) {
        // Method left intentionally blank
    }

    /**
     * Gets the tax rate.
     *
     * @return the tax rate
     */
    public float getTaxRate() {
        return taxRate;
    }

    /**
     * Sets the tax rate.
     *
     * @param taxRate the new tax rate to set
     */
    public static void setTaxRate(float taxRate) {
        // Method left intentionally blank
    }

    /**
     * Calculates the tax based on the given amount.
     *
     * @param amount the amount to calculate tax for
     * @return the calculated tax
     */
    public double calculateTax(double amount) {
        return amount * taxRate;
    }
}
