package org.romanbielyi.shop.products;

import org.romanbielyi.shop.abstracts.Product;
import org.romanbielyi.shop.interfaces.Expirable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class FoodProduct extends Product implements Expirable {
    protected Date expirationDate;

    public FoodProduct(String name, double price, int quantity, AgeRestriction ageRestriction, String expirationDate) {
        super(name, price, quantity, ageRestriction);
        try {
            this.expirationDate = new SimpleDateFormat("dd MM yyyy").parse(expirationDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Date getExpirationDate() {
        return expirationDate;
    }

    public long getInspiresInDays() {
        Date nowDate = new Date(System.currentTimeMillis());
        return ChronoUnit.DAYS.between(nowDate.toInstant(), expirationDate.toInstant());
    }

    @Override
    public double getPrice() {
        if (getInspiresInDays() <= 15) {
            return super.getPrice() - (super.getPrice() * 0.30);
        }
        return super.getPrice();
    }
}
