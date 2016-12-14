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
import java.text.DecimalFormat;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Calculator;

/**
 *
 * @author tholm
 */
public class FCQuery {
     private Connection conn;
    private ResultSet results;
    
    
    public FCQuery(){
        
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
                Logger.getLogger(FCQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn = DriverManager.getConnection(url, username, passwd);
            } catch (SQLException ex) {
                Logger.getLogger(FCQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(FCQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    
    public void doRead(String query){
        
        try {
            //String query = "Select * from support ORDER BY customerID ASC";
            
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(FCQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getHTMLtable(){
        
                  
        
            String table = "";
            
//            table += "<table class='table table-striped header-fixed' border=1>";
            
            table += "<thead>";
            table += "<tr>";
            table += "<th class='col-xs-2'><center>Type</center></th>";
            table += "<th class='col-xs-2'><center>Assessed</center></th>";
            table += "<th class='col-xs-2'><center>Annual</center></th>";
            table += "<th class='col-xs-2'><center>Monthly</center></th>";
            
            
            table += "</tr>";
            table += "</thead>";
            
            
            
        try {
            while(this.results.next()){
                
                
                Calculator calc = new Calculator();
                calc.setType(this.results.getString("type"));
                calc.setAnnual(this.results.getDouble("annual"));
                calc.setAssessed(this.results.getDouble("assessed"));
                calc.setMonthly(this.results.getDouble("monthly"));
                
                DecimalFormat df = new DecimalFormat("#.00");

                String annual = df.format(calc.getAnnual());
                String assess = df.format(calc.getAssessed());
                String monthly = df.format(calc.getMonthly());
                            
                table += "<tbody>";
                table += "<tr>";
                table += "<td class='col-xs-2'><center>";
                table += calc.getType();
                table += "</center></td>"; 
                
                table += "<td class='col-xs-2'><center>";
                table += assess;
                table += "</center></td>";
                
                table += "<td class='col-xs-2'><center>";
                table += annual;
                table += "</center></td>";
                
                table += "<td class='col-xs-2'><center>";
                table += monthly;
                table += "</center></td>";
                
                
                
                table += "</tr>";
                table += "</tbody>";
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
 
           // table += "</table>";
            
            return table; 
        }  
}
