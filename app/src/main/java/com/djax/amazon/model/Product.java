package com.djax.amazon.model;

import android.net.Uri;

public class Product {

    String productId;
    String productName;
    int price;
    int productImage;
     int qnt;
     int totalSingleQuantity;


    public Product(String productId, String productName, int price, int productImage,int qnt) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.productImage = productImage;
        this.qnt = qnt;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }



    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public int getTotalSingleQuantity() {
        return totalSingleQuantity;
    }

    public void setTotalSingleQuantity(int totalSingleQuantity) {
        this.totalSingleQuantity = totalSingleQuantity;
    }
}
