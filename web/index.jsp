


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
                    <div class="panel-default">
                        <div style="height:40px;padding:0" class="panel-heading">
                            <center>
                                <h2>Basic Information</h2>
                            </center>
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


            <div class="row">
                <div class="col-sm-offset-2 col-sm-4">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <center><h2>What's included?</h2></center>
                            <center>Estimated Tax Impact Calculator</center>
                        </div>
                        <div class="panel-body">
                            
                            <center><div class="dropup">
                                <button class="btn btn-success dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                    Please Select Property Type
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                    <li><a href="residential.jsp">Residential</a></li>
                                    <li><a href="multiresidential.jsp">Multi-residential</a></li>
                                    <li><a href="commercial.jsp">Commercial</a></li>
                                    <li><a href="agriculture.jsp">Agricultural</a></li>
                                </ul>
                                </div></center>
                        </div>
                    </div>
                </div>
                 <div class="col-sm-4">
                    <div class="panel panel-info">
                        
                        <div class="panel-body">
                            
                            <a class="twitter-timeline" href="https://twitter.com/affablebean">Tweets by affablebean</a> <script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>
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
