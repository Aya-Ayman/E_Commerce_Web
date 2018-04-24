/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_registeration;

import handle_ui_package.HandleUI;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hesham
 */
@WebServlet(name = "Start", urlPatterns = {"/Start"})
public class StartServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HandleUI ui = new HandleUI();
        
        // set UI to default state \\
        ui.onStartServlet(request);
        
        // handle UI due to user or visitor existance \\
        ui.checkUI(request);
        
//        boolean flag =(boolean) request.getAttribute("cookieEnabled");
//        if(flag)
//        {
        // b3ml check lw el user object ely 3al session msh b null lw kda a3ml dispatcher 3al profile.jsp \\
        RequestDispatcher dispather = request.getRequestDispatcher("DisplayProductServlet");
        dispather.forward(request, response);
//        }else{
//            RequestDispatcher dispather = request.getRequestDispatcher("/Cookies/noCookies.jsp");
//        dispather.forward(request, response);
//        }
        //\\
    }


}
