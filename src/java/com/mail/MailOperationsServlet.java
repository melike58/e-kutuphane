/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mail;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbc.DatabaseOperations;

import java.util.Random;

public class MailOperationsServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) {
		
            try {

                    if(DatabaseOperations.mailIsValid(req.getParameter("USER_MAIL"))) {

                            Random rand=new Random();
                            int VERIFY=rand.nextInt(1000000);

                            HttpSession sess=req.getSession();
                            sess.setAttribute("VERIFY", VERIFY);
                            sess.setAttribute("USER_MAIL", req.getParameter("USER_MAIL"));

                            MailOperations.sendVerifyMail(req.getParameter("USER_MAIL"), VERIFY);

                            RequestDispatcher rd=req.getRequestDispatcher("/KodDogrulama");
                            rd.forward(req, res);
                    }

                    else {

                            RequestDispatcher rd=req.getRequestDispatcher("/SifremiUnuttum");
                            rd.forward(req, res);
                    }
            }

            catch (Exception e) {

                    System.out.print(e.getLocalizedMessage());;
            }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) {

            HttpSession sess=req.getSession(false);
            int VERIFY=(int) sess.getAttribute("VERIFY");

            try {

                    if(VERIFY==Integer.parseInt(req.getParameter("VERIFY_IN"))) {

                            RequestDispatcher rd=req.getRequestDispatcher("/SifremiDegistir");
                            rd.forward(req, res);
                    }

                    else {

                            RequestDispatcher rd=req.getRequestDispatcher("/KodDogrulama");
                            rd.forward(req, res);
                    }
            }

            catch (Exception e) {

                    System.out.print(e.getLocalizedMessage());;
            }
    }

}
