/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_access_layer.interfaces;

import data_access_layer.generic_interface.GInterface;
import data_transfer_layer.Cart_DTO;
import data_transfer_layer.Promo_DTO;
import java.sql.Connection;

/**
 *
 * @author asmaa
 */
public interface Promo_Dao_Interface extends GInterface<Promo_DTO>{
    
    @Override
    public int create(Promo_DTO obj, Connection con);

    @Override
    public Promo_DTO retreive(String promoNumber, Connection con);

    @Override
    public int update(Promo_DTO obj, Connection con);

    @Override
    public int delete(Promo_DTO obj, Connection con);
}
