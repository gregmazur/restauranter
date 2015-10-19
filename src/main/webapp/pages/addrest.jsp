<%@page language="java" contentType="text/html"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--
  Created by IntelliJ IDEA.
  User: greg
  Date: 19.10.15
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
  meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Registration</title>
</head>
<body>
<div align="center">
  <form:form action="register" method="post" commandName="form">
    <table border="0">
      <tr>
        <td colspan="2" align="center"><h2>Spring MVC Form Demo - Registration</h2></td>
      </tr>
      <tr>
        <td>Restaurant name:</td>
        <td><form:input path="name" /></td>
      </tr>
      <tr>
        <td>longitude:</td>
        <td><form:input path="longitude" /></td>
      </tr>
      <tr>
        <td>latitude:</td>
        <td><form:input path="latitude" /></td>
      </tr>
      <tr>
        <td colspan="2" align="center"><input type="submit" value="Register" /></td>
      </tr>
    </table>
  </form:form>
</div>
</body>
</html>
