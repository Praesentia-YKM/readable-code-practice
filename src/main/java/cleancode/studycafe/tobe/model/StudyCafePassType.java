package cleancode.studycafe.tobe.model;

public enum StudyCafePassType {

    HOURLY("시간 단위 이용권"),
    WEEKLY("주 단위 이용권"),
    FIXED("1인 고정석");

    private final String description;

    StudyCafePassType(String description) {
        this.description = description;
    }

    public String getDescription(int duration, int price) {
        return String.format("%s %d권 - %d원", this.description, duration, price);
    }
}
