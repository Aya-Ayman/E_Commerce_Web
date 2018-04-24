/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_access_layer.interfaces;

import data_transfer_layer.Product_DTO;
import data_access_layer.generic_interface.GInterface;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Hesham
 */
public interface Product_Dao_Interface extends GInterface<Product_DTO> {

    @Override
    public int create(Product_DTO obj, Connection con);

    @Override
    public Product_DTO retreive(String name, Connection con);

    @Override
    public int update(Product_DTO obj, Connection con);

    @Override
    public int delete(Product_DTO obj, Connection con);

    ArrayList<Product_DTO> getAllProducts();

}
