package scb.backend.dto;

import jakarta.validation.constraints.*;

public class DeliveryDto {

    private Long id;
    @NotEmpty(message = "Product should not be null or empty")
    private String orderProduct;
    @PositiveOrZero(message = "Price should be >= 0")
    private Double orderPrice;
    @NotEmpty(message = "Status should not be null or empty")
    private String status;
    @NotEmpty(message = "Client name should not be null or empty")
    private String clientName;
    @NotEmpty(message = "Client address should not be null or empty")
    private String clientAddress;
    @NotEmpty(message = "Client phone number should not be null or empty")
    private String clientNumber;

    private String creator;

    public DeliveryDto() {
    }

    public DeliveryDto(String orderProduct, Double orderPrice, String status, String clientName, String clientAddress, String clientNumber, String creator) {
        this.orderProduct = orderProduct;
        this.orderPrice = orderPrice;
        this.status = status;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.clientNumber = clientNumber;
        this.creator = creator;
    }

    public DeliveryDto(Long id, String orderProduct, Double orderPrice, String status, String clientName, String clientAddress, String clientNumber, String creator) {
        this(orderProduct, orderPrice, status, clientName, clientAddress, clientNumber, creator);
        this.id = id;
    }

    public String getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(String orderProduct) {
        this.orderProduct = orderProduct;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
