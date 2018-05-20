<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:wrapper>
    <c:if test="${role == 1}">
        <div class="row-fluid">
            <div class="span12">
                <div class="grid simple ">
                    <div class="grid-title">
                        <h4>Список <span class="semi-bold">занятий</span></h4>
                        <div class="tools">
                            <a href="javascript:;" class="collapse"></a>
                            <a href="javascript:;" class="remove"></a>
                        </div>
                    </div>
                    <div class="grid-body ">

                        <button class="btn btn-primary btn-cons"
                                onclick="document.getElementById('win_addExer').removeAttribute('style');">
                            Добавить занятие
                        </button>

                        <table class="table table-hover table-condensed dataTable">
                            <thead>
                            <tr role="row">
                                <th>Идентификатор</th>
                                <th>Предмет</th>
                                <th>Дата</th>
                                <th>Занятие</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${exercises}" var="exer">
                                <tr>
                                    <td>${exer.getId()}</td>
                                    <td>${exer.getSubjects_id()}</td>
                                    <td>${exer.getDate()}</td>
                                    <td>${exer.getExercise()}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="row-fluid">
            <div class="span12">
                <div class="grid simple" id="win_addExer" style="display:none;">
                    <div class="grid-title">
                        <h4>Добавление <span class="semi-bold">занятия</span></h4>
                        <div class="tools">
                            <a href="javascript:;" class="collapse"></a>
                        </div>
                    </div>
                    <div class="grid-body ">
                        <form action="${pageContext.request.contextPath}/inner/exercises" method="post">
                            <div class="form-group">
                                <p><select name="subject_id">
                                    <c:forEach items="${subjects}" var="subj">
                                        <option value="${subj.getId()}">${subj.getSubject()}</option>
                                    </c:forEach>
                                </select></p>
                            </div>
                            <div class="form-group">
                                <p><input type="date" name="date" value=""/></p>
                            </div>
                            <div class="form-group">
                                <p><input type="text" name="exercise" value=""/></p>
                            </div>
                            <div class="form-actions">
                                <p>
                                    <button type="submit" class="btn btn-primary btn-cons" name="form"
                                            value="addForm">
                                        Отправить
                                    </button>
                                </p>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </c:if>
</t:wrapper>
