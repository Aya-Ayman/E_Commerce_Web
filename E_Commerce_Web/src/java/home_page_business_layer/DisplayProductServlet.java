package home_page_business_layer;

import data_access_layer.DAO.Product_DAO;
import data_access_layer.database_manager.DatabaseManager;
import data_transfer_layer.Product_DTO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author asmaa
 */
@WebServlet(name = "DisplayProductServlet", urlPatterns = {"/DisplayProductServlet"})

public class DisplayProductServlet extends HttpServlet {

    private final String TAG = this.getClass().getName() + ": ";

    public DisplayProductServlet() {
        super();
    }

    /**
     *
     * @param request
     * @param response
     * @throws IOException
     */
    protected void displayProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Product_DAO productImp = new Product_DAO();
        DatabaseManager managerObj = new DatabaseManager();
        Connection con = managerObj.getCon();
        ArrayList<Product_DTO> product = productImp.getAllProducts();
        ArrayList<Product_DTO> productMan = productImp.getAllProductsMan();
        ArrayList<Product_DTO> productWomen = productImp.getAllProductsWomen();
        ArrayList<Product_DTO> productBag = productImp.getAllProductsBag();

        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(TAG + ex.getMessage());
        }
        request.setAttribute("productName", product);

        request.setAttribute("productNameMan", productMan);

        request.setAttribute("productNameWomen", productWomen);
        request.setAttribute("productNameBag", productBag);

        request.getRequestDispatcher("Home-Page/Home.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        displayProduct(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        displayProduct(request, response);
    }
}
