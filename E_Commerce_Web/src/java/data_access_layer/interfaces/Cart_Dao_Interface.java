/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_access_layer.interfaces;


import data_access_layer.generic_interface.GInterface;
import data_transfer_layer.Cart_DTO;
import java.sql.Connection;

/**
 *
 * @author Hesham
 */
public interface Cart_Dao_Interface extends GInterface<Cart_DTO>{
    
    @Override
    public int create(Cart_DTO obj, Connection con);

    @Override
    public Cart_DTO retreive(String email, Connection con);

    @Override
    public int update(Cart_DTO obj, Connection con);

    @Override
    public int delete(Cart_DTO obj, Connection con);
    
}
