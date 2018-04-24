/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_layer.Admin;

import data_access_layer.DAO.Promo_DAO;
import data_access_layer.database_manager.DatabaseManager;
import data_transfer_layer.Promo_DTO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asmaa
 */
@WebServlet(name = "PromoCodeServlet", urlPatterns = {"/PromoCodeServlet"})

public class PromoCodeServlet extends HttpServlet {
    
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("addPromo");
        String number = request.getParameter("credit");
        String promo = request.getParameter("promoAdmin");
        Long promoLong = new Long(number);
        Promo_DAO promoDao = new Promo_DAO();
        Promo_DTO promoObj = new Promo_DTO();

            DatabaseManager managerObj = new DatabaseManager();
            Connection con = managerObj.getCon();
            int isDone;  
            promoObj.setCartNumber(promoLong);
            promoObj.setPromoNumber(promo);
            isDone = promoDao.create(promoObj, con);
            request.getRequestDispatcher("ProductControllerServlet").forward(request, response);
            if (isDone == 0) {
                //success
                System.out.println("done");

            } else {
                System.out.println("not done");

            }

            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
}
