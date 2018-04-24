/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_access_layer.DAO;

import data_transfer_layer.User_DTO;
import data_access_layer.database_manager.DatabaseManager;
import data_access_layer.interfaces.User_Dao_Interface;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
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
 * @author abdalla
 */
//implements Serializable
public class User_DAO implements User_Dao_Interface, Serializable {

    private PreparedStatement st;
    private ResultSet rs;
    private DatabaseManager managerObj;
    private final Connection con;
    private Statement s;

    public User_DAO() {
        managerObj = new DatabaseManager();
        this.con = managerObj.getCon();
    }

    public User_DAO(String driverClassName, String dbURL, String user, String password) throws SQLException, ClassNotFoundException {
        Class.forName(driverClassName);
        con = DriverManager.getConnection(dbURL, user, password);
    }

    public void shutdown() throws SQLException {
        if (con != null) {
            con.close();
        }
    }

    @Override
    public int create(User_DTO obj, Connection con) {

        try {

            st = con.prepareStatement("INSERT  INTO webUser (first_name ,last_name ,Bdate ,email ,Password ,job ,credit_limit ,address , Image )VALUES (?,?,?,?,?,?,?,?,?) ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            st.setString(1, obj.getFirst_name());
            st.setString(2, obj.getLast_name());
            st.setDate(3, obj.getDate());
            st.setString(4, obj.getEmail());
            st.setString(5, obj.getPassword());
            st.setString(6, obj.getJob());
            st.setLong(7, obj.getCredit_limit());
            st.setString(8, obj.getAddress());
            st.setBlob(9, obj.getImage());

            rs = st.executeQuery();
            rs = st.getResultSet();
            return 0;
        } catch (SQLException ex) {
            System.out.println("Email is Repeated !!");
            return -1;
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
    }

    @Override
    public User_DTO retreive(String email, Connection con) {
        User_DTO obj = null;
        try {
            s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = s.executeQuery(" SELECT * " + " FROM webUser " + " WHERE email  = '" + email + "'");
            if (rs.next()) {
                obj = new User_DTO();
                obj.setFirst_name(rs.getString(1));
                obj.setLast_name(rs.getString(2));
                obj.setDate(rs.getDate(3));
                obj.setEmail(rs.getString(4));
                obj.setPassword(rs.getString(5));
                obj.setJob(rs.getString(6));
                obj.setCredit_limit(rs.getLong(7));
                obj.setAddress(rs.getString(8));
                obj.setImage(rs.getBinaryStream(9));
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

        return obj;
    }

    public User_DTO retreiveByEmailAndPass(String email, String pass, Connection con) {
        User_DTO obj = null;
        try {
            s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = s.executeQuery(" SELECT * " + " FROM webUser " + " WHERE email  = '" + email + "' and password = '" + pass + "'");
            if (rs.next()) {
                obj = new User_DTO();
                obj.setFirst_name(rs.getString(1));
                obj.setLast_name(rs.getString(2));
                obj.setDate(rs.getDate(3));
                obj.setEmail(rs.getString(4));
                obj.setPassword(rs.getString(5));
                obj.setJob(rs.getString(6));
                obj.setCredit_limit(rs.getLong(7));
                obj.setAddress(rs.getString(8));
                obj.setImage(rs.getBinaryStream(9));
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

        return obj;
    }

    @Override
    public int update(User_DTO obj, Connection con) {

        try {
            st = con.prepareStatement("UPDATE webUser set first_name = ? ,last_name = ? ,Bdate = ? ,Password = ? ,job = ? ,credit_limit  = ? ,address  = ? ,Image  = ? where Email= ? ");

            st.setString(1, obj.getFirst_name());
            st.setString(2, obj.getLast_name());
            st.setDate(3, (Date) obj.getDate());
            st.setString(4, obj.getPassword());
            st.setString(5, obj.getJob());
            st.setLong(6, obj.getCredit_limit());
            st.setString(7, obj.getAddress());
            st.setBlob(8, obj.getImage());
            st.setString(9, obj.getEmail());
            rs = st.executeQuery();
            rs = st.getResultSet();

        } catch (Exception ex) {
            ex.printStackTrace();

            return -1;
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

        return 0;

    }

    @Override
    public int delete(User_DTO obj, Connection con) {
        try {
            s = con.createStatement();
            s.executeUpdate(" DELETE FROM webUser where Email = '" + obj.getEmail() + "'");
            //st.setString(1, obj.getEmail());
            // System.out.println("EmailSender: " + obj.getEmailSender() + " " + "EmailReciever: " + obj.getEmailReciever());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            if (obj.getEmail() != null) {
                // st.executeUpdate();
            } else {
                System.out.println(" No user to delete");
            }
            return 0;

            // } catch (SQLException ex) {
            //     ex.printStackTrace();
            //     return -1;
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

    }

    public ArrayList<User_DTO> retreiveListByEmail(String email, Connection con) {

        ArrayList<User_DTO> list = new ArrayList<User_DTO>();
        User_DTO obj = null;
        try {

            s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = s.executeQuery(" SELECT * " + " FROM webUser " + " WHERE email   Like '%" + email + "%'");
            while (rs.next()) {
                obj = new User_DTO();
                obj.setFirst_name(rs.getString(1));
                obj.setLast_name(rs.getString(2));
                obj.setDate(rs.getDate(3));
                obj.setEmail(rs.getString(4));
                obj.setPassword(rs.getString(5));
                obj.setJob(rs.getString(6));
                obj.setCredit_limit(rs.getLong(7));
                obj.setAddress(rs.getString(8));
                obj.setImage(rs.getBinaryStream(9));
                list.add(obj);
            }
        } catch (Exception x) {
            x.printStackTrace();
        } finally {

        }

        return list;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<User_DTO> retreiveList(Connection con) {

        ArrayList<User_DTO> list = new ArrayList<User_DTO>();
        User_DTO obj = null;
        try {

            s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = s.executeQuery(" SELECT * " + " FROM webUser ");
            while (rs.next()) {
                obj = new User_DTO();
                obj.setFirst_name(rs.getString(1));
                obj.setLast_name(rs.getString(2));
                obj.setDate(rs.getDate(3));
                obj.setEmail(rs.getString(4));
                obj.setPassword(rs.getString(5));
                obj.setJob(rs.getString(6));
                obj.setCredit_limit(rs.getLong(7));
                obj.setAddress(rs.getString(8));
                obj.setImage(rs.getBinaryStream(9));
                list.add(obj);
            }
        } catch (Exception x) {
            x.printStackTrace();
        } finally {

        }

        return list;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //hesham 14/2/2018\\
    public void updateUserImg(User_DTO user, Connection con) {
        InputStream inputStream = null; // input stream of the upload file

        String message = null;
        try {

            String sql = "update webuser set image =? where email =?";//(product_id,name, price, quantity ,image) values (pt_seq.NEXTVAL,?, ?, ? ,?)";
            PreparedStatement statement = con.prepareStatement(sql);

            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                statement.setBlob(1, user.getImage());
            }
            statement.setString(2, user.getEmail());

            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
                System.out.println(message);
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            System.out.println(message);
            ex.printStackTrace();
        } finally {
            if (con != null) {
                // closes the database connection
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    //hesham 14/2/2018\\
    public byte[] getImageAsBytes(String email) {

        byte[] image = null;

        try {
            st = con.prepareStatement("select image from webuser where email=?");
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                image = rs.getBytes("IMAGE");
                System.out.println("********Image Found********");
            }
            System.out.println("********Image********");
        } catch (SQLException ex) {
            Logger.getLogger(Product_DAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("********Catch from get Image Byte Array********");
        }
        return image;
    }
    
    public int updateWithoutImage(User_DTO obj , Connection con){
        try {
            st = con.prepareStatement("UPDATE webUser set first_name = ? ,last_name = ? ,Bdate = ? ,Password = ? ,job = ? ,credit_limit  = ? ,address  = ? where Email= ? ");

            st.setString(1, obj.getFirst_name());
            st.setString(2, obj.getLast_name());
            st.setDate(3, (Date) obj.getDate());
            st.setString(4, obj.getPassword());
            st.setString(5, obj.getJob());
            st.setLong(6, obj.getCredit_limit());
            st.setString(7, obj.getAddress());
            st.setString(8, obj.getEmail());
            rs = st.executeQuery();
            rs = st.getResultSet();

        } catch (Exception ex) {
            ex.printStackTrace();

            return -1;
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

        return 0;
    }

    public void updateCredit_limit(User_DTO user, Connection con) {
        
    }

}
