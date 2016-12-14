
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>

        <%@include file="includes/bootstrap.jsp"%>

        <title>Group 5 Final</title>
    </head>
    <body>
        <div class="container"> <!-- wrap -->



            <%@include file="includes/header.jsp"%>


            <%@include file="includes/adminmenu.jsp" %> 


            <div class="row">
                <div class="col-xs-12">
                    <center><h2>FAQ Editor</h2></center>
                        <jsp:include page="/adminfull"/>
                        <% String full = (String) request.getAttribute("table");%>
                        <%= full%>              
                </div>
            </div>


            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                    <center><h2>Mailing List</h2></center>
                        <jsp:include page="/adminmail"/>
                        <% String mail = (String) request.getAttribute("table");%>
                        <%= mail%> 
                    <input type="submit" name="submit"   value="Submit" /> 
                </div>
                <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                    <center><h2>Mailing List</h2></center>
                        <jsp:include page="/adminmail"/>
                        <% String volunteer = (String) request.getAttribute("table");%>
                        <%= volunteer%>
                </div>
            </div>


            <%@include file="includes/footer.jsp" %>

        </div> <!-- close wrap -->
    </body>

</html>