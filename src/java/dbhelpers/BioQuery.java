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
import model.Home;

/**
 *
 * @author tholm
 */
public class BioQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public BioQuery(){
        
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
                Logger.getLogger(BioQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn = DriverManager.getConnection(url, username, passwd);
            } catch (SQLException ex) {
                Logger.getLogger(BioQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(BioQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
    
    public void doRead(){
        
        try {
            String query = "SELECT Content FROM MESSAGES WHERE TYPE = 'CommunityBio'";
            
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public String getMessage(){
        
        String table = "";
        
        try {
            while(this.results.next()){
                
                
                Home home = new Home();
                home.setMessage(this.results.getString("content"));
                
                            
                table += home.getMessage();
                
                
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BioQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
 
            
            
            return table; 
        }
}
