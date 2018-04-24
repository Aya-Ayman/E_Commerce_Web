/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photo_business_layer;

import data_access_layer.DAO.Product_DAO;
import data_access_layer.database_manager.DatabaseManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asmaa
 */
@WebServlet(name = "DisplayPhotoServlet", urlPatterns = {"/DisplayPhotoServlet"})

public class DisplayPhotoServlet extends HttpServlet {

    private final String TAG = this.getClass().getName() + ": ";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        byte[] product_Image = null;

        try {

            // retrieving product information to start database connection and retrieve it \\
            Integer id = new Integer(request.getParameter("id"));

            // start the connection and retreive the image byte array \\
            DatabaseManager dbManeger = new DatabaseManager();
            Product_DAO product_dao = new Product_DAO();
            Connection con = dbManeger.getCon();
            product_Image = product_dao.getImageAsBytes(id);
            con.close();
        } catch (SQLException ex) {
            System.out.println(TAG + ex.getMessage());
        }

        if (product_Image != null) {
            response.getOutputStream().write(product_Image);
        }
    }
}
