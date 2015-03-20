<%--
  Created by IntelliJ IDEA.
  User: naXa!
  Date: 10.03.2015
  Time: 8:29
--%>
<jsp:useBean id="faculty" scope="request" class="by.naxa.demo.model.Faculty" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:url var="formAction" value="/faculty/create.do" />

<html lang="en">
<head>
    <title>University - Add a faculty</title>
</head>
<body>
<form:form
        action="${formAction}" method="POST" modelAttribute="faculty"
        style="font-size: large">
    <form:hidden path="id" />

    <div align="center">
        <br /><br />
        <label>
            Faculty name:
            <form:input path="name" type="text" size="25"
                   value="${(not empty student.name)? student.name : 'Enter faculty name here' }" />
        </label><br />
        <br /><br />
        <input type="submit" value="Save" />
        <a href="<c:url value="/faculty/list"/>" >
            <input type="button" value="Cancel" />
        </a>
        <br /><br />
    </div>
</form:form>
</body>
</html>
