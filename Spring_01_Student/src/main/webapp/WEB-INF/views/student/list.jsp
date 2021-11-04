<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="student_list">
    <thead>
    <tr class="title_tr">
        <th>학번</th>
        <th>이름</th>
        <th>전공</th>
        <th>학년</th>
        <th>주소</th>
        <th>전화번호</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${empty STLIST}">
            <tr>
                <td colspan="6">NO DATA</td>
            </tr>
        </c:when>
        <c:otherwise>
            <c:forEach items="${STLIST}" var="ST">
                <tr>
                    <td>${ST.st_num}</td>
                    <td>${ST.st_name}</td>
                    <td>${ST.st_dept}</td>
                    <td>${ST.st_grade}</td>
                    <td>${ST.st_address}</td>
                    <td>${ST.st_tel}</td>
                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>