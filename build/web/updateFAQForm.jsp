<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.FAQ"%>
<% FAQ visitor = (FAQ) request.getAttribute("FAQ");%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/bootstrap.jsp"%>
        <title>Update a FAQ</title>
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
                                <center><h2>Update a FAQ</h2></center>
                            </div>
                            <br>
                            <form class="form-horizontal" name="updateForm" action="updateThisFAQ" method="post"> 

                                <div class="form-group">

                                    <label for="question" class="col-sm-2 control-label">Question</label>
                                    <div class="col-sm-4">
                                        <textarea class="form-control" rows="1"type="text" name="question" id="question" /><%= visitor.getQuestion()%></textarea>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="answer" class="col-sm-2 control-label">Answer</label>
                                    <div class="col-sm-8">
                                        <textarea class="form-control" rows="10"type="text" name="answer" id="answer"/><%= visitor.getAnswer()%></textarea>
                                        <input type="hidden" name="FAQID" id="FAQID" value="<%= visitor.getFAQID()%>" />

                                    </div>
                                </div>


                                <div class="form-group">
                                    <div class="col-sm-offset-5 col-sm-12">
                                        <button type="submit" name="submit" value="Update" class="btn btn-primary">Update</button>

                                        <a href="editfaq.jsp" role="button" class="btn btn-danger">Cancel</a>
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
