package ru.vtb.javapro.homework.model;

public class UserProductResponse {

    private Long productId;

    private String product;


    public UserProductResponse(Long productId, String product, String productType, String name, String accountNumber, Double balance) {
        this.productId = productId;
        this.product = product;
        this.productType = productType;
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    private String productType;

    private String name;

    private String accountNumber;

    private Double balance;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}

