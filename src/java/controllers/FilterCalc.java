/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dbhelpers.FCQuery;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tholm
 */
@WebServlet(name = "FilterCalc", urlPatterns = {"/filterCalc"})
public class FilterCalc extends HttpServlet {

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
            out.println("<title>Servlet FilterCalc</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FilterCalc at " + request.getContextPath() + "</h1>");
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

//        String multires = request.getParameter("multi-residential");
//        String commercial = request.getParameter("commercial");
//        String agriculture = request.getParameter("agriculture");
//        String ascending = request.getParameter("ascending");
        String residential = request.getParameter("residential");
        if (residential != null && !residential.equals("")) {
            residential = "y";
        } else {
            residential = "n";
        }

        String multires = request.getParameter("multi-residential");
        if (multires != null && !multires.equals("")) {
            multires = "y";
        } else {
            multires = "n";
        }

        String commercial = request.getParameter("commercial");
        if (commercial != null && !commercial.equals("")) {
            commercial = "y";
        } else {
            commercial = "n";
        }

        String agriculture = request.getParameter("agriculture");
        if (agriculture != null && !agriculture.equals("")) {
            agriculture = "y";
        } else {
            agriculture = "n";
        }

        String ascending = request.getParameter("ascending");
        if (ascending != null && !ascending.equals("")) {
            ascending = "y";
        } else {
            ascending = "n";
        }

        //BUILD QUERY FOR FILTER
        String query = "SELECT * from Calculator WHERE ";

        int prior = 0;

        if (residential.equals("y")) {

            query += "type = 'Residential' ";
            prior++;
        }

        if (multires.equals("y")) {

            if (prior > 0) {
                query += "OR type = 'Multi-Residential' ";
                prior++;
            } else {
                query += "type = 'Multi-Residential' ";
                prior++;
            }
        }

        if (commercial.equals("y")) {

            if (prior > 0) {
                query += "OR type = 'Commercial' ";
                prior++;
            } else {
                query += "type = 'Commercial' ";
                prior++;
            }
        }

        if (agriculture.equals("y")) {

            if (prior > 0) {
                query += "OR type = 'Agriculture' ";
                prior++;
            } else {
                query += "type = 'Agriculture' ";
                prior++;
            }
        }
        
        if (prior ==0 ){
            query = "SELECT * from Calculator ";
        }

        if (ascending.equals("y")) {

            query += "ORDER BY Assessed ASC";
        } else {
            query += "ORDER BY Assessed DESC";
        }

        //query += " ";
        FCQuery cfq = new FCQuery();

        cfq.doRead(query);

        String table = cfq.getHTMLtable();

        request.setAttribute("table", table);

        String url = "/calcadmin.jsp";

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
