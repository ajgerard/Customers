
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
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <center><h2>Current FAQ's</h2></center>
                        </div>
                        <table class="table table-bordered table-fixed table-hover">

                            <jsp:include page="/adminFAQ"/>

                            <% String full = (String) request.getAttribute("table");%>
                            <%= full%>  
                        </table>
                    </div>
                </div>


                <div class="row">
                    <div class="col-md-offset-4 col-xs-4">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="col-sm-offset-4">
                                    <a href="newfaq.jsp" role="button" class="btn btn-success">Add New FAQ</a>
                                </div>
                            </div>

                        </div>
                    </div>





                </div>
            </div>
            <%@include file="includes/footer.jsp" %>
        </div> <!-- close wrap -->
    </body>

</html>
