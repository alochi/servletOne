<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10.05.2018
  Time: 2:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%=("authError".equals(request.getParameter("errorMsg")))?"неверное имя/пароль":""%>
    <%=("noAuth".equals(request.getParameter("errorMsg")))?"Ошибка авторизации":""%>
    <br>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <input type="text" value="user" name="userName"><br>
        <input type="text" value="pass" name="userPassword"><br>
        <input type="submit" value="OK">
    </form>

</body>
</html>
