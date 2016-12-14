/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dbhelpers.CalcQuery;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Calculator;

/**
 *
 * @author tholm
 */
@WebServlet(name = "UpdateCalculator", urlPatterns = {"/updateCalculator"})
public class CalculatorServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateCalculator</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateCalculator at " + request.getContextPath() + "</h1>");
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

        String type = request.getParameter("type");

        if (type.equals("Residential")) {

            try {
                String assValue = request.getParameter("assValue");
                DecimalFormatSymbols symbols = new DecimalFormatSymbols();
                symbols.setGroupingSeparator(',');
                symbols.setDecimalSeparator('.');
                String pattern = "#,##0.0#";
                DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
                decimalFormat.setParseBigDecimal(true);
                
                BigDecimal value = (BigDecimal) decimalFormat.parse(assValue);
                
                BigDecimal resRollback = new BigDecimal(.556259);
                
                BigDecimal rateChange = new BigDecimal(.00242957);
                
                BigDecimal annual = (BigDecimal) decimalFormat.parse("0");
                BigDecimal month = (BigDecimal) decimalFormat.parse("12");
                BigDecimal monthly = (BigDecimal) decimalFormat.parse("0");
                BigDecimal homeCredit = (BigDecimal) decimalFormat.parse("4,850");
                
                annual = value.multiply(resRollback);
                
                annual = annual.subtract(homeCredit);
                
                annual = annual.multiply(rateChange);
                
                monthly = annual.divide(month);
                
                System.out.println(annual);
                annual = annual.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                monthly = monthly.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                value = value.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                
                double annualout = annual.doubleValue();
                double monthout = monthly.doubleValue();
                double assValOut = value.doubleValue();
                
                String annualpass = String.valueOf(annualout);
                String monthpass = String.valueOf(monthout);
                String asvalpass = String.valueOf(assValOut);
                
                
                String test = "Test";
                request.setAttribute("test", test);
                request.setAttribute("monthpass", monthpass);
                request.setAttribute("asvalpass", asvalpass);
                
                
                //make calculator object
                Calculator calc = new Calculator();
                calc.setType(type);
                calc.setAssessed(assValOut);
                calc.setAnnual(annualout);
                calc.setMonthly(monthout);
                
                CalcQuery cq = new CalcQuery();
                //pass calc to query
                cq.doAdd(calc);
                
                
                
                String url = "/resconfirm.jsp";
                
               RequestDispatcher dispatcher = request.getRequestDispatcher(url);
               dispatcher.forward(request, response);
                
            } catch (ParseException ex) {
                Logger.getLogger(CalculatorServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (type.equals("Multi-Residential")) {
            try {
                String assValue = request.getParameter("assValue");
                DecimalFormatSymbols symbols = new DecimalFormatSymbols();
                symbols.setGroupingSeparator(',');
                symbols.setDecimalSeparator('.');
                String pattern = "#,##0.0#";
                DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
                decimalFormat.setParseBigDecimal(true);
                
                BigDecimal value = (BigDecimal) decimalFormat.parse(assValue);
                
                BigDecimal resRollback = new BigDecimal(.8625);
                
                BigDecimal rateChange = new BigDecimal(.00242957);
                //BigDecimal homeCredit = (BigDecimal) decimalFormat.parse("4,850");
                BigDecimal annual = (BigDecimal) decimalFormat.parse("0");
                BigDecimal month = (BigDecimal) decimalFormat.parse("12");
                BigDecimal monthly = (BigDecimal) decimalFormat.parse("0");
                
                annual = value.multiply(resRollback);
                
               // annual = annual.subtract(homeCredit);
                
                annual = annual.multiply(rateChange);
                
                monthly = annual.divide(month);
                
                System.out.println(annual);
                annual = annual.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                monthly = monthly.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                value = value.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                
                double annualout = annual.doubleValue();
                double monthout = monthly.doubleValue();
                double assValOut = value.doubleValue();
                
                //make calculator object
                Calculator calc = new Calculator();
                calc.setType(type);
                calc.setAssessed(assValOut);
                calc.setAnnual(annualout);
                calc.setMonthly(monthout);
                
                CalcQuery cq = new CalcQuery();
                //pass calc to query
                cq.doAdd(calc);
                
                String url = "/multiresconfirm.jsp";
                
                RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                dispatcher.forward(request, response);
                
            } catch (ParseException ex) {
                Logger.getLogger(CalculatorServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (type.equals("Commercial")) {
            try {
                String assValue = request.getParameter("assValue");
                DecimalFormatSymbols symbols = new DecimalFormatSymbols();
                symbols.setGroupingSeparator(',');
                symbols.setDecimalSeparator('.');
                String pattern = "#,##0.0#";
                DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
                decimalFormat.setParseBigDecimal(true);
                
                BigDecimal value = (BigDecimal) decimalFormat.parse(assValue);
                
                BigDecimal resRollback = new BigDecimal(.9);
                
                BigDecimal rateChange = new BigDecimal(.00242957);
                
                BigDecimal annual = (BigDecimal) decimalFormat.parse("0");
                BigDecimal month = (BigDecimal) decimalFormat.parse("12");
                BigDecimal monthly = (BigDecimal) decimalFormat.parse("0");
                
                annual = value.multiply(resRollback);
                
               
                
                annual = annual.multiply(rateChange);
                
                monthly = annual.divide(month);
                
                System.out.println(annual);
                annual = annual.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                monthly = monthly.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                value = value.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                
                double annualout = annual.doubleValue();
                double monthout = monthly.doubleValue();
                double assValOut = value.doubleValue();
                
                //make calculator object
                Calculator calc = new Calculator();
                calc.setType(type);
                calc.setAssessed(assValOut);
                calc.setAnnual(annualout);
                calc.setMonthly(monthout);
                
                CalcQuery cq = new CalcQuery();
                //pass calc to query
                cq.doAdd(calc);
                
                String url = "/commercialconfirm.jsp";
                
                RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                dispatcher.forward(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(CalculatorServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (type.equals("Agriculture")) {
            try {
                String assValue = request.getParameter("assValue");
                DecimalFormatSymbols symbols = new DecimalFormatSymbols();
                symbols.setGroupingSeparator(',');
                symbols.setDecimalSeparator('.');
                String pattern = "#,##0.0#";
                DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
                decimalFormat.setParseBigDecimal(true);
                
                BigDecimal value = (BigDecimal) decimalFormat.parse(assValue);
                
                BigDecimal resRollback = new BigDecimal(.461068);
                
                BigDecimal rateChange = new BigDecimal(.00242957);
                
                BigDecimal annual = (BigDecimal) decimalFormat.parse("0");
                BigDecimal month = (BigDecimal) decimalFormat.parse("12");
                BigDecimal monthly = (BigDecimal) decimalFormat.parse("0");
                BigDecimal perAcre = (BigDecimal) decimalFormat.parse("100");
                
                annual = value.multiply(resRollback);
                
               
                
                annual = annual.multiply(rateChange);
                annual = annual.multiply(perAcre);
                monthly = annual.divide(month);
                
                System.out.println(annual);
                annual = annual.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                monthly = monthly.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                value = value.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                
                double annualout = annual.doubleValue();
                double monthout = monthly.doubleValue();
                double assValOut = value.doubleValue();
                
                //make calculator object
                Calculator calc = new Calculator();
                calc.setType(type);
                calc.setAssessed(assValOut);
                calc.setAnnual(annualout);
                calc.setMonthly(monthout);
                
                CalcQuery cq = new CalcQuery();
                //pass calc to query
                cq.doAdd(calc);
                
                String url = "/agricultureconfirm.jsp";
                
                RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                dispatcher.forward(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(CalculatorServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

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
