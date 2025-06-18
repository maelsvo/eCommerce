package com.umdearborn;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private int itemCount;
    private double itemsCost;
    private double shippingCost = 10.0;
    private boolean discountApplied = false;

    private List<OrderObserver> observers = new ArrayList<>();

    public Order(int id) {
        this.id = id;
    }

    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    public void addItem(double price) {
        itemCount++;
        itemsCost += price;
        notifyObservers();
    }

    // Getters and setters
    public int getCount() {
        return itemCount;
    }

    public double getItemsCost() {
        return itemsCost;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double cost) {
        this.shippingCost = cost;
    }

    public void setItemsCost(double cost) {
        this.itemsCost = cost;
    }

    public int getId() {
        return id;
    }

    public double getTotalPrice() {
        return itemsCost + shippingCost;
    }

    public boolean isDiscountApplied() {
        return discountApplied;
    }

    public void setDiscountApplied(boolean discountApplied) {
        this.discountApplied = discountApplied;
    }

    // toString method to print Order details
    @Override
    public String toString() {
        return "Order ID: " + id + "\n" +
                "Items Count: " + itemCount + "\n" +
                "Total Item Cost: $" + itemsCost + "\n" +
                "Shipping Cost: $" + shippingCost + "\n" +
                "Discount Applied: " + (discountApplied ? "Yes" : "No") + "\n" +
                "Final Total: $" + getTotalPrice();
    }
}