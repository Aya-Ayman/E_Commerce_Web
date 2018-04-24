/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_access_layer.interfaces;

import data_transfer_layer.User_DTO;
import data_access_layer.generic_interface.GInterface;
import java.sql.Connection;

/**
 *
 * @author abdalla
 */
public interface User_Dao_Interface extends GInterface<User_DTO> {

    @Override
    public int create(User_DTO obj, Connection con);

    @Override
    public User_DTO retreive(String email, Connection con);

    @Override
    public int update(User_DTO obj, Connection con);

    @Override
    public int delete(User_DTO obj, Connection con);

}
