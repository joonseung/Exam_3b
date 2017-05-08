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
                        <input type ="text" name="firstName" value="" required/>
                        <br>
                        <label> Last Name: </label><br>
                        <input type ="text" name="lastName" value="" required/>
                        <br>
                        <label> Address 1: </label><br>
                        <input type ="text" name="ad1" value="" required/>
                        <br>
                        <label> Address 2: </label><br>
                        <input type ="text" name="ad2" value="" required/>
                        <br>
                        <label> City: </label><br>
                        <input type ="text" name="city" value="" required/>
                        <br>
                        <label> State (ex. IA, IL, NY) : </label><br>
                        <input type ="text" name="stateName" value="" required/>
                        <label>* ex. IA, IL, NY </label>
                        <br>
                        <label> 5 digit Zip Code: </label><br>
                        <input type ="text" name="zip" value="" required/>
                        <br>
                        <label> Email : </label><br>
                        <input type ="text" name="email" value="" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"title="*(Required):example@mail.com"/>
                        <label>* ex. example@mail.com </label>
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
