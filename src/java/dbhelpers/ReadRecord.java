
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

public class ReadRecord {
    
    private Connection conn;
    private ResultSet results;
    
    private Support visitors = new Support();
    private int CustomerID;
    
    public ReadRecord (int CustomerID) {

    try {
            Properties props = new Properties();
            InputStream instr = getClass().getResourceAsStream("dbConn.properties");
            props.load(instr);
            instr.close();
            
            String driver = props.getProperty("driver.name");
            String url = props.getProperty("server.name");
            String username = props.getProperty("user.name");
            String passwd = props.getProperty("user.password");
            
            this.CustomerID = CustomerID;
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn = DriverManager.getConnection(url, username, passwd);
            } catch (SQLException ex) {
                Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    
    public void doRead(){
        
        try {
            String query = "Select * from support WHERE CustomerID = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, CustomerID);
            
            this.results = ps.executeQuery();
            
            this.results.next();
            
            visitors.setCustomerID(this.results.getInt("CustomerID"));
            visitors.setFirstName(this.results.getString("FirstName"));
            visitors.setLastName(this.results.getString("LastName"));
            visitors.setEmail(this.results.getString("Email"));
            visitors.setPhone(this.results.getString("Phone"));
            visitors.setComments(this.results.getString("Comments"));
            visitors.setPosted(this.results.getString("Posted"));
            visitors.setWhy(this.results.getString("Why"));
            visitors.setSupport(this.results.getString("Support"));
            visitors.setWillhelp(this.results.getString("Willhelp"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
                
            
            
       }
    
    public Support getSupport(){
    
        return this.visitors;
    
    
    }

}

   