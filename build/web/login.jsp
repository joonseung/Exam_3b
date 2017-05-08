<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/stylesheet.css"/>
        <title>JSP Page</title>  
    </head>
    <body>
        <div class="wrap"> <!--div to hold all other divs -->


            <%@ include file="includes/header.jsp" %>

            <%@ include file="includes/menu.jsp" %>


            <div class="main"> <!--main div -->

                <h1> Authorized Person Only </h1>

                <div class = "login">
                    <img src="includes/yoshiyaki.jpg" alt="Login Required" style="height:228px;" align="middle">
                    <br><br>
                    <h3>Managing Data is Only Available For Managers.
                        <br><br>
                        Please Login!</h3>
                    <br> <br>
                    <form action="read" method="get">
                        <input type="submit" value="I Am a Manager"/>
                    </form>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <form action="index.jsp" method="get">
                        <input type="submit" value="Go Back to Main"/>
                    </form>

                </div> 


                <br> <br> <br>

            </div> <!-- close main div -->

            <%@ include file="includes/footer.jsp" %>

        </div> <!-- close wrap div -->
    </body>
</html>
