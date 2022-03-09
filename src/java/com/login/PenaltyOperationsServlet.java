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


public class PenaltyOperationsServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        
        try {
            
            HttpSession sess=req.getSession();
            
            DatabaseOperations.resetPENALTY((int)sess.getAttribute("USER_ID"));
            
            RequestDispatcher rd=req.getRequestDispatcher("/Kitaplarim");
            rd.forward(req, res);
        }
        
        catch(Exception e) {
            
            
        }
    }

}
