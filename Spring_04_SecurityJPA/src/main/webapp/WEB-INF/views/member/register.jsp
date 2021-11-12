<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="${rootPath}/static/css/form.css" />
<script src="${rootPath}/webjars/jquery/dist/jquery.min.js"></script>

<form:form cssClass="auth_form" method="POST">
    <fieldset>
        <h2>REGISTER</h2>
        <h3 class="error"></h3>
        <input id="username" placeholder="ID" name="username" autocomplete="off"/>
        <input id="password" placeholder="PASSWORD" type="password" name="password" autocomplete="off"/>
        <input id="passwordConfirm" placeholder="PASSWORD CONFIRM" type="password" name="passwordConfirm" autocomplete="off"/>
        <input placeholder="E-mail" type="email" name="email" autocomplete="off"/>
        <button class="btn btn_join_ok" type="button">JOIN</button>
    </fieldset>
</form:form>

<script>
    $(function () {

        // 입력박스에서 tab 을 누르거나 마우스를 다른 곳으로 클릭했을 때
        // lost focus
        $("input#username").on("blur",function () {

            if($(this).val().trim() == "") {
                $("h3.error").text("");
                return;
            }
            // ID 중복검사
            $.ajax({
                url: "${rootPath}/member/idcheck",
                data: {username:$(this).val()}
            })
            .done(function (result) {
                if(result) {
                    // alert("이미 사용중인 ID 입니다")
                    $("h3.error").text("이미 사용중인 ID 입니다").css("color","#fb667a");
                    $(this).focus()
                } else {
                    $("h3.error").text("사용가능한 ID 입니다").css("color","#4dc3fa");
                    $("#password").focus()
                }
            })
        })

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


