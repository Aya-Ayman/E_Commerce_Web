/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_layer.cart;

import data_access_layer.DAO.Product_DAO;
import data_access_layer.DAO.User_DAO;
import data_access_layer.database_manager.DatabaseManager;
import data_transfer_layer.Cart_DTO;
import data_transfer_layer.Product_DTO;
import data_transfer_layer.User_DTO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author abdalla
 */
@WebServlet(name = "CartController", urlPatterns = {"/CartController"})
public class CartController extends HttpServlet {

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
        System.out.println("processRequest");
        request.getRequestDispatcher("RedirectCart").forward(request, response);

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
        System.out.println("doGet");

        String theCommand = request.getParameter("cartCommand");

        if (theCommand == null) {
            theCommand = "LIST";
        }
        switch (theCommand) {
            case "CartLIST":
                processRequest(request, response);
                break;
            case "PAYMENT":
                payment(request, response);
                break;
            case "RRMOVE":
                removeProductFromCart(request, response);
                break;
            case "REMOVEALL":
                removeAllProductFromCart(request, response);
                break;
            case "RETRIEVEALL":
                retrieveAllProductFromCart(request, response);
            default:
                processRequest(request, response);
        }
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

    private void addProductToCart(HttpServletRequest request, HttpServletResponse response) {
        request.getSession(false).getAttribute("User");
    }

    private void removeProductFromCart(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void removeAllProductFromCart(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void retrieveAllProductFromCart(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void payment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String check = (String) request.getSession(false).getAttribute("success");
        if (check.equals("false")) {
            System.out.println("payment");

            User_DTO user;
            user = (User_DTO) request.getSession(false).getAttribute("User");

            Cart_DTO cart;
            cart = (Cart_DTO) request.getSession(false).getAttribute("myCart");

            Product_DTO product;

            Product_DAO productImp = new Product_DAO();
            User_DAO UsertImp = new User_DAO();

            DatabaseManager managerObj = new DatabaseManager();
            Connection con = managerObj.getCon();

            if (checkAvailabilityUser(user, UsertImp, cart, con)
                    && checkAvailabilityProduct(cart, productImp, con)) {
                user.setCredit_limit((long) user.getCredit_limit() - (long) cart.getTotalPrice());
                UsertImp.updateWithoutImage(user, con);
                System.out.println("User Updated !!!");

                for (int i = 0; i < cart.getCartLength(); i++) {
                    product = productImp.retreive(cart.getProductList().get(i).getName(), con);
                    cart.getProductList().get(i).setQuantity(product.getQuantity() - cart.getProductList().get(i).getMyQuantity());
                    product.setQuantity(product.getQuantity() - cart.getProductList().get(i).getMyQuantity());
                    productImp.update(product, con);
                    System.out.println(" for(int i=0;i<cart.getCartLength();i++) done" + i + " getCartLength " + cart.getCartLength());

                }
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.getSession(false).setAttribute("success", "true");
                request.getRequestDispatcher("RedirectInvoice").forward(request, response);

            }
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            request.getSession(false).setAttribute("success", "false");
        }
                    processRequest(request, response);
        }

    

    public boolean checkAvailabilityUser(User_DTO user, User_DAO UsertImp, Cart_DTO cart, Connection con) {
        User_DTO checkUser;

        checkUser = UsertImp.retreive(user.getEmail(), con);
        if ((checkUser.getCredit_limit() - cart.getTotalPrice()) >= 0) {
            System.out.println("checkAvailabilityUser done");
            
            return true;
        } else {
            return false;
        }
    }
    
        public boolean checkAvailabilityUserError(HttpServletRequest request , User_DTO user, User_DAO UsertImp, Cart_DTO cart, Connection con) {
        User_DTO checkUser;

        checkUser = UsertImp.retreive(user.getEmail(), con);
        if ((checkUser.getCredit_limit() - cart.getTotalPrice()) >= 0) {
            System.out.println("checkAvailabilityUser done");          
            return true;
        } else {
            request.getSession(false).setAttribute("CreditState", "No enough Credit , You need " + (cart.getTotalPrice() - checkUser.getCredit_limit()) + " to continue payment operation..");
            return false;
        }
    }
    

    public boolean checkAvailabilityProduct(Cart_DTO cart, Product_DAO productImp, Connection con) {
        int checkCounter = 0;
        boolean check = false;
        for (int i = 0; i < cart.getCartLength(); i++) {
            Product_DTO checkUser;

            checkUser = productImp.retreive(cart.getProductList().get(i).getName(), con);
            if ((checkUser.getQuantity() - cart.getProductList().get(i).getMyQuantity()) >= 0) {
                checkCounter++;
            } else {
                check = false;
            }
        }
        if (checkCounter >= cart.getCartLength()) {
            System.out.println("checkAvailabilityProduct done");
            check = true;

        } else {
            check = false;
        }
        System.out.println(check);
        return check;
    }

    public boolean checkAvailabilityProductError(HttpServletRequest request , Cart_DTO cart, Product_DAO productImp, Connection con) {
        int checkCounter = 0;
        boolean check = false;
        ArrayList<String> errorMsgList = new ArrayList<>();
        
        for (int i = 0; i < cart.getCartLength(); i++) {
            Product_DTO checkUser;

            checkUser = productImp.retreive(cart.getProductList().get(i).getName(), con);
            if ((checkUser.getQuantity() - cart.getProductList().get(i).getMyQuantity()) >= 0) {
                checkCounter++;
            } else {
                errorMsgList.add("No enougn quantity , please decrease product "+
                        cart.getProductList().get(i).getName()+" to " +
                        checkUser.getQuantity()  +" to continue the payment");
                check = false;
            }
        }
        if (checkCounter >= cart.getCartLength()) {
            System.out.println("checkAvailabilityProduct done");
            check = true;

        } else {
            request.getSession(false).setAttribute("QuantityErrorList", errorMsgList);
            check = false;
        }
        System.out.println(check);
        return check;
    }
    
}
