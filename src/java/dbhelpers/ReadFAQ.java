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
import model.Support;

/**
 *
 * @author tholm
 */
public class ReadFAQ {

    private Connection conn;
    private ResultSet results;

    private FAQ q = new FAQ();
    private int FAQID;

    public ReadFAQ(int CustomerID) {

        try {
            Properties props = new Properties();
            InputStream instr = getClass().getResourceAsStream("dbConn.properties");
            props.load(instr);
            instr.close();

            String driver = props.getProperty("driver.name");
            String url = props.getProperty("server.name");
            String username = props.getProperty("user.name");
            String passwd = props.getProperty("user.password");

            this.FAQID = CustomerID;

            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ReadFAQ.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn = DriverManager.getConnection(url, username, passwd);
            } catch (SQLException ex) {
                Logger.getLogger(ReadFAQ.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(ReadFAQ.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void doRead() {

        try {
            String query = "Select * from FAQ WHERE FAQID = ?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, FAQID);

            this.results = ps.executeQuery();

            this.results.next();

            q.setFAQID(this.results.getInt("FAQID"));
            q.setAnswer(this.results.getString("answer"));
            q.setQuestion(this.results.getString("question"));

        } catch (SQLException ex) {
            Logger.getLogger(ReadFAQ.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public FAQ getFAQ(){
        return this.q;
    }
}
