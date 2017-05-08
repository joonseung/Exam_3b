<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/stylesheet.css"/>
        <title> Add A New Customer</title>

    </head>
    <body>
        <div class="wrap"> <!--div to hold all other divs -->

            <%@ include file="includes/header.jsp" %>

            <%@ include file="includes/menu.jsp" %>

            <div class="main"> <!--main div -->

                <h1>Add A New Customer</h1>

                <div class="add">
                    <form name="addFrom" action="addCustomer" method="get">

                        <label> First Name: </label><br>
                        <input type ="text" name="firstName" value=""/>
                        <br>
                        <label> Last Name: </label><br>
                        <input type ="text" name="lastName" value=""/>
                        <br>
                        <label> Address 1: </label><br>
                        <input type ="text" name="ad1" value=""/>
                        <br>
                        <label> Address 2: </label><br>
                        <input type ="text" name="ad2" value=""/>
                        <br>
                        <label> City: </label><br>
                        <input type ="text" name="city" value=""/>
                        <br>
                        <label> State Name: </label><br>
                        <input type ="text" name="stateName" value=""/>
                        <br>
                        <label> Zip: </label><br>
                        <input type ="text" name="zip" value=""/>
                        <br>
                        <label> Email: </label><br>
                        <input type ="text" name="email" value=""/>
                        <br>
                        
                        <br><br>
                        
                        <input type ="reset" name="reset" value="Clear"/>
                        <input type ="submit" name="submit" value="Add Record"/>
                    </form>
                </div>

            </div> <!-- close main div -->

            <%@ include file="includes/footer.jsp" %>

        </div> <!-- close wrap div -->

    </body>
</html>
