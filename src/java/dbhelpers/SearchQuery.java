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

public class SearchQuery {

    private Connection conn;
    private ResultSet results;

    public SearchQuery() {

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
                Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn = DriverManager.getConnection(url, username, passwd);
            } catch (SQLException ex) {
                Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void doSearch(String firstName, String lastName) {
        if (firstName.equals(lastName)) {
            try {

                String qfirst = "SELECT * from support WHERE UPPER(firstName) LIKE ? or UPPER(lastName) LIKE ? ORDER BY customerID ASC";

                PreparedStatement ps = conn.prepareStatement(qfirst);
                ps.setString(1, "%" + firstName.toUpperCase() + "%");
                ps.setString(2, "%" + lastName.toUpperCase() + "%");

                this.results = ps.executeQuery();

            } catch (SQLException ex) {
                Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        else{

        try {

            String query = "SELECT * from support WHERE UPPER(firstName) LIKE ? AND UPPER(lastName) LIKE ? ORDER BY customerID ASC";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + firstName.toUpperCase() + "%");
            ps.setString(2, "%" + lastName.toUpperCase() + "%");
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

    public String getHTMLtable() {

        String table = "";

        table += "<table class='table table-bordered table-fixed table-hover'>";

        table += "<thead>";
        table += "<tr>";
        table += "<th><center>Customer ID</center></th>";
        table += "<th><center>First Name</center></th>";
        table += "<th><center>Last Name</center></th>";
        table += "<th><center>Email</center></th>";
        table += "<th><center>Phone</center></th>";
        table += "<th><center>Edit</center></th>";

        table += "</tr>";
        table += "</thead>";

        try {
            if (!this.results.isBeforeFirst()) {

                table += "<tr>";
                table += "<td colspan='6'><center>Sorry, this person does not exist in the database</center></td>";
                table += "</tr>";
            } else {
                while (this.results.next()) {

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
                    table += "<tr>";
                    table += "<td>";
                    table += visitor.getCustomerID();
                    table += "</td>";

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
                    table += visitor.getPhone();
                    table += "</td>";

                    table += "<td>";
                    table += "<span class = 'pull-left'><a class= 'btn btn-info' role='button' href=update?CustomerID=" + visitor.getCustomerID() + "> Details </a></span>";
                    table += "<span class = 'pull-right'><a class= 'btn btn-danger' role='button' href=delete?CustomerID=" + visitor.getCustomerID() +"> Delete </a></span>";
                    table += "</td>";

                    table += "</tr>";
                    table += "</tbody>";

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

        table += "</table>";

        return table;
    }

    public String getFirst(String name) {
        String fullName = name;
        String[] tokens = fullName.split(" ");
        String firstName = "";
        String middleName = "";
        String lastName = "";
        if (tokens.length > 0) {
            firstName = tokens[0];
            middleName = tokens.length > 2 ? getMiddleName(tokens) : "";
            lastName = tokens[tokens.length - 1];
        }
        return firstName;
    }

    public String getLast(String name) {
        String fullName = name;
        String[] tokens = fullName.split(" ");
        String firstName = "";
        String middleName = "";
        String lastName = "";
        if (tokens.length > 0) {
            firstName = tokens[0];
            middleName = tokens.length > 2 ? getMiddleName(tokens) : "";
            lastName = tokens[tokens.length - 1];
        }
        return lastName;
    }

    public String getMiddle(String name) {
        String fullName = name;
        String[] tokens = fullName.split(" ");
        String firstName = "";
        String middleName = "";
        String lastName = "";
        if (tokens.length > 0) {
            firstName = tokens[0];
            middleName = tokens.length > 2 ? getMiddleName(tokens) : "";
            lastName = tokens[tokens.length - 1];
        }
        return middleName;
    }

    public String getMiddleName(String[] middleName) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < middleName.length - 1; i++) {
            builder.append(middleName[i] + " ");
        }

        return builder.toString();
    }

}
