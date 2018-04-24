/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_access_layer.interfaces;

import data_access_layer.generic_interface.GInterface;
import data_transfer_layer.Admin_DTO;
import java.sql.Connection;

/**
 *
 * @author Hesham
 */
public interface Admin_Dao_Interface extends GInterface<Admin_DTO>{
    
    @Override
    public int create(Admin_DTO obj, Connection con);

    @Override
    public Admin_DTO retreive(String email, Connection con);

    @Override
    public int update(Admin_DTO obj, Connection con);

    @Override
    public int delete(Admin_DTO obj, Connection con);
    
}
