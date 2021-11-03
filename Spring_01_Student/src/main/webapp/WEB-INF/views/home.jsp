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
</head>
<style>
    * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
    }

    body {
        width: 100vw;
        height: 100vh;
        background: #1c222e;
        display: flex;
        flex-direction: column;
    }

    header {
        text-align: center;
        color: #fff842;
    }

    header h1 {
        padding: 1rem;
    }

    nav {
        color: #4dc3fa;
        border: 1px solid #1f2739;
    }

    nav ul {
        list-style: none;
        display: flex;
        margin: 0 1rem;
    }

    nav li  {
        padding: 0.5rem;
        cursor: pointer;
        border-bottom: 3px solid transparent;
        transition: 0.5s;
        font-weight: bold;
    }

    nav li:nth-of-type(3) {
        margin-right: auto;
    }

    nav li:hover {
        border-bottom: 3px solid #fb667a;
    }

    section {
        flex: 1;
    }

    table {
        width: 100%;
        margin: 20px auto;
        border-collapse: collapse;
        border-spacing: 0;
        color: #fff;
        font-size: 0.9rem;
        font-weight: bold;
        table-layout: fixed;
        transition: 0.3s;
    }

    table th,
    table td {
        padding: 8px;
    }

    table td {
        text-align: center;
        cursor: pointer;
    }

    table tr.title_tr {
        background-color: #1f2739;
        color: #fb667a;
    }

    table tr:nth-of-type(n+1):hover {
        background-color: #1f2739;
    }

    footer {
        text-align: center;
        color: #fff842;
        padding: 1rem;
        font-weight: bold;
    }

</style>
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
