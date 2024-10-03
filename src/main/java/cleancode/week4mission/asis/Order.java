package cleancode.week4mission.asis;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

// Order 클래스
class Order {
    private List<Item> items; // 주문 항목 리스트
    private double totalPrice; // 총 가격
    private Customer customer; // 고객 정보

    public Order() {
        this.items = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
        this.totalPrice += item.getPrice(); // 아이템 추가 시 총 가격 업데이트
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public boolean hasCustomerInfo() {
        return customer != null;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}