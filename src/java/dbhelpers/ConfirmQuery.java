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
public class ConfirmQuery {

    private Connection conn;
    private ResultSet results;

    public ConfirmQuery() {

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
                Logger.getLogger(ConfirmQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn = DriverManager.getConnection(url, username, passwd);
            } catch (SQLException ex) {
                Logger.getLogger(ConfirmQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(ConfirmQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void doRead() {

        try {
            String query = "SELECT * FROM CALCULATOR WHERE ROWNUM <= 1 ORDER BY CALCID DESC";

            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getResults() {
        String resultOut = "";

        try {
            while (this.results.next()) {
                Calculator calc = new Calculator();
                calc.setCalcID(this.results.getInt("CalcID"));
                calc.setAnnual(this.results.getDouble("annual"));
                calc.setAssessed(this.results.getDouble("assessed"));
                calc.setMonthly(this.results.getDouble("monthly"));

                DecimalFormat df = new DecimalFormat("#.00");

                String annual = df.format(calc.getAnnual());
                String assess = df.format(calc.getAssessed());
                String monthly = df.format(calc.getMonthly());

                resultOut += "<center>";
                resultOut += "<p>";
                resultOut += "With an assessed valued of $";
                resultOut += "<b>";
                resultOut += assess;
                resultOut += "</b>";
                resultOut += ", it is estimated that you will have to pay $";
                resultOut += "<b>";
                resultOut += annual;
                resultOut += "</b>";
                resultOut += " annually or $";
                resultOut += "<b>";
                resultOut += monthly;
                resultOut += "</b>";
                resultOut += " monthly.";
                resultOut += "</p>";
                resultOut += "</center>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConfirmQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultOut;
    }

    public String getExplain() {

        try {
            String query = "SELECT * FROM CALCULATOR WHERE ROWNUM <= 1 ORDER BY CALCID DESC";

            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

        String explain = "";

        try {
            while (this.results.next()) {
                Calculator calc = new Calculator();
                calc.setCalcID(this.results.getInt("CalcID"));
                calc.setAnnual(this.results.getDouble("annual"));
                calc.setAssessed(this.results.getDouble("assessed"));
                calc.setMonthly(this.results.getDouble("monthly"));
                calc.setType(this.results.getString("type"));

                DecimalFormat df = new DecimalFormat("#.00");
                String type = calc.getType();
                String annual = df.format(calc.getAnnual());
                String assess = df.format(calc.getAssessed());
                String monthly = df.format(calc.getMonthly());

                if (type.equals("Residential")) {
                    explain += "<table class='table table-bordered table-fixed table-hover'>";

                    explain += "<thead class= 'thead-inverse' >";
                    explain += "<tr>";
                    explain += "<th class='col-xs-2'><center>Residential Rollback</center></th>";
                    explain += "<th class='col-xs-2'><center>Homestead Credit</center></th>";
                    explain += "<th class='col-xs-2'><center>Rate Change (per $1000)</center></th>";
                    explain += "</tr>";
                    explain += "</thead>";

                    explain += "<tbody>";
                    explain += "<tr>";
                    explain += "<td class='col-xs-2'>";
                    explain += "<center>55.6259%</center>";
                    explain += "</td>";

                    explain += "<td class='col-xs-2'>";
                    explain += "<center>$4,850</center>";
                    explain += "</td>";

                    explain += "<td>";
                    explain += "<center>2.42957</center>";
                    explain += "</td>";
                    explain += "</tbody>";
                    explain += "</table>";
                }

                if (type.equals("Multi-Residential")) {
                    explain += "<table class='table table-bordered table-fixed table-hover'>";

                    explain += "<thead class= 'thead-inverse' >";
                    explain += "<tr>";
                    explain += "<th class='col-xs-2'><center>Multi-Residential Rollback</center></th>";
                    explain += "<th class='col-xs-2'><center>Rate Change (per $1000)</center></th>";
                    explain += "</tr>";
                    explain += "</thead>";

                    explain += "<tbody>";
                    explain += "<tr>";
                    explain += "<td class='col-xs-2'>";
                    explain += "<center>86.25%</center>";
                    explain += "</td>";

                    explain += "<td>";
                    explain += "<center>2.42957</center>";
                    explain += "</td>";
                    explain += "</tbody>";
                    explain += "</table>";
                }
                
                if (type.equals("Commercial")) {
                    explain += "<table class='table table-bordered table-fixed table-hover'>";

                    explain += "<thead class= 'thead-inverse' >";
                    explain += "<tr>";
                    explain += "<th class='col-xs-2'><center>Commercial Rollback</center></th>";
                    explain += "<th class='col-xs-2'><center>Rate Change (per $1000)</center></th>";
                    explain += "</tr>";
                    explain += "</thead>";

                    explain += "<tbody>";
                    explain += "<tr>";
                    explain += "<td class='col-xs-2'>";
                    explain += "<center>90%</center>";
                    explain += "</td>";

                    explain += "<td>";
                    explain += "<center>2.42957</center>";
                    explain += "</td>";
                    explain += "</tbody>";
                    explain += "</table>";
                }
                
                if (type.equals("Agriculture")) {
                    explain += "<table class='table table-bordered table-fixed table-hover'>";

                    explain += "<thead class= 'thead-inverse' >";
                    explain += "<tr>";
                    explain += "<th class='col-xs-2'><center>Agriculture Rollback</center></th>";
                    explain += "<th class='col-xs-2'><center>Rate Change (per $1000)</center></th>";
                    explain += "</tr>";
                    explain += "</thead>";

                    explain += "<tbody>";
                    explain += "<tr>";
                    explain += "<td class='col-xs-2'>";
                    explain += "<center>46.1068%</center>";
                    explain += "</td>";

                    explain += "<td>";
                    explain += "<center>2.42957</center>";
                    explain += "</td>";
                    explain += "</tbody>";
                    explain += "</table>";
                }
                
                

            }
        } catch (SQLException ex) {
            Logger.getLogger(ConfirmQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return explain;
    }

}
