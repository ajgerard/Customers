
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
                    <div class="panel-default">
                        <div class="plans"  >

                            <img  class="planp" src="includes/cobra.png" height="150px"   />

                            <img class="planp" src="includes/cobra.png" height="150px" />

                        </div>
                    </div>
                </div> 
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <div class="panel-default">
                        <div class="panel-body">
                            <jsp:include page="/initread"/>
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