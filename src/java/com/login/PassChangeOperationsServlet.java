/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login;

import com.jdbc.DatabaseOperations;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hamit Eren Açari
 */
public class PassChangeOperationsServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) {
		
            HttpSession sess=req.getSession(false);

            try {

                    DatabaseOperations.alterUSER_PASS((String) sess.getAttribute("USER_MAIL"), req.getParameter("USER_PASS"));

                    RequestDispatcher rd=req.getRequestDispatcher("/GirisYap");
                    rd.forward(req, res);
            }

            catch (Exception e) {

                    System.out.print(e.getLocalizedMessage());
            }
    }
}
