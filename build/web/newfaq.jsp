


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

            <div class="container"> <!-- main -->


                <div class="row">
                    <div class="col-md-offset-1 col-md-10">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <center><h2>Add A New FAQ</h2></center>
                            </div>
                            <br>
                            <form class="form-horizontal" name="addForm" action="addFAQ" method="post"> 

                                <div class="form-group">
                                    <label for="question" class="col-sm-2 control-label">Question:</label>
                                    <div class="col-sm-8">
                                        <textarea class="form-control" rows="1" type="text" name="question" id="question"/></textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="answer" class="col-sm-2 control-label">Answer:</label>
                                    <div class="col-sm-8">
                                        <textarea class="form-control" rows="10"type="text" name="answer" id="answer"/></textarea>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-offset-5 col-sm-12">
                                            <br><br>
                                            <input type="submit" name="submit" class="btn btn-primary" value="Submit" />  
                                            <input type="reset" name="clear" class="btn btn-danger" value="Clear" /> 
                                        </div>
                                    </div> 
                                </div>
                            </form>
                            <br>






                        </div>






                        <br><br><br>


                    </div>  


                   
                </div> <!-- close main -->

 



            </div> 
            <%@include file="includes/footer.jsp" %>
        </div>

    </body>
</html>
