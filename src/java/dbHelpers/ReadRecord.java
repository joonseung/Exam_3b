/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class ReadRecord {
    
    private Connection conn;
    private ResultSet results;
    
    private Customers customer = new Customers();
    private int customerID;
    
    
    public ReadRecord (int customerID) {

    try{
            Properties props = new Properties(); 
            InputStream instr = getClass().getResourceAsStream("dbConn.properties");
            try {
                props.load(instr);
            } catch (IOException ex) {
                Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                instr.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
            String driver = props.getProperty("driver.name");
            String url = props.getProperty("server.name");
            String username = props.getProperty("user.name");
            String passwd = props.getProperty("user.password");
            
            this. customerID = customerID;
            
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, passwd);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }
    
    public void doRead (){

        try {
            // set up a string to hold our query
            String query = "SELECT * FROM customers WHERE customerID = ?";
            
            //create a preparedstatement using our query string
            PreparedStatement ps  = conn.prepareStatement(query);
            
            //fill in the preparedstatement
            ps.setInt(1, customerID);
            
            //execute the query
            this. results = ps.executeQuery();
            
            this. results.next();
            
            customer.setCustomerID(this.results.getInt("customerID"));
            customer.setFirstName(this.results.getString("firstName"));
            customer.setLastName(this.results.getString("lastName"));
            customer.setAd1(this.results.getString("ad1"));
            customer.setAd2(this.results.getString("ad2"));
            customer.setCity(this.results.getString("city"));
            customer.setStateName(this.results.getString("stateName"));
            customer.setZip(this.results.getString("zip"));
            customer.setEmail(this.results.getString("email"));
            
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
 }
    
    public Customers getCustomer(){
    
        return this.customer;
    }
      
    
}
