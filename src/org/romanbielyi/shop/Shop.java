package org.romanbielyi.shop;

import org.romanbielyi.shop.abstracts.Product;
import org.romanbielyi.shop.exceptions.*;
import org.romanbielyi.shop.products.Appliance;
import org.romanbielyi.shop.products.Computer;
import org.romanbielyi.shop.products.FoodProduct;

import java.util.*;
import java.util.stream.Collectors;

public class Shop {

    public static void main(String[] args) {
        // Products
        FoodProduct chips = new FoodProduct(
                "Lays with onion",
                12.80,
                230,
                Product.AgeRestriction.NONE,
                "28 11 2020");

        FoodProduct cigars = new FoodProduct(
                "Blade Runner",
                8.40,
                1200,
                Product.AgeRestriction.ADULT,
                "23 11 2020");

        Computer appleLisa = new Computer(
                "Apple Lisa",
                890,
                18,
                Product.AgeRestriction.NONE);

        Appliance videoGame = new Appliance(
                "Mars Invaders",
                18,
                1,
                Product.AgeRestriction.ADULT);

        // Customers
        Customer janisJoplin = new Customer(
                "Janis Joplin",
                12,
                15.33);

        Customer billGates = new Customer(
                "Bill Gates",
                47,
                5437);

        // List of products
        List<Product> products = new ArrayList<>();
        products.add(chips);
        products.add(cigars);
        products.add(appleLisa);
        products.add(videoGame);

        // List of customers
        List<Customer> customers = new ArrayList<>();
        customers.add(janisJoplin);
        customers.add(billGates);

        // Trying to sale to them all
        for (Product product : products) {
            for (Customer customer : customers) {
                try {
                    System.out.printf("Trying to sale product '%s' to '%s'\n", product.getName(), customer.getName());
                    PurchaseManager.processPurchase(product, customer);
                } catch (NotEnoughMoneyException | TeenageException | OutOfStockException | AdultException | ProductExpiredException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.printf("TOTAL SHOP EARNINGS %f\n", PurchaseManager.getEarnings());

        System.out.printf("The first product with the soonest expiration date is: %s\n", products
                .stream()
                .filter(fp -> fp instanceof FoodProduct).filter(fp -> ((FoodProduct) fp).getInspiresInDays() < 5)
                .findFirst().get().getName());

        List<Product> productsWithAdultRestrictionSortedByPrice = products
                .stream()
                .filter(p -> p.getAgeRestriction() == Product.AgeRestriction.ADULT)
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());

        System.out.println("The products with adult restriction sorted in ascending order are: ");
        for (Product p : productsWithAdultRestrictionSortedByPrice) {
            System.out.printf("%s, price %.2f $\n", p.getName(), p.getPrice());
        }
    }

    public static class PurchaseManager {
        private static double earnings;

        public static void processPurchase(Product product, Customer customer) throws AdultException,
                NotEnoughMoneyException, TeenageException, OutOfStockException, ProductExpiredException {

            if (customer.getBalance() < product.getPrice()) {
                throw new NotEnoughMoneyException(String.format("%s, You do not have enough money to buy '%s': have %.2f $, want %.4f $",
                        customer.getName(),
                        product.getName(),
                        customer.getBalance(),
                        product.getPrice()));
            }
            if ((product.getAgeRestriction() == Product.AgeRestriction.ADULT) && customer.getAge() < 19) {
                throw new AdultException(String.format("%s, You are too young to buy '%s': have %d, want > 19",
                        customer.getName(),
                        product.getName(),
                        customer.getAge()));
            }
            if ((product.getAgeRestriction() == Product.AgeRestriction.TEENAGER) && customer.getAge() < 13) {
                throw new TeenageException(String.format("%s, You are too childish to buy '%s': have %d, want > 13",
                        customer.getName(),
                        product.getName(),
                        customer.getAge()));
            }
            if (product.getQuantity() <= 0) {
                throw new OutOfStockException(String.format("%s, You can't buy '%s'. The product is out of stock", customer.getName(), product.getName()));
            }
            if (product instanceof FoodProduct) {
                if (((FoodProduct) product).getInspiresInDays() <= 0) {
                    throw new ProductExpiredException(String.format("%s, You can't buy '%s'. The product is inspired. Sorry", customer.getName(), product.getName()));
                }
            }

            customer.subtractBalance(product.getPrice());
            earnings += product.getPrice();
            product.decrementQuantity();
        }

        public static double getEarnings() {
            return earnings;
        }
    }

}

