package login_registeration;

import data_access_layer.DAO.Admin_DAO;
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
import data_transfer_layer.Admin_DTO;
import data_transfer_layer.User_DTO;
import handle_ui_package.HandleUI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aya
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 3mlt create le user dto 3shan ab3ato 3al session \\
        User_DTO mySessionUser = null;
        Admin_DTO mySessionAdmin = null;
        ArrayList<String> userInterests = new ArrayList<>();
        HandleUI ui = new HandleUI();

        boolean flag = (boolean) request.getAttribute("cookieEnabled");
        if (flag) {

            try {
                String email = request.getParameter("email");
                String password = request.getParameter("password");

                // hena 3mlt create le session \\
                HttpSession session = request.getSession(true);
                session.setMaxInactiveInterval(7 * 24 * 60 * 60);

                DatabaseManager managerObj = new DatabaseManager();
                Connection con = managerObj.getCon();
                User_DTO user = new User_DTO();
                user.setEmail(email);
                user.setPassword(password);

                User_DAO userObj = new User_DAO();
                Admin_DAO adminObj = new Admin_DAO();
                Interest_DAO interestObj = new Interest_DAO();

                // hena hageb eldata bta3et el user aw el admin ely hayet7at 3al session \\
                mySessionUser = userObj.retreiveByEmailAndPass(email, password, con);
                mySessionAdmin = adminObj.retreiveByEmailAndPass(email, password, con);

                // 7ateet el user object ka attribute 3al session \\
                if (mySessionUser != null) {
                    ui.LoginSuccessful(request);
                    // set an attribute to check if user paid for products or not
                    userInterests = interestObj.retreive(email, con);
                    request.getSession(false).setAttribute("success", "false");
                    request.getSession(false).setAttribute("type", "user");
                    session.setAttribute("User", mySessionUser);
                    session.setAttribute("Interests", userInterests);
                } else if (mySessionAdmin != null) {
                    request.getSession(false).setAttribute("type", "admin");
                    RequestDispatcher dispather = request.getRequestDispatcher("/AdminServlet");
                    dispather.forward(request, response);
                } else {
                    ui.loginFailed(request);
                    session.invalidate();
                    ui.checkUI(request);
                }

                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            }

            // b3ml check lw el user object ely 3al session msh b null lw kda a3ml dispatcher 3al profile.jsp \\
            RequestDispatcher dispather = request.getRequestDispatcher("DisplayProductServlet");
            dispather.forward(request, response);
        } else {
            RequestDispatcher dispather = request.getRequestDispatcher("/Cookies/noCookies.jsp");
            dispather.forward(request, response);
        }
        //\\
    }

}
