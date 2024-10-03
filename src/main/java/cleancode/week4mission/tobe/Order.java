package cleancode.week4mission.tobe;

import java.util.ArrayList;
import java.util.List;

class Order {
    private final List<Item> items;
    private double totalPrice;
    private Customer customer;

    public Order() {
        this.items = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public boolean isEmptyOrder() {
        return items.isEmpty();
    }

    public boolean isInvalidTotalPrice() {
        return this.totalPrice <= 0;
    }

    public boolean isMissingCustomerInfo() {
        return customer == null;
    }

    public void addItem(Item item) {
        items.add(item);
        this.totalPrice += item.getPrice();
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
