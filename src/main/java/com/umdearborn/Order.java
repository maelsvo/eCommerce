package com.umdearborn;

import java.util.List;

public class Order {
    private int id;
    private int itemCount;
    private double itemCost;
    private double shippingCost;
    private List<OrderObserver> observers;

    public void attach(OrderObserver observer) {}
    public void detach(OrderObserver observer) {}
    public void notifyObservers() {}
    public void addItem(double price) {}
}

