<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:wrapper>
    <c:if test="${role == 1}">
        <div class="row-fluid">
            <div class="span12">
                <div class="grid simple ">
                    <div class="grid-title">
                        <h4>Поставить <span class="semi-bold">оценку</span></h4>
                        <div class="tools">
                            <a href="javascript:;" class="collapse"></a>
                            <a href="javascript:;" class="remove"></a>
                        </div>
                    </div>
                    <div class="grid-body ">
                        <form action="${pageContext.request.contextPath}/inner/progress" method="post">
                            <div class="form-group">
                                <label class="form-label">Студенты</label>
                                <p><select name="student_id">
                                    <c:forEach items="${students}" var="stud">
                                        <option value="${stud.getId()}">${stud.getName()}</option>
                                    </c:forEach>
                                </select></p>
                            </div>
                            <div class="form-group">
                                <label class="form-label">Занятие</label>
                                <p><select name="edate">
                                    <c:forEach items="${exercises}" var="exer">
                                        <option value="${exer.getId()}">${exer.getDate()} - ${exer.getExercise()}</option>
                                    </c:forEach>
                                </select></p>
                            </div>
                            <div class="form-group">
                                <label class="form-label">Оценка</label>
                                <p><select name="mark">
                                    <option value="0">Без оценок</option>
                                    <option value="5">Отлично</option>
                                    <option value="4">Хорошо</option>
                                    <option value="3">Посредственно</option>
                                    <option value="2">Плохо</option>
                                </select></p>
                            </div>
                            <div class="form-group">
                                <label class="form-label">Посещение</label>
                                <p><select name="attendance">
                                    <option value="true">Студент присутствовал</option>
                                    <option value="false">не присутствовал</option>
                                </select></p>
                            </div>
                            <div class="form-actions">
                                <p>
                                    <button type="submit" class="btn btn-primary btn-cons" name="form"
                                            value="markForm">
                                        Поставить оценку
                                    </button>
                                </p>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
    <div class="row-fluid">
        <div class="span12">
            <div class="grid simple ">
                <div class="grid-title">
                    <h4>Прогресс <span class="semi-bold">студентов</span></h4>
                    <div class="tools">
                        <a href="javascript:;" class="collapse"></a>
                        <a href="javascript:;" class="remove"></a>
                    </div>
                </div>
                <div class="grid-body ">
                    <form action="${pageContext.request.contextPath}/inner/progress" method="post">
                        <div class="form-group">
                            <label class="form-label">Оценка</label>
                            <p><select name="marks">
                                <option value="0-5">Все оценки</option>
                                <option value="5-5">Отлично</option>
                                <option value="4-4">Хорошо</option>
                                <option value="3-3">Посредственно</option>
                                <option value="1-2">Плохо</option>
                                <option value="0-0">Без оценок</option>
                            </select></p>
                        </div>
                        <div class="form-actions">
                            <p>
                                <button type="submit" class="btn btn-primary btn-cons" name="form"
                                        value="filterForm">
                                    Фильтр
                                </button>
                            </p>
                        </div>
                    </form>
                    <table class="table table-hover table-condensed dataTable" style="margin-top:60px;">
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
            </div>
        </div>
    </div>
</t:wrapper>