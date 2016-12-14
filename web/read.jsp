
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>

        <%@include file="includes/bootstrap.jsp"%>

        <title>Group 5 Final</title>
    </head>






    <body>
        <div class="container"> <!-- wrap -->

            <%@include file="includes/header.jsp" %> 

            <%@include file="includes/adminmenu.jsp" %> 

            <div class="row">
                <div class="col-xs-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <% String fullname = (String) request.getAttribute("fullname");%> 
                            <center><h2>Search Results for "<%=fullname%>"</h2></center>
                        </div>


                        <% String searchResults = (String) request.getAttribute("table");%>
                        <%= searchResults%>  
                    </div>
                </div>
            </div>
            <%@include file="includes/footer.jsp" %>

        </div> <!-- close wrap -->
    </body>
</html>
