/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_access_layer.DAO;

import data_access_layer.database_manager.DatabaseManager;
import data_access_layer.interfaces.Admin_Dao_Interface;
import data_transfer_layer.Admin_DTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hesham
 */
public class Admin_DAO implements Admin_Dao_Interface , Serializable{
     private PreparedStatement st;
    private ResultSet rs;
    private DatabaseManager managerObj;
    private final Connection con;
    private Statement s;

public Admin_DAO() {
        managerObj = new DatabaseManager();
        this.con = managerObj.getCon();
    }

    public Admin_DAO(String driverClassName, String dbURL, String user, String password) throws SQLException, ClassNotFoundException {
        Class.forName(driverClassName);
        con = DriverManager.getConnection(dbURL, user, password);
    }

    public void shutdown() throws SQLException {
        if (con != null) {
            con.close();
        }
    }
    

    @Override
    public int create(Admin_DTO obj, Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Admin_DTO retreive(String email, Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Admin_DTO obj, Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Admin_DTO obj, Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
public Admin_DTO retreiveByEmailAndPass(String email,String password, Connection con) {
        Admin_DTO obj = null;
        try {
               
            s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = s.executeQuery(" SELECT * " + " FROM WEBADMIN " + " WHERE email  = '" + email + "' AND password = '"+password+"'");
            if (rs.next()) {
                 obj=new Admin_DTO();
                 obj.setEmail(rs.getString(1));
                obj.setPassword(rs.getString(2));
                
            }
        } catch (Exception x) {
            x.printStackTrace();
        } finally {
            try {
                s.close();
                //rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Admin_DTO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return obj;
    }
    
    
}
