<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<head> <title>
Student Confirmation Form
</title>
</head>
<body>
The Student is confirmed : ${student.firstName} ${student.lastName}
<br><br>
Country Selected is : ${student.country}
<br><br>
Favourite Language is : ${student.favouriteLanguage}
<br><br>
Operating System Selected is : ${student.operatingSystem[1]}
<ul>
 <c:forEach var="temp" items="${student.operatingSystem}"  >
<li> ${temp} </li>
</c:forEach>
</ul>
</body>
</html>