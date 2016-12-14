
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
                            <center><h2>Full Contact List</h2></center>
                        </div>
                        <table class="table table-bordered table-fixed table-hover">

                            <jsp:include page="/adminfull"/>

                            <% String full = (String) request.getAttribute("table");%>
                            <%= full%>  
                        </table>
                    </div>
                </div>


                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <center><h2>Mailing List</h2></center>
                            </div>
                            <jsp:include page="/adminmail"/>
                            <% String mail = (String) request.getAttribute("table");%>
                            <%= mail%>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <center><h2>Volunteers</h2></center>
                            </div>
                            <jsp:include page="/adminvolunteer"/>
                            <% String volunteer = (String) request.getAttribute("table");%>
                            <%= volunteer%>
                        </div>
                    </div>

                </div>


            </div>
            <%@include file="includes/footer.jsp" %>
        </div> <!-- close wrap -->
    </body>

</html>
