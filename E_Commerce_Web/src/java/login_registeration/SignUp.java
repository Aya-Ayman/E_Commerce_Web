package login_registeration;

import data_access_layer.DAO.Interest_DAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import data_access_layer.database_manager.DatabaseManager;
import java.sql.Connection;

import data_access_layer.DAO.User_DAO;

import data_transfer_layer.User_DTO;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aya
 * @author asmaa
 */
@MultipartConfig(maxFileSize = 16177215)
@WebServlet(name = "SignupServlet", urlPatterns = {"/Registeration"})
public class SignUp extends HttpServlet {

    int check;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RequestDispatcher requestDispatcher;
            PrintWriter out = response.getWriter();
            InputStream inputStream = null; // input stream of the upload file
            Date myDate = null;

            boolean flag = (boolean) request.getAttribute("cookieEnabled");
            if (flag) {

                // obtains the upload file part in this multipart request
                Part filePart = request.getPart("image2");
                if (filePart != null) {
                    // prints out some information for debugging
                    System.out.println(filePart.getName());
                    System.out.println(filePart.getSize());
                    System.out.println(filePart.getContentType());

                    // obtains input stream of the upload file
                    inputStream = filePart.getInputStream();
                }

                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String date = request.getParameter("Birth Date");
                String address = request.getParameter("Address");
                String job = request.getParameter("Job");
                String credit = request.getParameter("Credit Limit");
                Long creditLong = new Long(200);
                String[] interest = request.getParameterValues("interest");

                out.println(name + " " + email + " " + password + " " + address + " " + job + " " + credit + " " + date);
                out.println("Now you are registered !");

                // set a format to the date before sending to database \\
                try {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    java.util.Date uDate = format.parse(date + " 00:00:00");
                    myDate = new Date(uDate.getTime());
                    System.out.println(myDate);

                } catch (ParseException ex) {
                    Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                }

                DatabaseManager managerObj = new DatabaseManager();
                Connection con = managerObj.getCon();
                User_DTO user = new User_DTO();
                user.setFirst_name(name);
                user.setEmail(email);
                user.setAddress(address);
                user.setCredit_limit(creditLong);
                user.setJob(job);
                user.setPassword(password);
                user.setLast_name(null);
                user.setImage(inputStream);
                user.setDate(myDate);
                User_DAO userobj = new User_DAO();
                Interest_DAO interestObj = new Interest_DAO();
                check = userobj.create(user, con);
                if(interest != null){
                interestObj.create(email, interest, con);
                }
                con.close();
                if (check == 0) {
                    requestDispatcher = request.getRequestDispatcher("/Login");
                    requestDispatcher.forward(request, response);
                } else {
                    requestDispatcher = request.getRequestDispatcher("Error-Page/ErrorRegister.jsp");
                    requestDispatcher.forward(request, response);
                }

                out.println("Done");
            } else {
                RequestDispatcher dispather = request.getRequestDispatcher("/Cookies/noCookies.jsp");
                dispather.forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
