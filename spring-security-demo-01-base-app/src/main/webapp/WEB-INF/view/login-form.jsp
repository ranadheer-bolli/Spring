<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c"   uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
<title>LOGIN FORM</title>
<body>
<h2> LOGIN </h2>

<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">

<c:if test="${param.error!=null}">
<i>Sorry, Invalid Username or Password</i>
</c:if>
<br><br>
Username: <input type="input" name="username"/>
<br><br>
Password: <input type="password" name="password"/>
<br><br>
<input type="submit" value="Login"/>

</form:form>
</body>
</html>