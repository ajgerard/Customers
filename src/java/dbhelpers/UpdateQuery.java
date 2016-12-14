
package dbhelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Home;
import model.Support;


public class UpdateQuery {
    
    private Connection conn;
    
    public UpdateQuery(){
    
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
                Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn = DriverManager.getConnection(url, username, passwd);
            } catch (SQLException ex) {
                Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    
    
    }
    
    public void doUpdate (Support visitors){
    
        try {
            String query = "UPDATE support SET FirstName = ?, LastName = ?, Email = ?, Phone = ?, Posted = ?, Willhelp = ?, Support = ?, Why = ?, comments = ? WHERE CustomerID = ? ";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, visitors.getFirstName());
            ps.setString(2, visitors.getLastName());
            ps.setString(3, visitors.getEmail());
            ps.setString(4, visitors.getPhone());
            ps.setString(5, visitors.getPosted());
            ps.setString(6, visitors.getWillhelp());
            ps.setString(7, visitors.getSupport());
            ps.setString(8, visitors.getWhy());
            ps.setString(9, visitors.getComments());
            ps.setInt(10, visitors.getCustomerID());            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void doUpdateHome(Home homeup){
    
        try {
            String query = "UPDATE Messages SET Content = ? WHERE type = ? ";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, homeup.getMessage());
            ps.setString(2, "Home");
                       
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    
}
