package com.login;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import com.jdbc.DatabaseOperations;
import javax.servlet.http.HttpSession;

public class AccountEditOperationsServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        
        try {
            
            HttpSession sess=req.getSession();
            
            DatabaseOperations.alterUserInfo((int)sess.getAttribute("USER_ID"), req.getParameter("USER_NICK"), req.getParameter("USER_NAME"), req.getParameter("USER_LNAME"), req.getParameter("USER_MAIL"), req.getParameter("USER_PASS"), req.getParameter("USER_PHONE"));
            
            RequestDispatcher rd=req.getRequestDispatcher("/Hesabim");
            rd.forward(req, res);
        }
        
        catch(Exception e) {
            
            System.out.print(e.getLocalizedMessage());
        }
    }
}
