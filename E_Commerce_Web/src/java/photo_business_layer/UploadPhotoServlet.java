/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photo_business_layer;

import data_access_layer.DAO.User_DAO;
import data_access_layer.database_manager.DatabaseManager;
import data_transfer_layer.User_DTO;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asmaa
 */
@WebServlet(name = "UploadPhotoServlet", urlPatterns = {"/UploadPhotoServlet"})
@MultipartConfig(maxFileSize = 16177215)
public class UploadPhotoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        try {
            // get user image and password attributes from request \\

            InputStream image = (InputStream) request.getAttribute("image");
            String email = (String) request.getAttribute("email");

            User_DAO user_dao = new User_DAO();
            User_DTO user_dto = new User_DTO();
            DatabaseManager dbManeger = new DatabaseManager();
            Connection con = dbManeger.getCon();

            // set image and email to a DTO user object and send it to database \\
            user_dto.setEmail(email);
            user_dto.setImage(image);

            user_dao.updateUserImg(user_dto, con);
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(UploadPhotoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getRequestDispatcher("/Login").forward(request, response);
    }
}
