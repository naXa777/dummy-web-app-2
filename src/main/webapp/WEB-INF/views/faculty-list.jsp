<%--
  Created by IntelliJ IDEA.
  User: naXa!
  Date: 10.03.2015
  Time: 8:29
--%>
<jsp:useBean id="faculties" scope="request" type="java.lang.Iterable" />
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>University - All Faculties</title>
    <link href="<c:url value="/resources/css/screen.css" />" rel="stylesheet" />
</head>
<body>
<table title="Faculties table" border="1" cellpadding="16" class="dataTable">
    <thead>
    <tr>
        <th>
            <img src="<c:url value="/resources/icons/address-book.png"/>" />
        </th>
        <th>Name</th>
        <th>
            <a href="<c:url value="/faculty/edit"/>">
                <img src="<c:url value="/resources/icons/add-plus.png"/>" alt="[create]" title="Add new faculty" />
            </a>
        </th>
    </tr>
    </thead>
    <c:if test="${empty faculties}">
        <tr>
            <td colspan="3" style="font-size: medium">
                Nothing to display here at the moment.
                Begin with a simple initialization - click <a href="<c:url value="faculty/init.do"/>">/init</a>
                to automatically generate Faculties table.
            </td>
        </tr>
    </c:if>
    <c:forEach items="${faculties}" var="faculty">
        <tr>
            <td></td>
            <td>${faculty.name}</td>
            <td></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
