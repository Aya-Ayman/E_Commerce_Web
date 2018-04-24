/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_access_layer.DAO;

import data_access_layer.database_manager.DatabaseManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aya
 */
public class Interest_DAO {
   
     private PreparedStatement st;
    private ResultSet rs;
    private DatabaseManager managerObj;
    private final Connection con;
    private Statement s;

    public Interest_DAO() {
        managerObj = new DatabaseManager();
        this.con = managerObj.getCon();
    }

    public Interest_DAO(String driverClassName, String dbURL, String user, String password) throws SQLException, ClassNotFoundException {
        Class.forName(driverClassName);
        con = DriverManager.getConnection(dbURL, user, password);
    }

    public void shutdown() throws SQLException {
        if (con != null) {
            con.close();
        }
    }

    
    public int create(String email,String[] interest, Connection con) {

        int check = -1;
        try {
          for(int i=0;i<interest.length;i++)
          {
            st = con.prepareStatement("INSERT  INTO interests (interestemail,interest )VALUES (?,?) ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

//            st.setString(1, obj.getFirst_name());
//            st.setString(2, obj.getLast_name());

            st.setString(1, email );
            st.setString(2, interest[i]);
           

            rs = st.executeQuery();
            rs = st.getResultSet();
          }
         check = 0;
        }
        catch (SQLException ex) {
            Logger.getLogger(Interest_DAO.class.getName()).log(Level.SEVERE, null, ex);
            check =  -1;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(User_DAO.class.getName()).log(Level.SEVERE, null, ex);
            
                
            }
        }
        return check;
    }

        public ArrayList<String> retreive(String email, Connection con) {
        
            ArrayList<String> userInterests = new ArrayList<>();
            
        try {
            s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = s.executeQuery(" SELECT * " + " FROM interests " + " WHERE interestemail  = '" + email + "'");
            while (rs.next()) {
                userInterests.add(rs.getString("interest"));
            }
        } catch (Exception x) {
            x.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(User_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return userInterests;
    }

   

    public int delete(String email, Connection con) {
        int check = -1;
        try {
            s = con.createStatement();
            s.executeUpdate(" DELETE  FROM interests where interestemail = '" + email + "'");
            check =0;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            check = -1;
        }
       finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(User_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return check;
        
    }
}

        


    
    