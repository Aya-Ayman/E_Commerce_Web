/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home_page_business_layer;

import data_access_layer.DAO.Product_DAO;
import data_access_layer.database_manager.DatabaseManager;
import data_transfer_layer.Product_DTO;
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

@WebServlet(name = "SingleServlet", urlPatterns = {"/SingleServlet"})
public class SingleServlet extends HttpServlet {

    private final String TAG = this.getClass().getName() + ": ";
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     String single = request.getParameter("single").trim();
      Product_DAO productImp = new Product_DAO();
        DatabaseManager managerObj = new DatabaseManager();
        Connection con = managerObj.getCon();
        Product_DTO obj = new Product_DTO();
       obj= productImp.retreiveById(Integer.parseInt(single), con);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(TAG + ex.getMessage());
        }
//        ui.afterSearchProduct(request);
        request.setAttribute("obj", obj);
        request.getRequestDispatcher("single.jsp").forward(request, response);
    }
    
     @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     String single = request.getParameter("singleee").trim();
      Product_DAO productImp = new Product_DAO();
        DatabaseManager managerObj = new DatabaseManager();
        Connection con = managerObj.getCon();
        Product_DTO obj = new Product_DTO();
       obj= productImp.retreiveById(Integer.parseInt(single), con);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(TAG + ex.getMessage());
        }
//        ui.afterSearchProduct(request);
        request.setAttribute("obj", obj);
        request.getRequestDispatcher("RedirectSingle").forward(request, response);
    }
    
}
