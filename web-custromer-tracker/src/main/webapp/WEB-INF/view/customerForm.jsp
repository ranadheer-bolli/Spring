<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<head>
<title>Customer Registration Form </title>
</head>
<body>
<form:form action="saveCustomer" modelAttribute="customer" method="POST" >
<form:hidden path="id"/>
First Name:<form:input path="firstName"/>
<br><br>
Last Name:<form:input path="lastName"/>
<br><br>
Email: <form:input path="email"/>
<br><br>
<input type = "submit" value="Submit"/>
</form:form>
</body>
</html>