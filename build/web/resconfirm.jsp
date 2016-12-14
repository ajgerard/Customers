
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
                        <div class="panel-heading">
                            <center>
                                <h2>Residential Property Tax Calculator</h2>
                            </center>
                        </div>
                    </div>
                </div> 
            </div>

            <div class="row">
                <div class="col-xs-12">
                    <div class="panel-default">
                        <div class="panel-body">
                            <center><p>NOTE: Assessed value is NOT market value. Review your recent tax bill from your County Assessor
                                    to determine the ASSESSED VALUE.</p></center>
                                    <jsp:include page="/confirmread"/>
                                    <% String table = (String) request.getAttribute("table");%>
                                    <% String explain = (String) request.getAttribute("explain");%>
                                    <%= table%>
                                    <center>Annual Tax = ((Assessed Value * Rollback) - Credit) * Rate Change</center>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-offset-2 col-xs-8">
                    <div class="panel panel-default">
                        
                        

                            <jsp:include page="/confirmread"/>

                            <% String full = (String) request.getAttribute("explain");%>
                            <%= full%>  
                        
                    </div>
                </div>
            </div>
     


    <%@include file="includes/footer.jsp" %>

</div> <!-- close wrap -->

</body>

</html>