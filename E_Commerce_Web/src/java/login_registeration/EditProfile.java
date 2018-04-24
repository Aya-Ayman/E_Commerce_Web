/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_registeration;

import data_access_layer.DAO.Interest_DAO;
import data_access_layer.DAO.Promo_DAO;
import data_access_layer.DAO.User_DAO;
import data_access_layer.database_manager.DatabaseManager;
import data_transfer_layer.Promo_DTO;
import data_transfer_layer.User_DTO;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Aya
 * @author asmaa
 *
 */
@MultipartConfig(maxFileSize = 16177215)
@WebServlet(name = "EditProfileServlet", urlPatterns = {"/EditProfile"})
public class EditProfile extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RequestDispatcher requestDispatcher;
            PrintWriter out = response.getWriter();
            InputStream inputStream = null; // input stream of the upload file
            Date myDate = null;
            User_DAO userObj = new User_DAO();
            Promo_DAO promoCode = new Promo_DAO();
            Interest_DAO interestObj = new Interest_DAO();
            HttpSession session = request.getSession(false);

            boolean flag = (boolean) request.getAttribute("cookieEnabled");
            if (flag) {

                // obtains the upload file part in this multipart request
                Part filePart = request.getPart("imageProfile");
                if (filePart.getContentType() != null) {
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
                String date = request.getParameter("date");
                String address = request.getParameter("address");
                String job = request.getParameter("job");
                String credit = request.getParameter("credit");
                String[] interests;
                interests = request.getParameterValues("interest");
                String promo = request.getParameter("promo");
                Long creditLong = new Long(credit);

                // handle the date form \\
                try {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    java.util.Date uDate = format.parse(date + " 00:00:00");
                    myDate = new Date(uDate.getTime());
                    System.out.println(myDate);

                } catch (ParseException ex) {
                    Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("WRONG FROM DATE *****************");
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
                user.setDate(myDate);

                if (interests != null) {
                    int x = interestObj.delete(email, con);
                    int y = interestObj.create(email, interests, con);
                    System.out.println("****Interest Table****");
                    System.out.println("Delete = " + x + " Insert = " + y);
                    session.setAttribute("Interests", interests);

                }

                ///Promo Code
                if (!promo.isEmpty()) {
                    Promo_DTO promoDtoObj = new Promo_DTO();
                    promoDtoObj = promoCode.retreive(promo, con);
                    if (promoDtoObj != null) {
                        System.out.println(" found promo ");
                        creditLong += promoDtoObj.getCartNumber();
                        user.setCredit_limit(creditLong);
                        promoCode.delete(promoDtoObj, con);
                        request.setAttribute("promo", "successfully promoCode added ");

                    } else {
                        System.out.println("not found promo ");
                        request.setAttribute("promo", "promoCode not available");

                    }
                } else {
                    request.setAttribute("promo", "");

                }

                if (inputStream.available() != 0) {
                    user.setImage(inputStream);
                    userObj.update(user, con);
                    session.setAttribute("User", user);
                    System.out.println("inputStream Found");
                } else {
                    userObj.updateWithoutImage(user, con);
                    user = userObj.retreive(user.getEmail(), con);
                    session.setAttribute("User", user);
                    System.out.println("inputStream Not Found");
                }

                con.close();
                requestDispatcher = request.getRequestDispatcher("RedirectProfile");
                requestDispatcher.forward(request, response);

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
