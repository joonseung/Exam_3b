package dbHelpers;

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
import model.Customers;

/**
 *
 * @author Abc
 */
public class SearchQuery {

    private Connection conn;
    private ResultSet results;

    public SearchQuery() {
        try {
            Properties props = new Properties();
            InputStream instr = getClass().getResourceAsStream("dbConn.properties");
            try {
                props.load(instr);
            } catch (IOException ex) {
                Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                instr.close();
            } catch (IOException ex) {
                Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            String driver = props.getProperty("driver.name");
            String url = props.getProperty("server.name");
            String username = props.getProperty("user.name");
            String passwd = props.getProperty("user.password");
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

     public void doSearch(String firstName, String lastName){
        
        try {
            String query = "SELECT * FROM customers WHERE (UPPER(firstName) LIKE ? OR UPPER(lastName) LIKE ? ) ORDER BY customerID ASC";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + firstName.toUpperCase() + "%");
            ps.setString(2, "%" + lastName.toUpperCase() + "%");

            
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public String getHTMLTable() {

        String table = "";

        table += "<table>";

        try {

            table += "<thead>";
            table += "<th>";
            table += "Customer ID";
            table += "</th>";

            table += "<th>";
            table += "First Name";
            table += "</th>";

            table += "<th>";
            table += "Last Name";
            table += "</th>";

            table += "<th>";
            table += "Address 1";
            table += "</th>";

            table += "<th>";
            table += "Address 2";
            table += "</th>";

            table += "<th>";
            table += "City";
            table += "</th>";
            
            table += "<th>";
            table += "State Name";
            table += "</th>";
            
            table += "<th>";
            table += "Zip Code";
            table += "</th>";
            
            table += "<th>";
            table += "Email";
            table += "</th>";
            
            table += "<th>";
            table += "Action";
            table += "</th>";

            table += "</thead>";

            while (this.results.next()) {

                Customers customer = new Customers();
                customer.setCustomerID(this.results.getInt("customerID"));
                customer.setFirstName(this.results.getString("firstName"));
                customer.setLastName(this.results.getString("lastName"));
                customer.setAd1(this.results.getString("ad1"));
                customer.setAd2(this.results.getString("ad2"));
                customer.setCity(this.results.getString("city"));
                customer.setStateName(this.results.getString("stateName"));
                customer.setZip(this.results.getString("zip"));
                customer.setEmail(this.results.getString("email"));

                table += "<tr>";

                table += "<td>";
                table += customer.getCustomerID();
                table += "</td>";

                table += "<td>";
                table += customer.getFirstName();
                table += "</td>";

                table += "<td>";
                table += customer.getLastName();
                table += "</td>";

                table += "<td>";
                table += customer.getAd1();
                table += "</td>";
                
                table += "<td>";
                table += customer.getAd2();
                table += "</td>";
                
                table += "<td>";
                table += customer.getCity();
                table += "</td>";
                
                table += "<td>";
                table += customer.getStateName();
                table += "</td>";
                
                table += "<td>";
                table += customer.getZip();
                table += "</td>";
                
                table += "<td>";
                table += customer.getEmail();
                table += "</td>";

                table += "<td>";
                table += "<a href = update?customerID=" + customer.getCustomerID() + "> Update </a>" + "<a href = delete?customerID=" + customer.getCustomerID() + "> Delete </a>";
                table += "</td>";

                table += "</tr>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

        table += "</table>";

        return table;
    }
}
