
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="${rootPath}/static/css/form.css" />
<script src="${rootPath}/webjars/jquery/dist/jquery.min.js"></script>

<form:form cssClass="auth_form" action="${rootPath}/login">
    <fieldset>
        <h2>LOGIN</h2>
        <c:if test="${param.error != null}">
            <h3>${ERROR_MSG == null ? '로그인을 하세요' : ERROR_MSG}</h3>
        </c:if>
        <input placeholder="ID" name="username" autocomplete="off"/>
        <input placeholder="PASSWORD" type="password" name="password" autocomplete="off"/>
        <button class="btn btn_login">LOGIN</button>
        <button type="button" class="btn btn_register">REGISTER</button>
    </fieldset>
</form:form>
<h1>${AUTHOR}</h1>

<script>
    $(function () {
        $("button.btn_register").on("click",function () {
            location.href = `${rootPath}/member/register`
        })
    })

</script>