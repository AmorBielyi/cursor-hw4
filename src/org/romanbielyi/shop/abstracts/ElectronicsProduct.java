package org.romanbielyi.shop.abstracts;

import org.romanbielyi.shop.exceptions.dataExceptions.InvalidGuaranteeException;

public abstract class ElectronicsProduct extends Product {
    protected int guarantee;

    public ElectronicsProduct(String name, double price, int quantity, AgeRestriction ageRestriction, int guarantee) {
        super(name, price, quantity, ageRestriction);
        try {
            validateGuarantee(guarantee);
            this.guarantee = guarantee;
        } catch (InvalidGuaranteeException e) {
            e.printStackTrace();
        }
    }

    public void setGuarantee(int guarantee) {
        try {
            validateGuarantee(guarantee);
            this.guarantee = guarantee;
        } catch (InvalidGuaranteeException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public int getGuarantee() {
        return guarantee;
    }

    private void validateGuarantee(int guarantee) throws InvalidGuaranteeException {
        if (guarantee <= 0) {
            throw new InvalidGuaranteeException("Invalid data. Guarantee of the product cannot be zero or negative");
        }
    }
}
