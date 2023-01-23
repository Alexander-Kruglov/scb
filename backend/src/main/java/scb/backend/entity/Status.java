package scb.backend.entity;

public enum Status {
    QUEUE("В очереди"),
    HANDLING("Послупил в обработку"),
    DELIVERY("Доставка курьером"),
    FINISHED("Доставлено");

    private final String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
