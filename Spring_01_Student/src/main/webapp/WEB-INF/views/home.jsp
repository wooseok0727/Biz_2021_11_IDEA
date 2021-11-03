<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2021-11-03
  Time: 오전 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>STUDENT</title>
    <link href="/student/static/css/main.css" rel="stylesheet" />
</head>
<body>
  <header>
      <h1>빛나라 고교 학사관리 2021 v1</h1>
  </header>
  <nav class="main_nav">
      <ul>
          <li>HOME</li>
          <li>학생정보</li>
          <li>성적일람표</li>
          <li>로그인</li>
      </ul>
  </nav>
    <section>
    </section>
    <footer>
        <address>CopyRight 	&copy; crash2@naver.com</address>
    </footer>
</body>
<script>
    const nav = document.querySelector("nav.main_nav")
    const section = document.querySelector("section")
    if(nav) {
        nav.addEventListener("click",(e)=> {
            let menu = e.target
            if(menu.tagName === "LI") {
                if(menu.innerText === "학생정보") {
                    fetch("/student/list")
                    .then(response => response.text())
                    .then(result => section.innerHTML = result)
                }
            }
        })
    }
</script>
</html>
