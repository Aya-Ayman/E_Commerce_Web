/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_layer.Admin;

import data_access_layer.DAO.Product_DAO;
import data_access_layer.DAO.Promo_DAO;
import data_access_layer.database_manager.DatabaseManager;
import data_transfer_layer.Product_DTO;
import data_transfer_layer.Promo_DTO;
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
import javax.servlet.http.Part;

/**
 *
 * @author abdalla
 * @author asmaa
 */
@WebServlet(name = "ProductControllerServlet", urlPatterns = {"/ProductControllerServlet"})
@MultipartConfig(maxFileSize = 16177215)

public class ProductControllerServlet extends HttpServlet {

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
        
        request.getRequestDispatcher("AdminServlet").forward(request, response);
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
        String theCommand = request.getParameter("command");
        
        if (theCommand == null) {
            theCommand = "LIST";
        }
        switch (theCommand) {
            case "LIST":
                processRequest(request, response);
                break;
            case "ADD":
                addProduct(request, response);
                break;
            case "LOAD":
                loadProduct(request, response);
                break;
            case "UPDATE":
                updateProduct(request, response);
                break;
            case "DELETE":
                deleteProduct(request, response);
                break;
//            case "PROMO":
//                addPromo(request, response);
//                break;
            default:
                processRequest(request, response);
                break;
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
        
        String theCommand = request.getParameter("command");
        
        if (theCommand == null) {
            theCommand = "LIST";
        }
        switch (theCommand) {
            case "LIST":
                processRequest(request, response);
                break;
            case "ADD":
                addProduct(request, response);
                break;
            case "LOAD":
                loadProduct(request, response);
                break;
            case "UPDATE":
                updateProduct(request, response);
                break;
            case "DELETE":
                deleteProduct(request, response);
                break;
//            case "PROMO":
//                System.out.println("switchhhh");
//                addPromo(request, response);
//                break;

            default:
                processRequest(request, response);
                break;
        }
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

    private void addPromo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("addPromo");
        String number = request.getParameter("credit");
        String promo = request.getParameter("promoAdmin");
        Long promoLong = new Long(number);
        Promo_DAO promoDao = new Promo_DAO();
        Promo_DTO promoObj = new Promo_DTO();
        
        DatabaseManager managerObj = new DatabaseManager();
        Connection con = managerObj.getCon();
        int isDone;
        if (!number.isEmpty()) {
            promoObj.setCartNumber(promoLong);
        } else {
            promoLong = new Long(100000);
        }
        promoObj.setCartNumber(promoLong);
        promoObj.setPromoNumber(promo);
        isDone = promoDao.create(promoObj, con);
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
    
    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        System.out.println("addProduct");
        String name = request.getParameter("Name");
        String quantity = request.getParameter("Quantity");
        String price = request.getParameter("Price");
        String Category = request.getParameter("Category");
        String desc = request.getParameter("desc");
        
        Product_DTO product = new Product_DTO();
        product.setName(name);
        product.setQuantity(Integer.parseInt(quantity));
        product.setPrice(Float.parseFloat(price));
        product.setCategory(Category);
        product.setDescription(desc);
        
        InputStream inputStream = null; // input stream of the upload file
        Part filePart = request.getPart("imageUploading");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
        product.setImage(inputStream);
        
        Product_DAO productImp = new Product_DAO();
        DatabaseManager managerObj = new DatabaseManager();
        Connection con = managerObj.getCon();
        productImp.create(product, con);
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        processRequest(request, response);
        
    }
    
    private void loadProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        System.out.println("loadProduct");
        String productName = request.getParameter("productName");
        
        Product_DAO productImp = new Product_DAO();
        DatabaseManager managerObj = new DatabaseManager();
        Connection con = managerObj.getCon();
        Product_DTO product = productImp.retreive(productName, con);
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("theProduct", product);
        System.out.println("UpdateProductAdmin");
        request.getRequestDispatcher("Admin/UpdateProductAdmin.jsp").forward(request, response);
    }
    
    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        System.out.println("updateProduct");
        
        int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        float price = Float.parseFloat(request.getParameter("price"));
        String category = request.getParameter("category");
        String desc = request.getParameter("desc");
        
        InputStream inputStream = null; // input stream of the upload file
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("imageProduct");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
        
        Product_DAO productImp = new Product_DAO();
        DatabaseManager managerObj = new DatabaseManager();
        Connection con = managerObj.getCon();

//        Product_DTO product = new Product_DTO(productId, productName, price, quantity, inputStream, category);
        if (inputStream.available() != 0) {
            Product_DTO product = new Product_DTO(productId, productName, price, quantity, inputStream, category, desc);
            productImp.update(product, con);
            System.out.println("inputStream Found");
        } else {
            Product_DTO product = new Product_DTO(productId, productName, price, quantity, category, desc);
            productImp.updateProductWithoutImg(product, con);
            //productImp.retreiveById(product.getId(), con);
            System.out.println("inputStream Not Found");
        }
        
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("updateProductEnd");
        processRequest(request, response);
    }
    
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String theProductName = request.getParameter("productName");
        
        Product_DAO productImp = new Product_DAO();
        DatabaseManager managerObj = new DatabaseManager();
        Connection con = managerObj.getCon();
        Product_DTO product = new Product_DTO();
        product.setName(theProductName);
        productImp.delete(product, con);
        
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        processRequest(request, response);
    }
    
}
