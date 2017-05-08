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
public class ReadQueryNormal {

    private Connection conn;
    private ResultSet results;

    public ReadQueryNormal() {

        try {
            Properties props = new Properties();
            InputStream instr = getClass().getResourceAsStream("dbConn.properties");
            try {
                props.load(instr);
            } catch (IOException ex) {
                Logger.getLogger(ReadQueryNormal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                instr.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadQueryNormal.class.getName()).log(Level.SEVERE, null, ex);
            }
            String driver = props.getProperty("driver.name");
            String url = props.getProperty("server.name");
            String username = props.getProperty("user.name");
            String passwd = props.getProperty("user.password");
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQueryNormal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQueryNormal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void doRead2() {

        String query = "Select *from customers ORDER BY customerID ASC";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(ReadQueryNormal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getHTMLTable2() {

        String table2 = "";

        table2 += "<table>";

        try {

            table2 += "<thead>";
            table2 += "<th>";
            table2 += "ID";
            table2 += "</th>";

            table2 += "<th>";
            table2 += "First Name";
            table2 += "</th>";

            table2 += "<th>";
            table2 += "Last Name";
            table2 += "</th>";

            table2 += "<th>";
            table2 += "Address 1";
            table2 += "</th>";

            table2 += "<th>";
            table2 += "Address 2";
            table2 += "</th>";

            table2 += "<th>";
            table2 += "City";
            table2 += "</th>";

            table2 += "<th>";
            table2 += "State";
            table2 += "</th>";

            table2 += "<th>";
            table2 += "Zip Code";
            table2 += "</th>";

            table2 += "<th>";
            table2 += "Email";
            table2 += "</th>";
            
        /*    table += "<th>";
            table += "Action";
            table += "</th>";

            table += "</thead>"; */

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

                table2 += "<tr>";

                table2 += "<td>";
                table2 += customer.getCustomerID();
                table2 += "</td>";

                table2 += "<td>";
                table2 += customer.getFirstName();
                table2 += "</td>";

                table2 += "<td>";
                table2 += customer.getLastName();
                table2 += "</td>";

                table2 += "<td>";
                table2 += customer.getAd1();
                table2 += "</td>";

                table2 += "<td>";
                table2 += customer.getAd2();
                table2 += "</td>";

                table2 += "<td>";
                table2 += customer.getCity();
                table2 += "</td>";

                table2 += "<td>";
                table2 += customer.getStateName();
                table2 += "</td>";

                table2 += "<td>";
                table2 += customer.getZip();
                table2 += "</td>";

                table2 += "<td>";
                table2 += customer.getEmail();
                table2 += "</td>";

           /*     table2 += "<td>";
                table2 += "<a href = update?customerID=" + customer.getCustomerID() + "> Update </a>" + "<a href = delete?customerID=" + customer.getCustomerID() + "> Delete </a>";
                table2 += "</td>";

                table2 += "</tr>";*/
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQueryNormal.class.getName()).log(Level.SEVERE, null, ex);
        }

        table2 += "</table>";

        return table2;
    }
}
