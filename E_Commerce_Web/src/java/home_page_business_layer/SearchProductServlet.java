/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home_page_business_layer;

import data_access_layer.DAO.Product_DAO;
import data_access_layer.database_manager.DatabaseManager;
import data_transfer_layer.Product_DTO;
import handle_ui_package.HandleUI;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author asmaa
 */
@WebServlet(name = "SearchProductServlet", urlPatterns = {"/SearchProductServlet"})

public class SearchProductServlet extends HttpServlet {

    private final String TAG = this.getClass().getName() + ": ";

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // check user or visitor existance to handle the UI \\
        HandleUI ui = new HandleUI();
        ui.checkUI(request);

        String search = request.getParameter("search").trim();
        String from =request.getParameter("from").trim();
        String to=request.getParameter("to").trim();
        System.out.println("cat:  " +search +" _from : " +from +" _to: "+to);

        Product_DAO productImp = new Product_DAO();
        DatabaseManager managerObj = new DatabaseManager();
        Connection con = managerObj.getCon();
        ArrayList<Product_DTO> product = new ArrayList<>();
        if ( to.isEmpty() &&  from.isEmpty()) {
            product=(productImp.retreiveOnlyName(search, con));
        } else{
             product=(productImp.retreivePrice(search, from,to, con));
        }
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(TAG + ex.getMessage());
        }
        ui.afterSearchProduct(request);
        request.setAttribute("productName", product);
        request.getRequestDispatcher("Home-Page/Home.jsp").forward(request, response);
    }

}
