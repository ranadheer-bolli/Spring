<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "security" uri = "http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<head>
<title>Spring Security Demo</title>
<body>
<h2> WELCOME HOME </h2>
<!-- diplay user and role -->
<p> User: <security:authentication property="principal.username"/><br><br>
<p> Role(s): <security:authentication property="principal.authorities"/><br><br>
<p>
<!-- ADD A LINK TO POINT TO LEADERS -->
<security:authorize access="hasRole('MANAGER')">
<a href="${pageContext.request.contextPath}/leaders">LEADERSHIP MEETING</a>
(ONLY FOR MANAGER)
</security:authorize>
</p>
<p>
<!-- ADD A LINK TO POINT TO SYSTEMS MEETING -->
<security:authorize access="hasRole('ADMIN')">
<a href="${pageContext.request.contextPath}/systems">SYSTEMS MEETING</a>
(ONLY FOR ADMINS)
</security:authorize>
</p>


<form:form action="${pageContext.request.contextPath}/logout" method="POST">
<input type="submit" value="Logout"/>
</form:form>
</body>
</html>