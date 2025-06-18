package com.umdearborn;

public class QuantityObserver implements OrderObserver {
    @Override
    public void update(Order order) {
        if (order.getCount() > 5) {
            System.out.println("Free shipping applied.");
            order.setShippingCost(0);
        } else {
            order.setShippingCost(10);
        }
    }
}