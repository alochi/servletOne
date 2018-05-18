<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:wrapper>
    <div class="grid simple ">
        <div class="grid-title">
            <h4>Прогресс <span class="semi-bold">студентов</span></h4>
        </div>
        <div class="grid-body ">

            <form action="${pageContext.request.contextPath}/inner/progress" method="post">
                <p><select name="marks">
                    <option value="0-5">Все оценки</option>
                    <option value="5-5">Отлично</option>
                    <option value="4-4">Хорошо</option>
                    <option value="3-3">Посредственно</option>
                    <option value="1-2">Плохо</option>
                    <option value="0-0">Без оценок</option>
                </select></p>
                <p>
                    <button type="submit" class="btn btn-primary btn-cons">
                        <i class="fa fa-check"></i>&nbsp;Отправить
                    </button>
                </p>
            </form>
            <table class="table table-hover table-condensed dataTable">
                <thead>
                <tr role="row">
                    <th>Оценка</th>
                    <th>Дата</th>
                    <th>Студент</th>
                    <th>Предмет</th>
                    <th>Тема занятия</th>
                    <th>Отметка о посещении</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${progress}" var="stud">
                    <tr>
                        <td>${stud.getMark()}</td>
                        <td>${stud.getDate()}</td>
                        <td>${stud.getStudents_name()}</td>
                        <td>${stud.getSubject()}</td>
                        <td>${stud.getExercises_name()}</td>
                        <td>${stud.isAttendance()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
</t:wrapper>