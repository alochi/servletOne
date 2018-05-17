<%@ page import="ru.innopolis.stc9.servlets.pojo.Progress" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:wrapper>
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
                <td><c:out value="${mark}"/></td>
            </tr>
        </c:forEach>
    </table>
</t:wrapper>