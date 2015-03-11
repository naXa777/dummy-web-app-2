<%--
  Created by IntelliJ IDEA.
  User: naXa!
  Date: 10.03.2015
  Time: 8:29
--%>
<jsp:useBean id="faculty" scope="request" class="by.naxa.demo.model.Faculty" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="newEntry" value="${faculty.id le 0}" />
<html lang="en">
<head>
    <title>University - ${newEntry? 'Add' : 'Edit'} a faculty</title>
</head>
<body>
<form:form name="form1"
      commandName="student"
      action="${pageContext.request.contextPath}/spring/faculty/${newEntry? 'create' : 'edit/'.concat(student.id)}"
      method="POST" style="font-size: large">
    <div align="center">
        <br /><br />
        <label>
            Faculty name:
            <form:input path="name" type="text" size="25"
                   value="${(not empty faculty.name)? faculty.name : 'Enter faculty name here' }" />
        </label><br />
        <form:input path="id" type="hidden" value="${faculty.id}" />
        <br /><br />
        <input type="submit" value="Save" />
        <a href="${pageContext.request.contextPath}/spring/faculty/list">
            <input type="button" value="Cancel" />
        </a>
        <br /><br />
    </div>
</form:form>
</body>
</html>
