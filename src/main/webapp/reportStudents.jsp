<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp" %>
<!-- BEGIN CONTENT -->
<div class="page-container row-fluid">

    <% if ((Integer) request.getSession().getAttribute("role") == 1) {%>
    <%@include file="sidebar.jsp"%>
    <%}%>

    <!-- BEGIN PAGE CONTAINER-->
    <div class="page-content">
        <div class="content">
            <!-- BEGIN PAGE TITLE -->
            <div class="page-title">
                <%if ((Integer) request.getSession().getAttribute("role") == 1) {%>
                <h3>ADMIN Dashboard</h3>

                <% ArrayList<Students> students = (ArrayList) request.getAttribute("students");%>
                <div>
                    <%=students%>
                </div>

                <br>
                <%}%>
                <h3>User content...</h3>
                <form action="${pageContext.request.contextPath}/inner/mark" method="get">
                    <p><select name="mark">
                        <option disabled>Select mark</option>
                        <option selected value="5">5</option>
                        <option value="4">4</option>
                        <option value="3">3</option>
                        <option value="2">2</option>
                        <option value="0">Without mark</option>
                    </select></p>
                    <p><input type="submit" value="Send"></p>
                </form>

                <table>
                    <c:forEach var="mark" items="${mark}">
                        <tr>
                            <td><c:out value="${mark}" /></td>
                        </tr>
                    </c:forEach>
                </table>


            </div>
            <!-- END PAGE TITLE -->
            <!-- BEGIN PlACE PAGE CONTENT HERE -->
            <!-- END PLACE PAGE CONTENT HERE -->
        </div>
    </div>
    <!-- END PAGE CONTAINER -->
</div>
<!-- END CONTENT -->
<%@include file="footer.jsp" %>
