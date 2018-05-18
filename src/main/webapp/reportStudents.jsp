<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:wrapper>
    <div class="grid simple ">
        <div class="grid-title">
            <h4>Наши <span class="semi-bold">студенты</span></h4>
        </div>
        <div class="grid-body ">
            <c:if test="${role == 1}">
                <table class="table table-hover table-condensed dataTable">
                    <thead>
                    <tr role="row">
                        <th>ФИО</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${students}" var="stud">
                        <tr>
                            <td>${stud.getName()}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
</t:wrapper>