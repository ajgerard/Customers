

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/bootstrap.jsp"%>
        <title>Search Games</title>        
    </head>
    <body>
        <div class="wrap"> <!-- wrap -->

            <%@include file="includes/header.jsp" %>

            <%@include file="includes/menu.jsp" %>

            <div class="main"> <!-- main -->


                <form name="searchForm" action="search" method="post">
                    <table class="table2">
                        <th colspan="2">Search for a contact</th>
                        <tr>
                            <td>First Name:</td>
                            <td><input type="text" name="searchVal1" value=""/></td>
                        </tr>
                        <tr>
                            <td>Last Name:</td>
                            <td><input type="text" name="searchVal2" value=""/></td>
                        </tr>
                    </table>

                    <br>

                    <input type="submit" name="submit" value="Search"/>
                    <button onclick="href = 'read'">Go Back</button>

                </form>

            </div> <!-- close main -->


            <%@include file="includes/footer.jsp" %>

        </div> <!-- close wrap -->  

    </body>
</html>
