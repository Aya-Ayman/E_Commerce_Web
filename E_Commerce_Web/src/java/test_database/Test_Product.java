/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_database;

import data_access_layer.DAO.Product_DAO;
import data_access_layer.database_manager.DatabaseManager;
import data_transfer_layer.Product_DTO;
import java.sql.SQLException;

/**
 *
 * @author Hesham
 */
public class Test_Product {

    public static void main(String[] args) throws SQLException {

        Product_DAO dao = new Product_DAO();
        int output;
        Product_DTO obj = new Product_DTO();
        DatabaseManager base = new DatabaseManager();
        obj.setName("Food");
        obj.setPrice(999.3545f);
        obj.setQuantity(20);
        obj.setImage(null);
        obj.setCategory("myCat");

        /* create */
       /*
        Connection con = base.getCon();
        output = dao.create(obj, con);
        System.out.println(output);
        con.close();
        
        
        /*
        retreive

        Connection con = base.getCon();
        Product_DTO p;
        p = dao.retreive("Food", con);
        System.out.println(p.getName() + " , " + obj.getPrice());
        con.close();
         */
        
        
        /*
        getAllProducts
  
        Connection con = base.getCon();
        ArrayList<Product_DTO> productList;
        productList = dao.getAllProducts();
        for(int i=0 ; i < productList.size() ; i++){
            Product_DTO product = productList.get(i);
            System.out.println(product.getName() + " , " + product.getPrice() + " , " + product.getQuantity() );
        }
        con.close();
        */
        
        
        /*
        update

        Connection con = base.getCon();
        output = dao.update(obj, con);
        con.close();
        
        */
        
        /*
        delete
        
        Connection con = base.getCon();
        output = dao.delete(obj, con);
        System.out.println(output);
        con.close();
        */

    }

}
