<%--
  Created by IntelliJ IDEA.
  User: naXa!
  Date: 10.03.2015
  Time: 8:29
--%>
<jsp:useBean id="students" scope="request" type="java.lang.Iterable" />
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <title>University - All Students</title>
</head>
<body>
<table title="Students table" border="1" cellpadding="16" style="font-size: large; width: 100%">
    <thead>
    <tr>
        <th>
            <img src="/resources/icons/address-book.png" />
        </th>
        <th>Name</th>
        <th>Faculty</th>
        <th>
            <a href="${pageContext.request.contextPath}/spring//student/edit/0">
                <img src="/resources/icons/add-plus.png" alt="[create]" title="Add new student" />
            </a>
        </th>
    </tr>
    </thead>
    <c:if test="${empty students}">
        <tr>
            <td colspan="4" style="font-size: medium">
                Nothing to display here at the moment.
                Begin with a simple initialization - click <a href="${pageContext.request.contextPath}/init">/init</a>
                to generate Faculties table. Then you can start adding students (use the "plus" button above).
            </td>
        </tr>
    </c:if>
    <c:forEach items="${students}" var="student">
        <tr>
            <td></td>
            <td>
                <a href="${pageContext.request.contextPath}/spring/student/edit/${student.id}" title="Click to edit">${student.name}</a>
            </td>
            <td>${student.faculty.name}</td>
            <td>
                <form action="${pageContext.request.contextPath}/spring/student/delete/${student.id}" method="POST">
                    <input type="image" src="/resources/icons/delete-cross.png" alt="[delete]" title="Delete this student" />
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
