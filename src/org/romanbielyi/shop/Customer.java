package org.romanbielyi.shop;

import org.romanbielyi.shop.exceptions.dataExceptions.InvalidAgeException;
import org.romanbielyi.shop.exceptions.dataExceptions.InvalidBalanceException;

public class Customer {
    private String name;
    private int age;
    private double balance;

    public Customer(String name, int age, double balance) {
        this.name = name;
        try {
            validateAge(age);
            this.age = age;
        } catch (InvalidAgeException e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            validateBalance(balance);
            this.balance = balance;
        } catch (InvalidBalanceException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        try {
            validateAge(age);
            this.age = age;
        } catch (InvalidAgeException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public int getAge() {
        return age;
    }

    public void setBalance(double balance) {
        try {
            validateBalance(balance);
            this.balance = balance;
        } catch (InvalidBalanceException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public double getBalance() {
        return balance;
    }

    public void subtractBalance(double productPrice) {
        balance -= productPrice;
        if (balance < 0) {
            balance = 0;
        }
    }

    private void validateAge(int age) throws InvalidAgeException {
        if (age <= 0) {
            throw new InvalidAgeException("Invalid data. Age cannot be negative or zero");
        }
    }

    private void validateBalance(double balance) throws InvalidBalanceException {
        if (balance < 0) {
            throw new InvalidBalanceException("Invalid data. Balance cannot be negative. The valid minimum value is zero");
        }
    }
}
