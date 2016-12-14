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

/**
 *
 * @author tholm
 */
public class Verification {
    
    private Connection conn;
    private ResultSet results;
    
    public Verification(){
        
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
                Logger.getLogger(Verification.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn = DriverManager.getConnection(url, username, passwd);
            } catch (SQLException ex) {
                Logger.getLogger(Verification.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(Verification.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
  public void doSearch(String userName, String passWord){
        
        try {
            String query = "Select * from secure WHERE userName = ? AND passWord = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, passWord);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Verification.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
  
 public boolean doVerify() throws SQLException{
       if (!this.results.isBeforeFirst()){
                return false;}
       else{
                return true;} 
 } 
    
}
