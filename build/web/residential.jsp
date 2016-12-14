
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
                        </div>
                    </div>
                </div>
            </div>



            <div class="row">
                <form class="form-horizontal" name="updateForm" action="updateCalculator" method="post">
                    <div class="form-group">
                        <label for="assValue" class="col-md-offset-4 col-md-2 col-sm-12 control-label">Assessed Value:</label>
                        <div class="col-md-2 col-sm-12">
                            <textarea  rows="1"type="text" name="assValue" id="assValue" placeholder="0.00"/></textarea>
                        </div>
                    </div>
                    <label for="type" class="col-sm-offset-4 col-md-2 col-sm-12 control-label">Property Type:</label>
                    <div class="col-md-2 col-sm-12">
                        <textarea class="form-control" rows="1"type="text" name="type" id="type" readonly/>Residential</textarea>
                    </div>
                    <br><br>
                    
                    <div class="form-group">
                        <div class="col-md-offset-5 col-md-1 col-sm-12">
                            <button type="submit" name="submit" value="Calculate" class="btn btn-primary">Calculate</button>
                        </div>
                        <div class="col-md-2 col-sm-12">
                            <a href="index.jsp" role="button" class="btn btn-danger">Cancel</a>
                        </div>
                    </div>
                </form>
            </div>

    

    <%@include file="includes/footer.jsp" %>

</div> <!-- close wrap -->

</body>

</html>