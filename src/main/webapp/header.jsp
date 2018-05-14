<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
    <meta charset="utf-8"/>
    <title>Title Goes Here</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <link href="../assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="../assets/css/webarch.css" rel="stylesheet" type="text/css"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body class="">
<!-- BEGIN HEADER -->
<div class="header navbar navbar-inverse ">
    <!-- BEGIN TOP NAVIGATION BAR -->
    <div class="navbar-inner">
        <div class="header-seperation">
            <ul class="nav pull-left notifcation-center visible-xs visible-sm">
                <li class="dropdown">
                    <a href="#main-menu" data-webarch="toggle-left-side">
                        <i class="material-icons">menu</i>
                    </a>
                </li>
            </ul>
            <!-- BEGIN LOGO -->
            <a href="index.html">
                <img src="../assets/img/logo.png" class="logo" alt="" data-src="../assets/img/logo.png"
                     data-src-retina="../assets/img/logo2x.png" width="106" height="21"/>
            </a>
            <!-- END LOGO -->
            <ul class="nav pull-right notifcation-center">
                <li class="dropdown hidden-xs hidden-sm">
                    <a href="index.html" class="dropdown-toggle active" data-toggle="">
                        <i class="material-icons">home</i>
                    </a>
                </li>
                <li class="dropdown hidden-xs hidden-sm">
                    <a href="email.html" class="dropdown-toggle">
                        <i class="material-icons">email</i><span class="badge bubble-only"></span>
                    </a>
                </li>
                <li class="dropdown visible-xs visible-sm">
                    <a href="#" data-webarch="toggle-right-side">
                        <i class="material-icons">chat</i>
                    </a>
                </li>
            </ul>
        </div>
        <!-- END RESPONSIVE MENU TOGGLER -->
        <div class="header-quick-nav">
            <!-- BEGIN TOP NAVIGATION MENU -->
            <div class="pull-left">
                <ul class="nav quick-section">
                    <li class="quicklinks">
                        <a href="#" class="" id="layout-condensed-toggle">
                            <i class="material-icons">menu</i>
                        </a>
                    </li>
                </ul>
                <ul class="nav quick-section">
                    <li class="quicklinks  m-r-10">
                        <a href="#" class="">
                            <i class="material-icons">refresh</i>
                        </a>
                    </li>
                    <li class="quicklinks">
                        <a href="#" class="">
                            <i class="material-icons">apps</i>
                        </a>
                    </li>
                    <li class="quicklinks"><span class="h-seperate"></span></li>
                    <li class="quicklinks">
                        <a href="#" class="" id="my-task-list" data-placement="bottom" data-content=''
                           data-toggle="dropdown" data-original-title="Notifications">
                            <i class="material-icons">notifications_none</i>
                            <span class="badge badge-important bubble-only"></span>
                        </a>
                    </li>
                    <li class="m-r-10 input-prepend inside search-form no-boarder">
                        <span class="add-on"> <i class="material-icons">search</i></span>
                        <input name="" type="text" class="no-boarder " placeholder="Search Dashboard"
                               style="width:250px;">
                    </li>
                </ul>
            </div>
            <div id="notification-list" style="display:none">
                <div style="width:300px">
                    <div class="notification-messages info">
                        <div class="user-profile">
                            <img src="../assets/img/d.jpg" alt="" data-src="../assets/img/d.jpg"
                                 data-src-retina="../assets/img/d2x.jpg" width="35" height="35">
                        </div>
                        <div class="message-wrapper">
                            <div class="heading">
                                David Nester - Commented on your wall
                            </div>
                            <div class="description">
                                Meeting postponed to tomorrow
                            </div>
                            <div class="date pull-left">
                                A min ago
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <!-- END TOP NAVIGATION MENU -->
            <!-- BEGIN CHAT TOGGLER -->
            <div class="pull-right">
                <div class="chat-toggler sm">
                    <h2 style="margin: 1px;">
                        <%=(String)request.getSession().getAttribute("login")%>
                    </h2>
                </div>
                <ul class="nav quick-section ">
                    <li class="quicklinks">

                        <a href="${pageContext.request.contextPath}/login?action=logout">
                            <i class="material-icons">power_settings_new</i>
                        </a>

                    </li>
                </ul>
            </div>
            <!-- END CHAT TOGGLER -->
        </div>
        <!-- END TOP NAVIGATION MENU -->
    </div>
    <!-- END TOP NAVIGATION BAR -->
</div>
<!-- END HEADER -->