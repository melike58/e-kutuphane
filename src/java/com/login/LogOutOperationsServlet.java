/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login;

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
public class LogOutOperationsServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        
        try{
            
            HttpSession sess=req.getSession();
            sess.setAttribute("LOGED_IN", "false");
            
            RequestDispatcher rd=req.getRequestDispatcher("/AnaSayfa");
            rd.forward(req, res);
        }
        
        catch(Exception e) {
            
            
        }
    }

}
