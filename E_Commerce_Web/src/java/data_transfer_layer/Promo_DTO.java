/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_transfer_layer;

import java.io.Serializable;

/**
 *
 * @author asmaa
 */
public class Promo_DTO implements Serializable{
    
    private Long cartNumber;
    private String promoNumber;

    public Long getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(Long cartNumber) {
        this.cartNumber = cartNumber;
    }

    public String getPromoNumber() {
        return promoNumber;
    }

    public void setPromoNumber(String promoNumber) {
        this.promoNumber = promoNumber;
    }
    
    
    
}
