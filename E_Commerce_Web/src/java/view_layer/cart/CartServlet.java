/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_layer.cart;

import business_layer.cart.CartController;
import data_access_layer.DAO.Cart_DAO;
import data_access_layer.DAO.Product_DAO;
import data_access_layer.database_manager.DatabaseManager;
import data_transfer_layer.Cart_DTO;
import data_transfer_layer.Product_DTO;
import handle_ui_package.HandleUI;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hesham
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HandleUI ui = new HandleUI();
        ui.checkUI(request);
        
        boolean flag = (boolean) request.getAttribute("cookieEnabled");
        if (flag) {
        
        Product_DAO productImp = new Product_DAO();
        DatabaseManager managerObj = new DatabaseManager();
        Connection con = managerObj.getCon();
        // get cart object
        Cart_DTO myCart = new Cart_DTO();
        Cart_DAO myCartImp = new Cart_DAO();

        //fill cart object with data
        String idx = request.getParameter("items_Length");

        System.out.println("idx : " + idx);
        int itemsLength = Integer.parseInt(idx);
        ArrayList<Product_DTO> list = new ArrayList<>();
        int mtTotalQuantity = 0;

//        if (itemsLength > 0) {
        for (int i = 1; i < itemsLength + 1; i++) {
            Product_DTO product = new Product_DTO();
            product = myCartImp.getProduct(request.getParameter("item_name_" + i), con);
            product.setName(request.getParameter("item_name_" + i));
            int quantity = Integer.parseInt(request.getParameter("quantity_" + i));
            product.setMyTotalPrice((long) product.getPrice() * quantity);
            mtTotalQuantity += quantity;
            product.setMyQuantity(quantity);
            list.add(product);
        }
        myCart.setCartLength(itemsLength);
        myCart.setProductList(list);
        System.out.println(request.getParameter("totalCartWithoutFormat"));
        myCart.setTotalPrice(Float.parseFloat(request.getParameter("totalCartWithoutFormat")));
        myCart.setTotalQuantity(mtTotalQuantity);
        request.getSession(false).setAttribute("myCart", myCart);
        request.getSession(false).setAttribute("myCartList", myCart.getProductList());

//        } else {
//             freeCart(myCart);
//             System.out.println("*******CART FREED*******");
//            System.out.println(request.getParameter("totalCartWithoutFormat"));
//            request.getSession(false).setAttribute("myCart", myCart);
//            request.getSession(false).setAttribute("myCartList", myCart.getProductList());
//        }
//abdalla 2/17
            CartController cartContriller = new CartController();
boolean freeFalg=cartContriller.checkAvailabilityProduct(myCart, productImp, con);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        //check if have session ot not
        try {
            HttpSession session = request.getSession(false);
            String checkValue = (String) session.getAttribute("display_btn");
            // if he has Dispatch to Cart else to Home


            //abdalla 2/17
            if (!freeFalg) {
              request.getRequestDispatcher("/RedirectMaintenance").forward(request, response);  
            } else if (checkValue.equals("ok")) {

                request.getRequestDispatcher("/RedirectCart").forward(request, response);
            } else {        // if he has Dispatch to Cart else to Home

                ui.checkUI(request);
                request.getRequestDispatcher("/RedirectErrorLogin").forward(request, response);
            }
        } catch (Exception e) {
            ui.checkUI(request);
            request.getRequestDispatcher("/RedirectErrorLogin").forward(request, response);
        }

                } else {
            RequestDispatcher dispather = request.getRequestDispatcher("/Cookies/noCookies.jsp");
            dispather.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void freeCart(Cart_DTO cart) {
        cart.setCartLength(0);
        cart.setProductList(new ArrayList<>());
        cart.setTotalPrice(Float.parseFloat("0.0"));
        cart.setTotalQuantity(0);
    }
}
