<%@page import="model.Customers"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Customers customer = (Customers) request.getAttribute("customer");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/stylesheet.css"/>
        <title>Update A Customer</title>
    </head>
    <body>
        <div class="wrap"> <!--div to hold all other divs -->

            <%@ include file="includes/header.jsp" %>

            <%@ include file="includes/menu.jsp" %>

            <div class="main"> <!--main div -->

                <h1>Update A Customer Record - Advanced View </h1>

                <div class="update">
                    <form name="updateForm" action="updateCustomer" method="get"> 

                        <table>
                            <tr>
                                <td> Customer ID:</td>
                                <td><input type ="text" name="customerID" value="<%= customer.getCustomerID()%>" readonly/></td>
                            </tr>

                            <tr>
                                <td> First Name:</td>
                                <td><input type ="text" name="firstName" value="<%= customer.getFirstName()%>"/></td>
                            </tr>

                            <tr>
                                <td> Last Name:</td>
                                <td><input type ="text" name="lastName" value="<%= customer.getLastName()%>"/></td>
                            </tr>

                            <tr>
                                <td> Address 1:</td>
                                <td><input type ="text" name="ad1" value="<%= customer.getAd1()%>"/></td>
                            </tr>
                            
                            <tr>
                                <td> Address 2:</td>
                                <td><input type ="text" name="ad2" value="<%= customer.getAd2()%>"/></td>
                            </tr>
                            
                            <tr>
                                <td> City:</td>
                                <td><input type ="text" name="city" value="<%= customer.getCity()%>"/></td>
                            </tr>
                            
                            <tr>
                                <td> State:</td>
                                <td><input type ="text" name="stateName" value="<%= customer.getStateName()%>"/></td>
                            </tr>
                            
                            <tr>
                                <td> Zip:</td>
                                <td><input type ="text" name="zip" value="<%= customer.getZip()%>"/></td>
                            </tr>
                            
                            <tr>
                                <td> Email:</td>
                                <td><input type ="text" name="email" value="<%= customer.getEmail()%>"/></td>
                            </tr>
                        </table>

                        <br><br>    
                        <input type ="submit" name="submit" value="Update" />
                    </form>
                </div>

            </div> <!-- close main div -->

            <%@ include file="includes/footer.jsp" %>

        </div> <!-- close wrap div -->

    </body>
</html>
