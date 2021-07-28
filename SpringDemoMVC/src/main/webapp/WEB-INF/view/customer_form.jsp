<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<head>
<title>Customer Registration Form </title>
<style>
.error{color:red}
</style>
</head>
<body>
<form:form action="processForm" modelAttribute="customer" >
First Name:<form:input path="firstName"/>
<br><br>
Last Name(*):<form:input path="lastName"/>
<form:errors path="lastName" cssClass="error"/>
<br><br>
Age : <form:input path="age"/>
<form:errors path="age" cssClass="error"/>
<br><br>
PostalCode: <form:input path="postalCode"/>
<form:errors path="postalCode" cssClass="error"/>
<br><br>
CourseCode: <form:input path="courseCode"/>
<form:errors path="courseCode" cssClass="error"/>
<br><br>
<input type = "submit" value="Submit"/>
</form:form>
</body>
</html>
