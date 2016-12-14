


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Support"%>
<% Support visitor = (Support) request.getAttribute("Support");%>
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
                                <center><h2>Add New Member</h2></center>
                            </div>
                            <br>
                            <form class="form-horizontal" name="adminaddForm" action="adminadd" method="post"> 

                                <div class="form-group">
                                    <label for="firstName" class="col-sm-2 control-label">First Name</label>
                                    <div class="col-sm-10">
                                        <textarea class="form-control" rows="1"type="text" name="firstName" id="firstName" required/></textarea>
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
                                        <textarea class="form-control" rows="1"type="text" name="email" id="email" required/></textarea>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="phone" class="col-sm-2 control-label">Phone Number</label>
                                    <div class="col-sm-10">

                                        <textarea class="form-control" rows="1"type="text" name="phone" id="phone" required/></textarea>

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
                                
                                

<!--                                <div class="form-group">
                                    <label for="posted" class="col-sm-2 control-label">Keep Posted</label>
                                    <div class="col-sm-10">
                                        <textarea class="form-control" rows="1"type="text" name="posted" id="posted"/></textarea>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="willhelp" class="col-sm-2 control-label">Will Help</label>
                                    <div class="col-sm-10">
                                        <textarea class="form-control" rows="1"type="text" name="willhelp" id="willhelp"/></textarea>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="support" class="col-sm-2 control-label">Will Support</label>
                                    <div class="col-sm-10">
                                        <textarea class="form-control" rows="1"type="text" name="support" id="support"/></textarea>
                                    </div>
                                </div>-->

                                <div class="form-group">
                                    <label for="why" class="col-sm-2 control-label">Why</label>
                                    <div class="col-sm-10">
                                        <textarea class="form-control" rows="10"type="text" name="why" id="why"/></textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-6 col-sm-10">
                                        <button type="submit" name="submit" value="Update" class="btn btn-default">Add Member</button>
                                    </div>
                                </div>



                            </form>
                        </div>
                    </div>







                    <br>


                </div>  



            </div> <!-- close main -->












            <%@include file="includes/footer.jsp" %>

        </div> <!-- close wrap -->
    </body>

</html>
