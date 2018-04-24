/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handle_ui_package;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hesham
 */
public class HandleUI {

    public void checkUI(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession(false);
            String checkValue = (String) session.getAttribute("display_btn");
            if (checkValue.equals("ok")) {
                request.setAttribute("visitorStyle", "display:none");
                request.setAttribute("userStyle", "display:block");
                System.out.println("userStyle");
            } else {
                request.setAttribute("visitorStyle", "display:block");
                request.setAttribute("userStyle", "display:none");
                System.out.println("visitorStyle");
            }
        } catch (Exception e) {

            request.setAttribute("visitorStyle", "display:block");
            request.setAttribute("userStyle", "display:none");
            System.out.println("visitorStyle");
        }
    }

    public void onStartServlet(HttpServletRequest request) {
        request.setAttribute("classAttr", "modal fade");
        request.setAttribute("aria-hidden", "true");
        request.setAttribute("style", "display:none;");
    }

    public void logOut(HttpServletRequest request) {
        request.getSession().setAttribute("display_btn", "no");
    }

    public void LoginSuccessful(HttpServletRequest request) {
        request.setAttribute("unvalid", "");
        request.setAttribute("classAttr", "modal fade");
        request.setAttribute("aria-hidden", "true");
        request.setAttribute("style", "none");
        request.setAttribute("visitorStyle", "display:none");
        request.setAttribute("userStyle", "display:block");
        request.getSession(false).setAttribute("display_btn", "ok");
    }

    public void loginFailed(HttpServletRequest request) {
        request.setAttribute("unvalid", "Invalid user name or password !!");
        request.setAttribute("classAttr", "modal fade in");
        request.setAttribute("aria-hidden", "false");
        request.setAttribute("style", "display: block; padding-right: 16px;");
    }

    public void closeWindow(HttpServletRequest request) {
        request.setAttribute("classAttr", "modal fade");
        request.setAttribute("aria-hidden", "true");
        request.setAttribute("style", "display:none;");
    }

    public void afterSearchProduct(HttpServletRequest request) {
        request.setAttribute("classAttr", "modal fade");
        request.setAttribute("aria-hidden", "true");
        request.setAttribute("style", "display:none;");
    }

}
