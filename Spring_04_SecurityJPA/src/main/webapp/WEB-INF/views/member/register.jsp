<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="${rootPath}/static/css/form.css" />
<script src="${rootPath}/webjars/jquery/dist/jquery.min.js"></script>

<form:form cssClass="auth_form" method="POST">
    <fieldset>
        <h2>REGISTER</h2>
        <input id="username" placeholder="ID" name="username" autocomplete="off"/>
        <input id="password" placeholder="PASSWORD" type="password" name="password" autocomplete="off"/>
        <input id="passwordConfirm" placeholder="PASSWORD CONFIRM" type="password" name="passwordConfirm" autocomplete="off"/>
        <input placeholder="E-mail" type="email" name="email" autocomplete="off"/>
        <button class="btn btn_join_ok" type="button">JOIN</button>
    </fieldset>
</form:form>

<script>
    $(function () {
        $("button.btn_join_ok").on("click",function () {
            const username = $("#username")
            const password = $("#password")
            const passwordConfirm = $("#passwordConfirm")

            if(username.val() === "") {
                alert("사용자 이름은 반드시 입력하세요")
                username.focus()
                return false;
            }
            if(password.val() === "") {
                alert("비밀번호는 반드시 입력하세요")
                password.focus()
                return false;
            }
            if(passwordConfirm.val() === "") {
                alert("비밀번호를 한번 더 입력하세요")
                passwordConfirm.focus()
                return false;
            }
            if(password.val() !== passwordConfirm.val()) {
                alert("비밀번호와 비밀번호 확인이 일치하지 않습니다")
                password.val("")
                passwordConfirm.val("")
                password.focus()
                return false
            }
            $("form.auth_form").submit()
        })
    })

</script>


