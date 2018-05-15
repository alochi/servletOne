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
                <%@include file="reportStudents.jsp" %>
                <br>
                <%}%>

                <h3>User content...</h3>
                <%@include file="reportMark.jsp" %>


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