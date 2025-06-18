package com.umdearborn;

public class Client {
    public static void main(String[] args) {
        Order order = new Order(1);
        order.attach(new PriceObserver());
        order.attach(new QuantityObserver());

        System.out.println(order);

        System.out.println("Adding one item of value $50");
        order.addItem(50);
        System.out.println("New total: $" + order.getTotalPrice());

        System.out.println("Adding one item of value $60");
        order.addItem(60);
        System.out.println("New total: $" + order.getTotalPrice());

        System.out.println("Adding one item of value $70");
        order.addItem(70);
        System.out.println("New total: $" + order.getTotalPrice());

        System.out.println("Adding one item of value $40");
        order.addItem(40); // Total = 220 -> triggers price discount
        System.out.println("New total: $" + order.getTotalPrice());

        System.out.println("Adding one item of value $10");
        order.addItem(10);
        System.out.println("New total: $" + order.getTotalPrice());

        System.out.println("Adding one item of value $5");
        order.addItem(5);  // Total items = 6 -> triggers free shipping

        System.out.println(order);
    }
}