/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photo_business_layer;

import data_access_layer.DAO.User_DAO;
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
@WebServlet(name = "ProfilePhotoServlet", urlPatterns = {"/ProfilePhotoServlet"})

public class ProfilePhotoServlet extends HttpServlet {

    private final String TAG = this.getClass().getName() + ": ";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        byte[] user_Image = null;

        try {

            // retrieving product information to start database connection and retrieve it \\
            String email = request.getParameter("email");

            // start the connection and retreive the image byte array \\
            DatabaseManager dbManeger = new DatabaseManager();
            User_DAO user_dao = new User_DAO();
            Connection con = dbManeger.getCon();
            user_Image = user_dao.getImageAsBytes(email);
            con.close();
        } catch (SQLException ex) {
            System.out.println(TAG + ex.getMessage());

        }

        if (user_Image != null) {
            response.getOutputStream().write(user_Image);
        }

    }
}
