<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:wrapper>
    <c:if test="1 == 1">
        <p>123</p>
    </c:if>
        <table border="0">
            <c:forEach items="${students}" var="stud">
                <tr>
                    <td>${stud.name}</td>
                </tr>
            </c:forEach>
        </table>

</t:wrapper>