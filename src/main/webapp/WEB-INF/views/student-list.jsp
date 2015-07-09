<%--
  Created by IntelliJ IDEA.
  User: naXa!
  Date: 10.03.2015
  Time: 8:29
--%>
<jsp:useBean id="students" scope="request" type="java.lang.Iterable" />
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <title>University - All Students</title>
    <link href="<c:url value="/resources/css/screen.css"/>" rel="stylesheet" />
</head>
<body>
<table title="Students table" border="1" cellpadding="16" class="dataTable" >
    <thead>
    <tr>
        <th>
            <img src="<c:url value="/resources/icons/address-book.png"/>" alt="" />
        </th>
        <th>Name</th>
        <th>Faculty</th>
        <th>
            <a href="<c:url value="/student/edit/0"/>">
                <img src="<c:url value="/resources/icons/add-plus.png"/>" alt="[+]" title="Add new student" />
            </a>
        </th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${empty students}">
        <tr>
            <td colspan="4" style="font-size: medium">
                Nothing to display here at the moment.
                Begin with a simple initialization - click <a href="<c:url value="/faculty/init.do"/>">/init</a>
                to generate Faculties table. Then you can start adding students (use the "plus" button above).
            </td>
        </tr>
    </c:if>
    <c:forEach items="${students}" var="student">
        <tr>
            <td></td>
            <td>
                <a href="<c:url value="/student/edit/${student.id}"/>" title="Click to edit">${student.name}</a>
            </td>
            <td>${student.faculty.name}</td>
            <td align="center">
                <c:url var="delAction" value="/student/delete/${student.id}.do" />
                <form:form action="${delAction}" method="DELETE">
                    <input type="image" src="<c:url value="/resources/icons/delete-cross.png"/>" alt="[x]"
                           title="Delete this student" />
                </form:form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
