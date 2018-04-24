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

/**
 *
 * @author Hesham
 */
@WebServlet(name = "CloseServlet", urlPatterns = {"/CloseServlet"})
public class CloseServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
                 HandleUI ui = new HandleUI();
                 ui.closeWindow(request);
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("/Start");
                dispatcher.forward(request, response);
        
    }
    
    
    
    
}
