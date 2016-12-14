


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


            <%@include file="includes/menu.jsp" %> 


            <div class="row"> 
                <div class="col-xs-12">
                    <!-- main content -->
                    <div class="panel panel-success">
                        <div style="height:40px;padding:0" class="panel-heading">
                            <center>
                                <h2>FAQ</h2>
                            </center>
                        </div>
                    </div>
                </div> 
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <div class="panel-default">
                        <div class="panel-body">
                            <jsp:include page="/userfaq"/>
                            <% String table = (String) request.getAttribute("table");%>
                            <%= table%>
                        </div> 
                    </div>   
                </div>

            </div>


            
                        <br>
                        <br>
                        
            <%@include file="includes/footer.jsp" %>

        </div> <!-- close wrap -->
        
    </body>

</html>
