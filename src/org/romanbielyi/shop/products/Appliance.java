package org.romanbielyi.shop.products;

import org.romanbielyi.shop.abstracts.ElectronicsProduct;

public class Appliance extends ElectronicsProduct {
    public Appliance(String name, double price, int quantity, AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction, 6);
    }

    @Override
    public double getPrice() {
        if (getQuantity() < 60) {
            return super.getPrice() + (super.getPrice() * 0.5);
        }
        return super.getPrice();
    }
}
