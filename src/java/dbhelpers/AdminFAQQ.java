/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbhelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.FAQ;

/**
 *
 * @author tholm
 */
public class AdminFAQQ {

    private Connection conn;
    private ResultSet results;

    public AdminFAQQ() {

        try {
            Properties props = new Properties();
            InputStream instr = getClass().getResourceAsStream("dbConn.properties");
            props.load(instr);
            instr.close();

            String driver = props.getProperty("driver.name");
            String url = props.getProperty("server.name");
            String username = props.getProperty("user.name");
            String passwd = props.getProperty("user.password");
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminFAQQ.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn = DriverManager.getConnection(url, username, passwd);
            } catch (SQLException ex) {
                Logger.getLogger(AdminFAQQ.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(AdminFAQQ.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void doRead() {

        try {
            String query = "SELECT * FROM FAQ ORDER BY FAQID DESC";

            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(AdminFAQQ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getHTMLtable() {

        String table = "";

//            table += "<table class='table table-striped header-fixed' border=1>";
        table += "<thead>";
        table += "<tr>";
        table += "<th class='col-xs-2'><center>Question</center></th>";
        table += "<th class='col-xs-8'><center>Answer</center></th>";
        table += "<th class='col-xs-2'><center>Edit</center></th>";

        table += "</tr>";
        table += "</thead>";

        try {
            while (this.results.next()) {

                FAQ q = new FAQ();

                q.setFAQID(this.results.getInt("FAQID"));
                q.setAnswer(this.results.getString("answer"));
                q.setQuestion(this.results.getString("question"));

                table += "<tbody>";
                table += "<tr>";
                table += "<td class='col-xs-2'>";
                table += q.getQuestion();
                table += "</td>";

                table += "<td class='col-xs-8'>";
                table += q.getAnswer();
                table += "</td>";

                table += "<td class='col-xs-2'>";
                table += "<span class = 'pull-left'><a class= 'btn btn-info' role='button' href=updateFAQ?FAQID=" + q.getFAQID() + "> Edit </a></span>";
                table += "<span class = 'pull-right'><a class= 'btn btn-danger' role='button' href=deleteFAQ?FAQID=" + q.getFAQID() + "> Delete </a></span>";
                table += "</td>";

//                table += "<td class='col-xs-2'>";           
//                table += "<a class= 'btn btn-danger' role='button' href=delete?CustomerID=" + visitor.getCustomerID() +"> Delete </a>";
//                table += "</td>";
                table += "</tr>";
                table += "</tbody>";

            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

        // table += "</table>";
        return table;
    }

    public String getUserFAQ() {

        try {
            String query = "Select * from FAQ ORDER BY FAQID ASC";

            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(AdminFAQQ.class.getName()).log(Level.SEVERE, null, ex);
        }

        String table = "";

//            table += "<table class='table table-striped header-fixed' border=1>";
        try {
            while (this.results.next()) {

                FAQ q = new FAQ();

                q.setFAQID(this.results.getInt("FAQID"));
                q.setAnswer(this.results.getString("answer"));
                q.setQuestion(this.results.getString("question"));

                String question = q.getQuestion();
                String answer = q.getAnswer();

                table += "<b>";
                table += question;
                table += "</b>";
                table += "<br>";
                table += answer;
                table += "<br><br>";
                table += "<hr>";

            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

        // table += "</table>";
        return table;
    }

}
