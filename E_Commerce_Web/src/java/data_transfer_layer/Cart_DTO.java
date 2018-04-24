/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_transfer_layer;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author abdalla
 */
public class Cart_DTO implements Serializable{
    private  ArrayList<Product_DTO> productList ;
    private float totalPrice;
    private int totalQuantity;
    private int cartLength;

    public ArrayList<Product_DTO> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product_DTO> productList) {
        this.productList = productList;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }



    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getCartLength() {
        return cartLength;
    }

    public void setCartLength(int cartLength) {
        this.cartLength = cartLength;
    }


    
        
    
}
