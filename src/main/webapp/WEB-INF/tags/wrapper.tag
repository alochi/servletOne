<%@ tag description="Wrapper Tag" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/pageHeader.jsp" />
<!-- BEGIN CONTENT -->
<div class="page-container row-fluid">
    <% if ((Integer) request.getSession().getAttribute("role") == 1) {%>
    <c:import url="/pageSidebar.jsp" />
    <%}%>
    <div class="page-content">
        <div class="content">
            <div class="page-title">
                <!-- BEGIN doBody -->
                <jsp:doBody/>
                <!-- END doBody -->
            </div>
        </div>
    </div>
</div>
<!-- END CONTENT -->
<c:import url="/pageFooter.jsp" />