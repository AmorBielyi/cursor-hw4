package org.romanbielyi.shop.abstracts;

import org.romanbielyi.shop.exceptions.dataExceptions.InvalidPriceException;
import org.romanbielyi.shop.exceptions.dataExceptions.InvalidQuantityException;
import org.romanbielyi.shop.interfaces.Buyable;

public abstract class Product implements Buyable {
    protected String name;
    protected double price;
    protected int quantity;
    protected AgeRestriction ageRestriction;

    public enum AgeRestriction {
        NONE,
        TEENAGER,
        ADULT
    }

    public Product(String name, double price, int quantity, AgeRestriction ageRestriction) {
        try {
            validatePrice(price);
            this.price = price;
        } catch (InvalidPriceException e) {
            e.printStackTrace();
            System.exit(1);
        }
        try {
            validateQuantity(quantity);
            this.quantity = quantity;
        } catch (InvalidQuantityException e) {
            e.printStackTrace();
            System.exit(1);
        }
        this.name = name;
        this.ageRestriction = ageRestriction;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(Double price) {
        try {
            validatePrice(price);
            this.price = price;
        } catch (InvalidPriceException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quality) {
        try {
            validateQuantity(quantity);
            this.quantity = quality;
        } catch (InvalidQuantityException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public void decrementQuantity() {
        quantity--;
    }

    private void validatePrice(double price) throws InvalidPriceException {
        if (price < 0) {
            throw new InvalidPriceException("Invalid data. Price cannot be negative value");
        }
    }

    private void validateQuantity(int quantity) throws InvalidQuantityException {
        if (quantity <= 0) {
            throw new InvalidQuantityException("Invalid data. Quantity cannot be zero or negative");
        }
    }
}
