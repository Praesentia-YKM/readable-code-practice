package cleancode.week4mission.asis;

public class OrderMain {
    public static void main(String[] args) {
        // 주문 생성
        Order order = new Order();

        // 아이템 추가
        Item item1 = new Item("책", 1000.0);
        Item item2 = new Item("펜", 200.0);
        order.addItem(item1);
        order.addItem(item2);

        // 고객 정보 설정
        Customer customer = new Customer("kwonMo", "inflearn@naver.com");
        order.setCustomer(customer);

        // 검증 수행
        OrderValidator validator = new OrderValidator();
        boolean isValid = validator.validateOrder(order);
        System.out.println("주문 검증 결과: " + isValid);
    }
}
