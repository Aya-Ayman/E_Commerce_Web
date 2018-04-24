/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_access_layer.DAO;

import static constants_package.Constants.ALL;
import static constants_package.Constants.DELETE;
import static constants_package.Constants.EQUAL;
import static constants_package.Constants.FROM;
import static constants_package.Constants.INSERT;
import static constants_package.Constants.INTO;
import static constants_package.Constants.NEXTVAL;
import static constants_package.Constants.PRODUCT_CATEGORY;
import static constants_package.Constants.PRODUCT_ID;
import static constants_package.Constants.PRODUCT_IMAGE;
import static constants_package.Constants.PRODUCT_NAME;
import static constants_package.Constants.PRODUCT_PRICE;
import static constants_package.Constants.PRODUCT_QUANTITY;
import static constants_package.Constants.PRODUCT_TABLE_NAME;
import static constants_package.Constants.SELECT;
import static constants_package.Constants.SEQUENCE_KEY;
import static constants_package.Constants.SET;
import static constants_package.Constants.UPDATE;
import static constants_package.Constants.VALUES;
import static constants_package.Constants.WHERE;
import data_access_layer.database_manager.DatabaseManager;
import data_transfer_layer.Product_DTO;
import data_access_layer.interfaces.Product_Dao_Interface;
import java.io.InputStream;
import java.io.Serializable;
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
 * @author Hesham
 * @author asmaa
 */

/* 
 CREATE TABLE product
 (
 product_id number(8) NOT NULL,
 Name VARCHAR2(25) NOT NULL,
 price NUMBER(12,2) ,
 quantity NUMBER(8) ,
 image blob ,
 category VARCHAR2(25),
 description VARCHAR2(25),
 PRIMARY KEY (product_id)
 );   
    
                                    
 create sequence pt_seq ;
 */
public class Product_DAO implements Product_Dao_Interface, Serializable {

    private PreparedStatement st;
    private ResultSet rs;
    private DatabaseManager managerObj;
    private final Connection con;
    private Statement s;
    private String selectState, deleteState, updateState, insertState;

    public Product_DAO() {
        managerObj = new DatabaseManager();
        this.con = managerObj.getCon();
    }

    public Product_DAO(String driverClassName, String dbURL, String user, String password) throws SQLException, ClassNotFoundException {
        Class.forName(driverClassName);
        con = DriverManager.getConnection(dbURL, user, password);
    }

    public void shutdown() throws SQLException {
        if (con != null) {
            con.close();
        }
    }

    @Override
    public int create(Product_DTO obj, Connection con) {
        try {

            insertState = INSERT + INTO + PRODUCT_TABLE_NAME + "( " + PRODUCT_ID + " , "
                    + PRODUCT_NAME + " , " + PRODUCT_PRICE + " , " + PRODUCT_QUANTITY + " , "
                    + PRODUCT_IMAGE + " , " + PRODUCT_CATEGORY + " , description"
                    + " )" + VALUES + " ( " + SEQUENCE_KEY + NEXTVAL + " ,? , ? , ? , ? , ? ,?)";
            st = con.prepareStatement(insertState, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            st.setString(1, obj.getName());
            st.setFloat(2, obj.getPrice());
            st.setInt(3, obj.getQuantity());
            st.setBlob(4, obj.getImage());
            st.setString(5, obj.getCategory());
            st.setString(6, obj.getDescription());

            rs = st.executeQuery();
            rs = st.getResultSet();
            System.out.println("**PRODUCT ADDED**");
            System.out.println(insertState);
            System.out.println(obj.getName() + " " + obj.getPrice() + obj.getQuantity());
            return 0;
        } catch (Exception e) {
            Logger.getLogger(User_DAO.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Catch from create(Product_DTO obj, Connection con) , Product_DAO class");
            System.out.println("**Data may exists**");
            System.out.println(insertState);
            return -1;
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
    }

    public ArrayList<Product_DTO> retreiveOnlyName(String name, Connection con) {
        ArrayList<Product_DTO> productList = new ArrayList<>();

        Product_DTO obj = null;
        try {
            selectState = "select * from product where lower(name) like ? ";
            st = con.prepareStatement(selectState);
            st.setString(1, "%" + name.toLowerCase() + "%");
            rs = st.executeQuery();
            rs = st.getResultSet();
            while (rs.next()) {
                obj = new Product_DTO();
                obj.setId(rs.getInt(1));
                obj.setName(rs.getString(2));
                obj.setPrice(rs.getFloat(3));
                obj.setQuantity(rs.getInt(4));
                obj.setImage(rs.getBinaryStream(5));
                obj.setCategory(rs.getString(6));
                obj.setDescription(rs.getString(7));
                productList.add(obj);

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

        return productList;

    }

    @Override
    public Product_DTO retreive(String name, Connection con) {

        Product_DTO obj = null;
        try {
            selectState = SELECT + ALL + FROM + PRODUCT_TABLE_NAME
                    + WHERE + PRODUCT_NAME + EQUAL + " '" + name + "' ";
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
                obj.setDescription(rs.getString(7));

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

    //Asmaa 
    //select * from product where name like '%a%' and price >= 12 and price <= 5000
    public ArrayList<Product_DTO> retreivePrice(String name, String from, String to, Connection con) {
        ArrayList<Product_DTO> productList = new ArrayList<>();

        Product_DTO obj = null;
        try {
            selectState = "select * from product where lower(name) like ? and price >= ? and price <= ? ";
            st = con.prepareStatement(selectState);
            st.setString(1, "%" + name.toLowerCase() + "%");
            st.setFloat(2, Float.parseFloat(from));
            st.setFloat(3, Float.parseFloat(to));
            rs = st.executeQuery();
            rs = st.getResultSet();
            while (rs.next()) {
                obj = new Product_DTO();
                obj.setId(rs.getInt(1));
                obj.setName(rs.getString(2));
                obj.setPrice(rs.getFloat(3));
                obj.setQuantity(rs.getInt(4));
                obj.setImage(rs.getBinaryStream(5));
                obj.setCategory(rs.getString(6));
                obj.setDescription(rs.getString(7));

                productList.add(obj);

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

        return productList;

    }

    // hesham 14/2 \\
    public Product_DTO retreiveById(int id, Connection con) {

        Product_DTO obj = null;
        try {
            selectState = SELECT + ALL + FROM + PRODUCT_TABLE_NAME
                    + WHERE + PRODUCT_ID + EQUAL + id;
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
                obj.setDescription(rs.getString(7));

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

    //Asmaa 
    public int updateProductWithoutImg(Product_DTO obj, Connection con) {
        try {

            updateState = UPDATE + PRODUCT_TABLE_NAME + SET
                    + PRODUCT_NAME + EQUAL + " ? , "
                    + PRODUCT_PRICE + EQUAL + " ? , " + PRODUCT_QUANTITY + EQUAL + " ? , "
                    + PRODUCT_CATEGORY + EQUAL + " ?  " + " , description = ?"
                    + WHERE + PRODUCT_ID + EQUAL + " ?   ";

            st = con.prepareStatement(updateState);

            st.setString(1, obj.getName());
            st.setFloat(2, obj.getPrice());
            st.setInt(3, obj.getQuantity());
            st.setString(4, obj.getCategory());
            st.setString(5, obj.getDescription());
            st.setInt(6, obj.getId());

            System.out.println(updateState);

            rs = st.executeQuery();
            rs = st.getResultSet();

            System.out.println("**Product Updated**");
            System.out.println(updateState);
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
        //  s.execute(sql);
        //System.out.println(st.g);
        return 0;

    }

    //Asmaa 
    @Override
    public int update(Product_DTO obj, Connection con) {

        try {

            updateState = UPDATE + PRODUCT_TABLE_NAME + SET
                    + PRODUCT_NAME + EQUAL + " ? , "
                    + PRODUCT_PRICE + EQUAL + " ? , " + PRODUCT_QUANTITY + EQUAL + " ? , "
                    + PRODUCT_IMAGE + EQUAL + " ? , " + PRODUCT_CATEGORY + EQUAL + " ?  "
                    + " , description = ?"
                    + WHERE + PRODUCT_ID + EQUAL + " ?   ";

            st = con.prepareStatement(updateState);

            st.setString(1, obj.getName());
            st.setFloat(2, obj.getPrice());
            st.setInt(3, obj.getQuantity());
            st.setBlob(4, obj.getImage());
            st.setString(5, obj.getCategory());
            st.setString(6, obj.getDescription());
            st.setInt(7, obj.getId());

            System.out.println(updateState);

            rs = st.executeQuery();
            rs = st.getResultSet();

            System.out.println("**Product Updated**");
            System.out.println(updateState);
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
        //  s.execute(sql);
        //System.out.println(st.g);
        return 0;

    }

    @Override
    public int delete(Product_DTO obj, Connection con) {
        try {
            deleteState = DELETE + FROM + PRODUCT_TABLE_NAME + WHERE + PRODUCT_NAME + EQUAL + " '" + obj.getName() + "' ";
            s = con.createStatement();
            s.executeUpdate(deleteState);
            System.out.println("**PRODUCT DELETED**");

        } catch (SQLException ex) {
            System.out.println("Product " + obj.getName() + " not found , or error occured");
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
        return 1;
    }

    @Override
    public ArrayList<Product_DTO> getAllProducts() {
        ArrayList productList = new ArrayList<>();
        Product_DTO obj = null;
        try {
            selectState = SELECT + ALL + FROM + PRODUCT_TABLE_NAME;
            s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = s.executeQuery(selectState);
            while (rs.next()) {
                obj = new Product_DTO();
                obj.setId(rs.getInt(1));
                obj.setName(rs.getString(2));
                obj.setPrice(rs.getFloat(3));
                obj.setQuantity(rs.getInt(4));
                obj.setImage(rs.getBinaryStream(5));
                obj.setCategory(rs.getString(6));
                obj.setDescription(rs.getString(7));
                productList.add(obj);
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

        return productList;
    }

    public ArrayList<Product_DTO> getAllProductsBag() {
        ArrayList productList = new ArrayList<>();
        Product_DTO obj = null;
        try {
            selectState = SELECT + ALL + FROM + PRODUCT_TABLE_NAME + "where category ='bag'";
            s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = s.executeQuery(selectState);
            while (rs.next()) {
                obj = new Product_DTO();
                obj.setId(rs.getInt(1));
                obj.setName(rs.getString(2));
                obj.setPrice(rs.getFloat(3));
                obj.setQuantity(rs.getInt(4));
                obj.setImage(rs.getBinaryStream(5));
                obj.setCategory(rs.getString(6));
                obj.setDescription(rs.getString(7));
                productList.add(obj);
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

        return productList;
    }

    public ArrayList<Product_DTO> getAllProductsWomen() {
        ArrayList productList = new ArrayList<>();
        Product_DTO obj = null;
        try {
            selectState = SELECT + ALL + FROM + PRODUCT_TABLE_NAME + "where category ='women'";
            s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = s.executeQuery(selectState);
            while (rs.next()) {
                obj = new Product_DTO();
                obj.setId(rs.getInt(1));
                obj.setName(rs.getString(2));
                obj.setPrice(rs.getFloat(3));
                obj.setQuantity(rs.getInt(4));
                obj.setImage(rs.getBinaryStream(5));
                obj.setCategory(rs.getString(6));
                obj.setDescription(rs.getString(7));

                productList.add(obj);
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

        return productList;
    }

    public ArrayList<Product_DTO> getAllProductsMan() {
        ArrayList productList = new ArrayList<>();
        Product_DTO obj = null;
        try {
            selectState = SELECT + ALL + FROM + PRODUCT_TABLE_NAME + "where category ='man'";
            s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = s.executeQuery(selectState);
            while (rs.next()) {
                obj = new Product_DTO();
                obj.setId(rs.getInt(1));
                obj.setName(rs.getString(2));
                obj.setPrice(rs.getFloat(3));
                obj.setQuantity(rs.getInt(4));
                obj.setImage(rs.getBinaryStream(5));
                obj.setCategory(rs.getString(6));
                obj.setDescription(rs.getString(7));
                productList.add(obj);
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

        return productList;
    }

    //abdalla 2/9
    public ArrayList<Product_DTO> getAllProducts(Connection con) {
        ArrayList productList = new ArrayList<>();
        Product_DTO obj = null;
        try {
            selectState = SELECT + ALL + FROM + PRODUCT_TABLE_NAME;
            s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = s.executeQuery(selectState);
            while (rs.next()) {
                obj = new Product_DTO();
                obj.setId(rs.getInt(1));
                obj.setName(rs.getString(2));
                obj.setPrice(rs.getFloat(3));
                obj.setQuantity(rs.getInt(4));
                obj.setImage(rs.getBinaryStream(5));
                obj.setCategory(rs.getString(6));
                obj.setDescription(rs.getString(7));
                productList.add(obj);
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

        return productList;
    }

    //hesham 14/2/2018 for Asmaa\\
    public void updateProductImg(Product_DTO product, Connection con) {
        InputStream inputStream = null; // input stream of the upload file

        String message = null;
        try {

            String sql = UPDATE + PRODUCT_TABLE_NAME + SET + PRODUCT_IMAGE + EQUAL + " ? "
                    + WHERE + PRODUCT_ID + EQUAL + " ?";
            st = con.prepareStatement(sql);

            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                st.setBlob(1, product.getImage());
            }
            st.setInt(2, product.getId());

            // sends the statement to the database server
            int row = st.executeUpdate();
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
    public byte[] getImageAsBytes(int id) {

        byte[] image = null;

        try {
            String select = SELECT + PRODUCT_IMAGE + FROM + PRODUCT_TABLE_NAME
                    + WHERE + PRODUCT_ID + EQUAL + " ? ";
            st = con.prepareStatement(select);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                image = rs.getBytes("image");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Product_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return image;
    }

}
