<%--
  Created by IntelliJ IDEA.
  User: naXa!
  Date: 10.03.2015
  Time: 8:29
--%>
<jsp:useBean id="faculties" scope="request" type="java.lang.Iterable" />
<jsp:useBean id="genders"   scope="request" type="by.naxa.demo.model.Gender[]" />
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn"   uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="newEntry" value="${student.id == null}" />
<c:choose>
    <c:when test="${newEntry}">
        <c:url var="formAction" value="/student/create" />
    </c:when>
    <c:otherwise>
        <c:url var="formAction" value="/student/edit" />
    </c:otherwise>
</c:choose>

<html lang="en">
<head>
    <title>University - ${newEntry? 'Add' : 'Edit'} student profile</title>
    <link href="<c:url value="/resources/css/screen.css" />" rel="stylesheet" />
</head>
<body>
<form:form
      action="${formAction}" method="POST" modelAttribute="student"
      style="font-size: large">
    <form:hidden path="id" />

    <div align="center">
        <br/><br/>
        <form:label path="name">Student's name:</form:label>
        <form:input path="name" size="25" required="true"/>
        <form:errors path="name" cssClass="errorMessage" />
        <br/>
        <%--
        <form:label path="photo">Student's profile photo:</form:label>
        <form:input path="photo" type="?" draggable="true" /><br/>
        --%>
        <form:label path="gender">Gender:</form:label>
        <form:radiobuttons path="gender" items="${genders}" itemLabel="description" />
        <br/>
        <form:label path="faculty">Student's faculty:</form:label>
        <form:select path="faculty" items="${faculties}" itemValue="id">
            <form:option value="${student.faculty.id}" selected="true" />    <!-- undocumented feature -->
        </form:select>
        <br/>
        <form:label path="rates">Student's rates:</form:label>
        <form:input path="rates" />
        <form:errors path="rates" />
        <br/><br/><br/>
        <input type="submit" value="Save" />
        <a href="<c:url value="/student/list"/>">
            <input type="button" value="Cancel" />
        </a>
        <br/><br/>
    </div>
</form:form>
</body>
</html>
