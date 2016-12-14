
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
                <div class="col-md-offset-1 col-md-10">
                    <form class="form-vertical" name="updateForm" action="filterCalc" method="post"> 
                        <div class='checkbox'>
                            <div class='col-sm-2'>
                                <label><input type = "checkbox" name = 'commercial' value = 'y' id= 'commercial'>Commercial</label>
                            </div>
                        </div>
                        <div class='checkbox'>
                            <div class='col-sm-2'>
                                <label><input type = "checkbox" name = 'residential' value = 'y' id= 'residential'>Residential</label>
                            </div>
                        </div>
                        <div class='checkbox'>
                            <div class='col-sm-2'>
                                <label><input type = "checkbox" name = 'multi-residential' value = 'y' id= 'multi-residential'>Multi-Residential</label>
                            </div>
                        </div>
                        <div class='checkbox'>
                            <div class='col-sm-2'>
                                <label><input type = "checkbox" name = 'agriculture' value = 'y' id= 'agriculture'>Agriculture</label>
                            </div>
                        </div>
                        <div class='checkbox'>
                            <div class='col-sm-2'>
                                <label><input type = "checkbox" checked="checked" name = 'ascending' value = 'y' id= 'ascending'>Ascending</label>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <div class="col-sm-offset-5 col-sm-12">
                                <button type="submit" name="submit" value="Filter" class="btn btn-primary">Filter</button>

                            </div>
                        </div>

                    </form>
                    <br><br>

                </div>
            </div>

            <div class="row">
                <div class="col-xs-12">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <center><h2>All Tax Records</h2></center>
                        </div>
                        <table class="table table-bordered table-fixed table-hover">



                            <% String full = (String) request.getAttribute("table");%>
                            <%= full%>  
                        </table>
                    </div>
                </div>





            </div>
            <%@include file="includes/footer.jsp" %>
        </div> <!-- close wrap -->
    </body>

</html>
