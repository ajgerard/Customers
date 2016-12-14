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
import model.Support;


/**
 *
 * @author Wenchuan
 */
public class AddQuery {
    private Connection conn;
    private ResultSet results;
    
    
    public AddQuery(){
        
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
                Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn = DriverManager.getConnection(url, username, passwd);
            } catch (SQLException ex) {
                Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    //firstname, email, phone, posted, willhelp, support, why, lastname
    public void doAdd( Support visitor){
        
         try {
             String query="insert into support (firstname, email, phone, posted, willhelp, support, why, LastName, Comments) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
             PreparedStatement ps = conn.prepareStatement(query);
             
             ps.setString(1, visitor.getFirstName());
             ps.setString(2, visitor.getEmail());
             ps.setString(3, visitor.getPhone());
             ps.setString(4, visitor.getPosted());
             ps.setString(5, visitor.getWillhelp() );
             ps.setString(6,visitor.getSupport() );
             ps.setString(7, visitor.getWhy());
             ps.setString(8, visitor.getLastName() );
             ps.setString(9, visitor.getComments());
             ps.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
}
