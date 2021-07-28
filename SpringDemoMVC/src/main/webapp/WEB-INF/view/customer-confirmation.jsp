<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<head> <title>
Student Confirmation Form
</title>
</head>
<body>
The Customer is confirmed : ${customer.firstName} ${customer.lastName}
<br><br>
Customer age is ${customer.age}
<br><br>
PostalCode is: ${customer.postalCode}
<br><br>
CourseCode is: ${customer.courseCode}
</body>
</html>