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
 * @author tholm
 */
public class VolunteerQuery {
    private Connection conn;
    private ResultSet results;
    
    public VolunteerQuery(){
        
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
                Logger.getLogger(VolunteerQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn = DriverManager.getConnection(url, username, passwd);
            } catch (SQLException ex) {
                Logger.getLogger(VolunteerQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(VolunteerQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
  public void doRead(){
        
        try {
            String query = "SELECT * FROM Support WHERE willhelp = 'y' ORDER BY customerID ASC";
            
            PreparedStatement ps = conn.prepareStatement(query);
           
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(VolunteerQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
  public String getHTMLtable(){
        
                  
        
            String table = "";
            
            table += "<table class='table table-bordered table-fixed table-hover'>";
            
            table += "<thead>";
            table += "<tr>";
            
            table += "<th><center>First Name</center></th>";
            table += "<th><center>Last Name</center></th>";
            table += "<th><center>Email</center></th>";
            
            table += "<th colspan=2><center>Edit</center></th>";
            
            table += "</tr>";
            table += "</thead>";
            
            
            
        try {
            while(this.results.next()){
                
                
                Support visitor = new Support();
                visitor.setCustomerID(this.results.getInt("customerID"));
                visitor.setFirstName(this.results.getString("firstName"));
                visitor.setEmail(this.results.getString("email"));
                visitor.setPhone(this.results.getString("phone"));
                visitor.setPosted(this.results.getString("posted"));
                visitor.setWillhelp(this.results.getString("willhelp"));
                visitor.setSupport(this.results.getString("support"));
                visitor.setWhy(this.results.getString("why"));
                visitor.setLastName(this.results.getString("lastName"));
                            
                table += "<tbody>";
                
                
                table += "<td>";
                table += visitor.getFirstName();
                table += "</td>";
                
                table += "<td>";
                table += visitor.getLastName();
                table += "</td>";
                
                table += "<td>";
                table += visitor.getEmail();
                table += "</td>";
                
                
                            
                table += "<td>";
                table += "<a class= 'btn btn-info' role='button' href=update?CustomerID=" + visitor.getCustomerID() + "> Details </a>";
                table += "</td>";
                
                table += "<td>";
                table += "<a class= 'btn btn-danger' role='button' href=delete?CustomerID=" + visitor.getCustomerID() +"> Delete </a>";
                table += "</td>";
                
                table += "</tr>";
                table += "</tbody>";
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
 
            table += "</table>";
            
            return table; 
        }  
    
}
