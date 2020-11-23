package org.romanbielyi.shop.products;

import org.romanbielyi.shop.abstracts.ElectronicsProduct;

public class Computer extends ElectronicsProduct {

    public Computer(String name, double price, int quantity, AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction, 24);
    }

    @Override
    public double getPrice() {
        if (getQuantity() > 1000) {
            return super.getPrice() - (super.getPrice() * 0.5);
        } else {
            return super.getPrice();
        }
    }
}
