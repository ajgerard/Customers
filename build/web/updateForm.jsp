<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Support"%>
<% Support visitor = (Support) request.getAttribute("Support");%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/bootstrap.jsp"%>
        <title>Update a Visitor</title>
    </head>
    <body>
        <div class="container"> <!-- wrap -->

            <%@include file="includes/header.jsp" %> 

            <%@include file="includes/adminmenu.jsp" %> 

            <div class="container"> <!-- main -->   



                <div class="row">
                    <div class="col-md-offset-1 col-md-10">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <center><h2>Update a Record</h2></center>
                            </div>
                            <br>
                            <form class="form-horizontal" name="updateForm" action="updateVisitor" method="post"> 

                                <div class="form-group">

                                    <label for="id" class="col-sm-2 control-label">CustomerID</label>
                                    <div class="col-sm-10">
                                        <textarea class="form-control" rows="1"type="text" name="id" id="id" readonly/><%= visitor.getCustomerID()%></textarea>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="firstName" class="col-sm-2 control-label">First Name</label>
                                    <div class="col-sm-10">
                                        <textarea class="form-control" rows="1"type="text" name="firstName" id="firstName" required/><%= visitor.getFirstName()%></textarea>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="lastName" class="col-sm-2 control-label">Last Name</label>
                                    <div class="col-sm-10">
                                        <textarea class="form-control" rows="1"type="text" name="lastName" id="lastName" required/><%= visitor.getLastName()%></textarea>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="email" class="col-sm-2 control-label">Email</label>
                                    <div class="col-sm-10">
                                        <textarea class="form-control" rows="1"type="text" name="email" id="email" required/><%= visitor.getEmail()%></textarea>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="phone" class="col-sm-2 control-label">Phone Number</label>
                                    <div class="col-sm-10">

                                        <textarea class="form-control" rows="1"type="text" name="phone" id="phone" required/><%= visitor.getPhone()%></textarea>

                                    </div>
                                </div>

                                <%  String posted = visitor.getPosted();
                                    String cbPosted = "";
                                    if (posted.equals("y")) {

                                        cbPosted = "<div class='checkbox'><div class='col-sm-offset-2 col-sm-8'><label ><input type = 'checkbox' checked='checked' name = 'posted' value = 'y' id= 'posted' > Keep me posted on updates</label></div></div>";
                                    } else {
                                        cbPosted = "<div class='checkbox'><div class='col-sm-offset-2 col-sm-8'><label ><input type = 'checkbox' name = 'posted' value = 'y' id= 'posted' > Keep me posted on updates</label></div></div>";
                                    }

                                %>       

                                <%= cbPosted%>

                                <%  String willhelp = visitor.getWillhelp();
                                    String cbWillHelp = "";
                                    if (willhelp.equals("y")) {

                                        cbWillHelp = "<div class='checkbox'><div class='col-sm-offset-2 col-sm-8'><label ><input type = 'checkbox' checked='checked' name = 'willhelp' value = 'y' id= 'willhelp' >I am willing to volunteer</label></div></div>";
                                    } else {
                                        cbWillHelp = "<div class='checkbox'><div class='col-sm-offset-2 col-sm-8'><label ><input type = 'checkbox' name = 'willhelp' value = 'y' id= 'willhelp' >I am willing to volunteer</label></div></div>";
                                    }

                                %>       

                                <%= cbWillHelp%>

                                <%  String willsupport = visitor.getSupport();
                                    String cbWillSupport = "";
                                    if (willsupport.equals("y")) {

                                        cbWillSupport = "<div class='checkbox'><div class='col-sm-offset-2 col-sm-8'><label ><input type = 'checkbox' checked='checked' name = 'support' value = 'y' id= 'support' >I want to support this referendum</label></div></div>";
                                    } else {
                                        cbWillSupport = "<div class='checkbox'><div class='col-sm-offset-2 col-sm-8'><label ><input type = 'checkbox' name = 'support' value = 'y' id= 'support' >I want to support this referendum</label></div></div>";
                                    }

                                %>       

                                <%= cbWillSupport%>


                                <br>





                                <div class="form-group">
                                    <label for="why" class="col-sm-2 control-label">Why</label>
                                    <div class="col-sm-10">
                                        <textarea class="form-control" rows="10"type="text" name="why" id="why"/><%= visitor.getWhy()%></textarea>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="why" class="col-sm-2 control-label">Comments</label>
                                    <div class="col-sm-10">
                                        <textarea class="form-control" rows="10"type="text" name="comments" id="comments"/><%= visitor.getComments()%></textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-5 col-sm-12">
                                        <button type="submit" name="submit" value="Update" class="btn btn-primary">Update</button>

                                        <a href="dashboard.jsp" role="button" class="btn btn-danger">Cancel</a>
                                    </div>
                                </div>


                            </form>
                        </div>
                    </div>







                    <br>


                </div>  



            </div> <!-- close main -->


            <%@include file="includes/footer.jsp" %>

        </div> 
    </body>
</html>
