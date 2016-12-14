/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dbhelpers.UpdateQuery;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Support;

/**
 *
 * @author Amber Gerard
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/updateVisitor"})
public class UpdateServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int CustomerID = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String lastName = request.getParameter("lastName");
        String why = request.getParameter("why");

        String posted = request.getParameter("posted");
        if (posted != null && !posted.equals("")) {
            posted = "y";
        } else {
            posted = "n";
        }

        String willhelp = request.getParameter("willhelp");
        if (willhelp != null && !willhelp.equals("")) {
            willhelp = "y";
        } else {
            willhelp = "n";
        }

        String support = request.getParameter("support");
        if (support != null && !support.equals("")) {
            support = "y";
        } else {
            support = "n";
        }
        String comments = request.getParameter("comments");

        //set up a support obj
        Support visitor = new Support();
        visitor.setCustomerID(CustomerID);
        visitor.setFirstName(firstName);
        visitor.setPhone(phone);
        visitor.setEmail(email);
        visitor.setLastName(lastName);
        visitor.setWhy(why);
        visitor.setPosted(posted);
        visitor.setWillhelp(willhelp);
        visitor.setSupport(support);
        visitor.setComments(comments);
        
        
        UpdateQuery uq = new UpdateQuery();
        uq.doUpdate(visitor);

        String url = "/dashboard.jsp";

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
