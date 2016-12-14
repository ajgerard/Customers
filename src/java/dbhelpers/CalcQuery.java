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
import model.Calculator;

/**
 *
 * @author tholm
 */
public class CalcQuery {

    private Connection conn;
    private ResultSet results;

    public CalcQuery() {

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
                Logger.getLogger(CalcQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn = DriverManager.getConnection(url, username, passwd);
            } catch (SQLException ex) {
                Logger.getLogger(CalcQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(CalcQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
   public void doAdd( Calculator calc){
        
         try {
             String query="insert into calculator (type, assessed, annual, monthly) VALUES (?, ?, ?, ?)";
             PreparedStatement ps = conn.prepareStatement(query);
             
             ps.setString(1, calc.getType());
             ps.setDouble(2, calc.getAssessed());
             ps.setDouble(3, calc.getAnnual());
             ps.setDouble(4, calc.getMonthly());
             
             ps.executeUpdate();
             
         } catch (SQLException ex) {
             Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
    
    
}
