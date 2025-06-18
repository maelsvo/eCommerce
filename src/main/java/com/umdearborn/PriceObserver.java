package com.umdearborn;

public class PriceObserver implements OrderObserver {
    @Override
    public void update(Order order) {
        if (order.getItemsCost() > 200 && !order.isDiscountApplied()) {
            System.out.println("Applying one-time $20 discount...");
            order.setItemsCost(order.getItemsCost() - 20);
            order.setDiscountApplied(true);
        }
    }
}
