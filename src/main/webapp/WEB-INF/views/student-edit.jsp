<%--
  Created by IntelliJ IDEA.
  User: naXa!
  Date: 10.03.2015
  Time: 8:29
--%>
<jsp:useBean id="faculties" scope="request" type="java.lang.Iterable" />
<jsp:useBean id="student" scope="request" class="by.naxa.demo.model.Student" />
<jsp:useBean id="rates" scope="request" class="java.lang.String" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="newEntry" value="${student.id le 0}" />
<html lang="en">
<head>
    <title>University - ${newEntry? 'Add' : 'Edit'} student profile</title>
</head>
<body>
<form:form name="form1"
      action="${pageContext.request.contextPath}/spring/student/${newEntry? 'create' : 'edit/'.concat(student.id)}"
      method="POST" style="font-size: large">
    <div align="center">
        <br /><br />
        <label>
            Student's name:
            <form:input path="name" type="text" size="25" required="true"
                   value="${(not empty student.name)? student.name : 'Enter student\'s name here' }" />
        </label><br />
        <!--label>
            Student's profile photo:
            <form:input path="photo" type="?" draggable="true"/>
        </label><br /-->
        <label>
            Student's faculty:
            <form:select path="faculty">
                <c:forEach items="${faculties}" var="faculty">
                    <form:option  value="${faculty.name}" selected="${student.faculty eq faculty}" />
                </c:forEach>
            </form:select>
        </label><br />
        <label>
            Student's rates:
            <form:input path="rates" type="text" value="${(not empty rates)? rates : 'Enter student\'s rates here'}" />
            <form:errors path="rates" cssStyle="color: red;" />
        </label><br />
        <form:input path="id" type="hidden" value="${student.id}" />
        <br /><br />
        <input type="submit" value="Save" />
        <a href="${pageContext.request.contextPath}/spring/student/list">
            <input type="button" value="Cancel" />
        </a>
        <br /><br />
    </div>
</form:form>
</body>
</html>
