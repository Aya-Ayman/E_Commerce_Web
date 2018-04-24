/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_transfer_layer;

import java.io.InputStream;
import java.io.Serializable;

/**
 *
 * @author Hesham
 * @author asmaa
 */
public class Product_DTO implements Serializable {

    private int id;
    private String name;
    private float price;
    private int quantity;
    private InputStream image;
    private String category;
    private int myQuantity;
    private Long myTotalPrice;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product_DTO() {

    }

    public Product_DTO(String name, float price, int quantity, InputStream image, String category, String description) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.category = category;
        this.description = description;
    }

    public Product_DTO(int id, String name, float price, int quantity, InputStream image, String category, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.category = category;
        this.description = description;
    }

    public Product_DTO(int id, String name, float price, int quantity, String category, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.description = description;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }

    public int getMyQuantity() {
        return myQuantity;
    }

    public void setMyQuantity(int myQuantity) {
        this.myQuantity = myQuantity;
    }

    public Long getMyTotalPrice() {
        return myTotalPrice;
    }

    public void setMyTotalPrice(Long myTotalPrice) {
        this.myTotalPrice = myTotalPrice;
    }

}
