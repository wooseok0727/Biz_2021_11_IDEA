<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="https://fonts.googleapis.com/css2?family=Space+Mono&display=swap" rel="stylesheet">
<style>


    form.login_form {
        width: 400px;
        padding: 40px;
        background: #1c222e;
        text-align: center;
        border-radius: 20px;
        box-shadow: 8px 8px 2px 1px rgba(0,0,0,0.3);
        margin: 20px auto;
        font-family: "Space Mono", monospace;
        font-weight: bold;
        letter-spacing: 1px;
    }

    form.login_form h2 {
        color: #fff;
    }

    form.login_form h3 {
        color: #fff842;
        background: #1f2739;
    }

    form.login_form input {
        background: none;
        margin: 20px auto;
        text-align: center;
        border: 2px solid #1f2739;
        padding: 14px 10px;
        width: 200px;
        outline: none;
        color: #fff;
        border-radius: 25px;
        transition: 0.2s;
        font-family: "Space Mono", monospace;
        font-weight: bold;
        letter-spacing: 1px;
    }

    form.login_form input:focus {
        width: 280px;
        border-color: #fb667a;
    }

    form.login_form input::placeholder {
        color: #fff;
    }

    form.login_form button {
        background: none;
        margin: 20px auto;
        width: 200px;
        padding: 14px 10px;

        text-align: center;
        outline: none;

        color: #fff;
        border-radius: 25px;
        transition: 0.3s;
        font-family: "Space Mono", monospace;
        font-weight: bold;
        letter-spacing: 1px;
    }

    form.login_form button:hover {
        background: #4dc3fa;
    }

</style>

<form:form cssClass="login_form" action="${rootPath}/login">
    <fieldset>
        <h2>LOGIN</h2>
        <c:if test="${param.error != null}">
            <h3>ERROR</h3>
        </c:if>
        <input placeholder="ID" name="username" autocomplete="off"/>
        <input placeholder="PASSWORD" type="password" name="password" autocomplete="off"/>
        <button>LOGIN</button>
        <button type="button">REGISTER</button>
    </fieldset>
</form:form>