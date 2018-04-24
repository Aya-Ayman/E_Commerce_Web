/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_access_layer.DAO;

import static constants_package.Constants.ALL;
import static constants_package.Constants.EQUAL;
import static constants_package.Constants.FROM;
import static constants_package.Constants.PRODUCT_NAME;
import static constants_package.Constants.PRODUCT_TABLE_NAME;
import static constants_package.Constants.SELECT;
import static constants_package.Constants.WHERE;
import data_access_layer.database_manager.DatabaseManager;
import data_access_layer.interfaces.Cart_Dao_Interface;
import data_transfer_layer.Cart_DTO;
import data_transfer_layer.Product_DTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdalla
 */
public class Cart_DAO implements Cart_Dao_Interface , Serializable{
         private PreparedStatement st;
    private ResultSet rs;
    private DatabaseManager managerObj;
    private final Connection con;
    private Statement s;
    private String selectState, deleteState, updateState, insertState;
    
    public Cart_DAO() {
        managerObj = new DatabaseManager();
        this.con = managerObj.getCon();
    }

    @Override
    public int create(Cart_DTO obj, Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cart_DTO retreive(String email, Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Cart_DTO obj, Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Cart_DTO obj, Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    // get id by name  abdalla 2/15
    public Product_DTO  getProduct(String name, Connection con){
        int id=-1;
                Product_DTO obj = null;
        try {
            selectState = SELECT + ALL + FROM + PRODUCT_TABLE_NAME
                    + WHERE + PRODUCT_NAME + EQUAL + " '" + name  + "' ";
            s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = s.executeQuery(selectState);
            if (rs.next()) {
                obj = new Product_DTO();
                obj.setId(rs.getInt(1));
                obj.setName(rs.getString(2));
                obj.setPrice(rs.getFloat(3));
                obj.setQuantity(rs.getInt(4));
                obj.setImage(rs.getBinaryStream(5));
                obj.setCategory(rs.getString(6));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(User_DAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return obj;
        
        
        
      

    }
    
    
}
