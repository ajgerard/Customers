
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>

        <meta name="viewport" content="width=device-width, initial-scale=1">

        <script src="http://code.jquery.com/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="bootstrap.css">

        <title>Group 5 Final</title>
    </head>
    <body>
        <div class="container"> <!-- wrap -->



            <%@include file="includes/header.jsp"%>


            <%@include file="includes/menu.jsp" %> 


            <div class="row"> 
                <div class="col-xs-12">
                    <!-- main content -->
                    <div class="panel-default">
                        <div style="height:40px;padding:0" class="panel-heading">
                            <center>
                                <h2>Community Group Bio</h2>
                            </center>
                        </div>
                    </div>
                </div> 
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <div class="panel-default">
                        <div class="panel-body">
                            <jsp:include page="/bioread"/>
                            <% String table = (String) request.getAttribute("table");%>
                            <%= table%>                           
                            
                        </div> 
                    </div>   
                </div>

            </div>



            <%@include file="includes/footer.jsp" %>

        </div> <!-- close wrap -->
    </body>

</html>

