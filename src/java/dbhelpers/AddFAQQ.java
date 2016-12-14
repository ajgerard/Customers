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
public class AddFAQQ {

    private Connection conn;
    private ResultSet results;

    public AddFAQQ() {

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
                Logger.getLogger(AddFAQQ.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn = DriverManager.getConnection(url, username, passwd);
            } catch (SQLException ex) {
                Logger.getLogger(AddFAQQ.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(AddFAQQ.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    
    public void doAdd(FAQ addthis){
        
        try {
            String query="insert into faq (question, answer) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, addthis.getQuestion());
            ps.setString(2, addthis.getAnswer());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AddFAQQ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
