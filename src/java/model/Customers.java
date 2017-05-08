/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Abc
 */
public class Customers {

    private int customerID;
    private String firstName;
    private String lastName;
    private String ad1;
    private String ad2;
    private String city;
    private String stateName;
    private String zip;
    private String email;

    public Customers() {
        this.customerID = 0;
        this.firstName = "";
        this.lastName = "";
        this.ad1 = "";
        this.ad2 = "";
        this.city = "";
        this.stateName = "";
        this.zip = "";
        this.email = "";

    }

    public Customers(int customerID, String firstName, String lastName, String ad1, String ad2, String city, String stateName, String zip, String email) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ad1 = ad1;
        this.ad2 = ad2;
        this.city = city;
        this.stateName = stateName;
        this.zip = zip;
        this.email = email;

    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAd1() {
        return ad1;
    }

    public void setAd1(String ad1) {
        this.ad1 = ad1;
    }

    public String getAd2() {
        return ad2;
    }

    public void setAd2(String ad2) {
        this.ad2 = ad2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customers{" + "customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName + ", ad1=" + ad1 + ", ad2=" + ad2 + ", city=" + city + ", stateName=" + stateName + ", zip=" + zip + ", email=" + email + '}';
    }

    
    
} 
    /*
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getChampName() {
        return champName;
    }

    public void setChampName(String champName) {
        this.champName = champName;
    }

    public String getChampRole() {
        return champRole;
    }

    public void setChampRole(String champRole) {
        this.champRole = champRole;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSkins() {
        return skins;
    }

    public void setSkins(int skins) {
        this.skins = skins;
    }

    @Override
    public String toString() {
        return "lolChampions{" + "champID=" + champID + ", champName=" + champName + ", champRole=" + champRole + ", price=" + price + ", skins=" + skins + '}';
    }
*/
