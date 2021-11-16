<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="${rootPath}/static/css/form.css" />
<script src="${rootPath}/webjars/jquery/dist/jquery.min.js"></script>

<%
    /*
    form:form tag 를 사용한 입력폼 디자인
    security 에서 form 에 데이터를 입력하고
    서버로 전송할때는 반드시 POST 방식으로 전송해야 한다
    GET 방식으로 데이터를 전송할때는 인증(로그인정보)와 관련된
    어떤 기능을 수행할수 없다
    인증과 관련하여 어떤 기능을 수행하려면 모든 것은 POST 로 요청해야 한다
    또한 POST 방식으로 요청을 할때는 반드시 _csrf.token 정보를 함께
    전송해야 한다.
    그렇지 않으면 모든 요청에 대하여 서버에서 거부한다
    form 으로 만든 입력변수중에 _csrf.token 값에 서버로 부터 전달받은
    실제 token 을 부착하는 코드를 만들어 한다
    이러한 절차가 순수 html 로 만든 form 에서는 상당히 번거로운 일 된다
    따라서 spring jsp 코드에서는 spring form taglibs 를 import 하고
    form:form 방식으로 HTML 코드를 작성한다
    form:form 방식으로 HTML 코드를 작성하게 되면
    자동으로 _csrf.token 과 관련된 코드가 추가된다.
    */
%>
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


