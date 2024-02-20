package org.example.model;

public class CartRequest {
    private Long productId;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public Long getProductId() {
        return productId;
    }
}

