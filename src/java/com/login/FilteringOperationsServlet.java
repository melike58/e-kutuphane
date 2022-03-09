/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hamit Eren Açari
 */

public class FilteringOperationsServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        
        try{
            String str[]=new String[10];
            str[0]=req.getParameter("CHECK_BOX_1");
            str[1]=req.getParameter("CHECK_BOX_2");
            str[2]=req.getParameter("CHECK_BOX_3");
            str[3]=req.getParameter("CHECK_BOX_4");
            str[4]=req.getParameter("CHECK_BOX_5");
            str[5]=req.getParameter("CHECK_BOX_6");
            str[6]=req.getParameter("CHECK_BOX_7");
            str[7]=req.getParameter("CHECK_BOX_8");
            str[8]=req.getParameter("CHECK_BOX_9");
            str[9]=req.getParameter("CHECK_BOX_10");
            
            HttpSession sess=req.getSession();
            sess.setAttribute("FILTERED", "true");
            sess.setAttribute("FILTERED_RESULTS", str);
            
            RequestDispatcher rd=req.getRequestDispatcher("/AnaSayfa");
            rd.forward(req, res);
        }
        
        catch(Exception e) {
            
            try {
                res.getWriter().print(e.getLocalizedMessage());
            } catch (IOException ex) {
                Logger.getLogger(FilteringOperationsServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        
        try {
            
            HttpSession sess=req.getSession();
            sess.setAttribute("BOOK_ID", Integer.valueOf(req.getParameter("DISPLAY")));

            RequestDispatcher rd=req.getRequestDispatcher("/KitapBilgileri");
            rd.forward(req, res);
        }
        
        catch(Exception e) {
            
            try {
                res.getWriter().print(e.getLocalizedMessage());
            } catch (IOException ex) {
                Logger.getLogger(FilteringOperationsServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
