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
                    <br>
                <%}%>
                <h3>User content...</h3>
                <form action="${pageContext.request.contextPath}/inner/reports" method="get">
                    <p><select name="mark">
                        <option disabled>Выберите оценку</option>
                        <option selected value="5">Отлично</option>
                        <option value="4">Хорошо</option>
                        <option value="3">Посредственно</option>
                        <option value="2">Плохо</option>
                        <option value="0">Нет оценок</option>
                    </select></p>
                    <p><input type="submit" value="Отправить"></p>
                </form>
                <%=("5".equals(request.getParameter("mark")))?"5":""%>



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
