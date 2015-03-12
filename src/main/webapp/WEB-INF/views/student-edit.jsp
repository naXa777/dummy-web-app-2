<%--
  Created by IntelliJ IDEA.
  User: naXa!
  Date: 10.03.2015
  Time: 8:29
--%>
<jsp:useBean id="faculties" scope="request" type="java.lang.Iterable" />
<jsp:useBean id="genders"   scope="request" type="by.naxa.demo.model.Gender[]" />
<jsp:useBean id="student"   scope="request" class="by.naxa.demo.model.Student" />
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn"   uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="newEntry" value="${student.id le 0}" />
<c:set var="ratesString" value="" />
<c:forEach items="student.rates" var="rate" varStatus="stat">
    <c:set var="ratesString" value="${stat.first? rate : ratesString + ' ' + rate}" />
</c:forEach>

<html lang="en">
<head>
    <title>University - ${newEntry? 'Add' : 'Edit'} student profile</title>
</head>
<body>
<form:form path="form1" modelAttribute="student"
      action="${pageContext.request.contextPath}/spring/student/${newEntry? 'create' : 'edit/'.concat(student.id)}"
      style="font-size: large">
    <div align="center">
        <br /><br />
        <form:label path="name">
            Student's name:
            <form:input path="name" size="25" required="true" value="${student.name}" />
        </form:label><br />
        <!--label>
            Student's profile photo:
            <form:input path="photo" type="?" draggable="true" />
        </label><br /-->
        <form:label path="gender">
            <form:radiobuttons path="gender" items="${genders}" itemLabel="description" />
        </form:label><br />
        <form:label path="faculty">
            Student's faculty:
            <form:select path="faculty" items="${faculties}" itemLabel="name" >
                <form:option value="${student.faculty.name}" selected="true" />    <!-- undocumented feature -->
            </form:select>
        </form:label><br />
        <label>
            Student's rates:
            <input id="rates" type="text" value="${ratesString}" />
        </label><br />
        <!--form:hidden path="id" value="${student.id}" /-->
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
