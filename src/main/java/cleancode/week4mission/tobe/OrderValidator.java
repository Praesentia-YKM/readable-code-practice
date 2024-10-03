package cleancode.week4mission.tobe;

import java.util.logging.Logger;

public class OrderValidator {
    private static final Logger log = Logger.getLogger(OrderValidator.class.getName());

    public boolean validateOrder(Order order) {
        validateEmptyOrder(order);
        validateTotalPrice(order);
        validateCustomerInfo(order);

        log.info("주문 검증이 완료되었습니다.");
        return true;
    }

    private void validateEmptyOrder(Order order) {
        if (order.isEmptyOrder()) {
            log.info("사용자가 주문항목 없이 주문하려고 함");
            throw new OrderValidationException("주문 항목이 없습니다.");
        }
    }

    private void validateTotalPrice(Order order) {
        if (order.isInvalidTotalPrice()) {
            log.info("사용자가 add한 모든 주문항목이 0이하임");
            throw new OrderValidationException("올바르지 않은 총 가격입니다.");
        }
    }

    private void validateCustomerInfo(Order order) {
        if (order.isMissingCustomerInfo()) {
            log.info("필수 사용자 정보 입력을 누락함");
            throw new OrderValidationException("사용자 정보가 없습니다.");
        }
    }

//    private void validateCondition(boolean condition, String errorMessage, String logMessage) {
//        if (condition) {
//            log.info(logMessage);
//            throw new OrderValidationException(errorMessage);
//        }
//    }
}

