


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

            <div class="container"> <!-- main -->


                <div class="row">
                    <div class="col-md-offset-1 col-md-10">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <center><h2>Show Support</h2></center>
                            </div>
                            <br>
                            <form class="form-horizontal" name="addForm" action="addVisitor" method="post"> 

                                <div class="form-group">
                                    <label for="firstName" class="col-sm-2 control-label">First Name</label>
                                    <div class="col-sm-10">
                                        <textarea class="form-control" rows="1" type="text" name="firstName" id="firstName" required/></textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="lastName" class="col-sm-2 control-label">Last Name</label>
                                    <div class="col-sm-10">
                                        <textarea class="form-control" rows="1"type="text" name="lastName" id="lastName" required/></textarea>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="email" class="col-sm-2 control-label">Email</label>
                                    <div class="col-sm-10">
                                        <textarea class="form-control" rows="1" type="email" name="email" id="email" placeholder="example@example.com" required/></textarea>
                                        
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="phone" class="col-sm-2 control-label">Phone Number</label>
                                    <div class="col-sm-10">

                                        <textarea class="form-control" rows="1" type="phone" name="phone" id="phone" placeholder="000-000-0000" required/></textarea>
                                        

                                    </div>
                                </div>

                                <div class="checkbox">
                                    <div class="col-sm-offset-2 col-sm-8">
                                        <label><input type="checkbox" name="posted" value="y">Keep me posted on updates</label>
                                    </div>
                                </div>

                                <div class="checkbox">
                                    <div class="col-sm-offset-2 col-sm-8">
                                        <label><input type="checkbox" name="willhelp" value="y">I am willing to volunteer</label>
                                    </div>
                                </div>

                                <div class="checkbox">
                                    <div class="col-sm-offset-2 col-sm-8">
                                        <label><input type="checkbox" name="support" value="y">I support this referendum</label>
                                    </div>
                                </div>


                                <br>


                                <div class="form-group">
                                    <label for="why" class="col-sm-2 control-label">Why</label>
                                    <div class="col-sm-10">
                                        <textarea class="form-control" rows="10"type="text" name="why" id="why"/></textarea>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="why" class="col-sm-2 control-label">Comments</label>
                                    <div class="col-sm-10">
                                        <textarea class="form-control" rows="10"type="text" name="comments" id="comments"/></textarea>
                                    </div>
                                </div>


                                <div class="form-group">
                                    <div class="col-sm-offset-5 col-sm-12">
                                        <input type="submit" name="submit" class="btn btn-primary" value="Submit" />  
                                        <input type="reset" name="clear" class="btn btn-danger" value="Clear" /> 
                                    </div>
                                </div>     

                                <hr>                                                             

                            </form><br>


                            <div class="row">
                                <div class="col-md-offset-1 col-md-10">
                                    <div class="panel panel-primary">
                                        <div class="panel-body">
                                            <div class="col-md-offset-2 col-md-2">
                                                <a class= 'btn btn-warning' role='button' href="comingsoon.jsp"> $5 </a>
                                            </div>
                                            <div class=" col-md-2">
                                                <a class= 'btn btn-warning' role='button' href="comingsoon.jsp"> $10 </a>
                                            </div>
                                            <div class="col-md-2">
                                                <a class= 'btn btn-warning' role='button' href="comingsoon.jsp"> $20 </a>
                                            </div>
                                            <div class=" col-md-2">
                                                <a class= 'btn btn-warning' role='button' href="comingsoon.jsp"> $50 </a>
                                            </div>


                                            <div class="row">
                                                <div class="col-md-offset-5 col-md-2">
                                                    <br><br>
                                                    <a class='btn btn-info btn-lg' role='button' href="comingsoon.jsp"> DONATE </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>


                            </div>



                        </div>






                        <br><br><br>


                    </div>  



                </div> <!-- close main -->


            </div>
                <%@include file="includes/footer.jsp" %>

            </div> 

    </body>
</html>
