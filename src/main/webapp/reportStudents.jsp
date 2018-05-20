<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:wrapper>
    <c:if test="${role == 1}">
        <div class="row-fluid">
            <div class="span12">
                <div class="grid simple ">
                    <div class="grid-title">
                        <h4>Наши <span class="semi-bold">студенты</span></h4>
                        <div class="tools">
                            <a href="javascript:;" class="collapse"></a>
                            <a href="javascript:;" class="remove"></a>
                        </div>
                    </div>
                    <div class="grid-body ">

                        <button class="btn btn-primary btn-cons"
                                onclick="document.getElementById('win_addStud').removeAttribute('style');">
                            Добавить студента
                        </button>

                        <table class="table table-hover table-condensed dataTable">
                            <thead>
                            <tr role="row">
                                <th>Идентификатор</th>
                                <th>ФИО</th>
                                <th>Логин</th>
                                <th>Пароль</th>
                                <th>Действия</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${students}" var="stud">
                                <tr>
                                    <td>${stud.getId()}</td>
                                    <td>${stud.getName()}</td>
                                    <td>${stud.getLogin()}</td>
                                    <td>${stud.getPasswordhash()}</td>
                                    <td>
                                        <span class="m_editstud"
                                              idstud="${stud.getId()}"
                                              namestud="${stud.getName()}"
                                              loginstud="${stud.getLogin()}"
                                              passwordhashstud="${stud.getPasswordhash()}">
                                            Редактировать
                                        </span>
                                    </td>
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
                <div class="grid simple" id="win_editStud" style="display:none;">
                    <div class="grid-title">
                        <h4>Редактирование <span class="semi-bold">студента</span></h4>
                        <div class="tools">
                            <a href="javascript:;" class="collapse"></a>
                        </div>
                    </div>
                    <div class="grid-body ">
                        <form action="${pageContext.request.contextPath}/inner/students" method="post">
                            <div class="form-group">
                                <label class="form-label">Идентификатор</label>
                                <span class="help">(не редактируется)</span>
                                <p><input class="form-control" type="text" name="editStudId" id="m_id" value=""
                                          readonly/></p>
                            </div>
                            <div class="form-group">
                                <label class="form-label">ФИО</label>
                                <p><input class="form-control" type="text" name="editStudName" id="m_name" value=""/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label class="form-label">Логин</label>
                                <p><input class="form-control" type="text" name="editStudLogin" id="m_login" value=""/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label class="form-label">Пароль</label>
                                <p><input class="form-control" type="text" name="editStudPasswordhash" id="m_pass" value=""/>
                                </p>
                            </div>
                            <div class="form-actions">
                                <p>
                                    <button type="submit" class="btn btn-primary btn-cons" name="form"
                                            value="editForm">
                                        Отправить
                                    </button>
                                </p>
                            </div>
                        </form>
                    </div>
                </div>

                <div class="grid simple" id="win_addStud" style="display:none;">
                    <div class="grid-title">
                        <h4>Добавление <span class="semi-bold">студента</span></h4>
                        <div class="tools">
                            <a href="javascript:;" class="collapse"></a>
                        </div>
                    </div>
                    <div class="grid-body ">
                        <form action="${pageContext.request.contextPath}/inner/students" method="post">
                            <div class="form-group">
                                <label class="form-label">ФИО</label>
                                <p><input type="text" name="addStudName" value=""/></p>
                            </div>
                            <div class="form-group">
                                <label class="form-label">Логин</label>
                                <p><input type="text" name="addStudLogin" value=""/></p>
                            </div>
                            <div class="form-group">
                                <label class="form-label">Пароль</label>
                                <p><input type="text" name="addStudPasswordhash" value=""/></p>
                            </div>
                            <div class="form-actions">
                                <p>
                                    <button type="submit" class="btn btn-primary btn-cons" name="form" value="addForm">
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