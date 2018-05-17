<%@ page import="ru.innopolis.stc9.servlets.pojo.Students" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- BEGIN SIDEBAR -->
<div class="page-sidebar " id="main-menu">
    <!-- BEGIN MINI-PROFILE -->
    <div class="page-sidebar-wrapper scrollbar-dynamic" id="main-menu-wrapper">
        <div class="user-info-wrapper sm">
            <div class="profile-wrapper sm">
                <img src="../assets/img/avatar.jpg" alt="" data-src="../assets/img/avatar.jpg"
                     data-src-retina="../assets/img/avatar2x.jpg" width="69" height="69"/>
                <div class="availability-bubble online"></div>
            </div>
            <div class="user-info sm">
                <div class="username"><%=(String) request.getSession().getAttribute("login")%>
                </div>
                <div class="status">2B||!2B</div>
            </div>
        </div>
        <!-- END MINI-PROFILE -->
        <!-- BEGIN SIDEBAR MENU -->
        <a href="${pageContext.request.contextPath}/inner/students">
            <p class="menu-title sm">STUDENTS <span class="pull-right">
                <i class="material-icons">refresh</i></span>
            </p>
        </a>

        <a href="${pageContext.request.contextPath}/inner/mark">
            <p class="menu-title sm">MARKs <span class="pull-right">
                <i class="material-icons">refresh</i></span>
            </p>
        </a>

        <div class="clearfix"></div>
        <!-- END SIDEBAR MENU -->
    </div>
</div>
<a href="#" class="scrollup">Scroll</a>
<div class="footer-widget">
    <div class="progress transparent progress-small no-radius no-margin">
        <div class="progress-bar progress-bar-success animate-progress-bar" data-percentage="79%"
             style="width: 79%;"></div>
    </div>
    <div class="pull-right">
        <div class="details-status"><span class="animate-number" data-value="100"
                                          data-animation-duration="560">100</span>%
        </div>
        <a href="${pageContext.request.contextPath}/login?action=logout"><i
                class="material-icons">power_settings_new</i></a></div>
</div>
<!-- END SIDEBAR -->
