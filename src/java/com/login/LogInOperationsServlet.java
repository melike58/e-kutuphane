package com.login;

import java.io.PrintWriter;

import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

import com.jdbc.DatabaseOperations;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogInOperationsServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) {
		
        try {

            DatabaseOperations.insertIntoUSERS(req.getParameter("USER_NICK"), req.getParameter("USER_NAME"), req.getParameter("USER_LNAME"), 
                            req.getParameter("USER_MAIL"), req.getParameter("USER_PASS"), req.getParameter("USER_PHONE"));

            RequestDispatcher rd=req.getRequestDispatcher("/GirisYap");
            rd.forward(req, res);
        }

        catch(Exception e) {

        }
    }
	
    public void doGet(HttpServletRequest req, HttpServletResponse res) {

        try {

                if(DatabaseOperations.userIsValid(req.getParameter("USER_MAIL"), req.getParameter("USER_PASS"))) {
                    
                    int USER_ID=DatabaseOperations.getUSER_IDByMail(req.getParameter("USER_MAIL"));
                    
                    HttpSession sess=req.getSession();
                    sess.setAttribute("LOGED_IN", "true");
                    sess.setAttribute("USER_ID", USER_ID);

                    RequestDispatcher rd=req.getRequestDispatcher("/AnaSayfa");
                    rd.forward(req, res);
                }

                else {

                    RequestDispatcher rd=req.getRequestDispatcher("/GirisYap");
                    rd.forward(req, res);
                }
        }

        catch(Exception e) {

        }
    }

}
