<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<body>
<h2> Student Registration Form <h2>
<form:form action="processForm" modelAttribute="student" >
First Name:<form:input path="firstName"/>
<br><br>
Last Name:<form:input path="lastName"/>
<br><br>
COUNTRY :
<form:select path="country">
<form:options items="${student.country_list}" />
</form:select>
<br><br>
FAVOURITE LANGUAGE:
<br>
JAVA <form:radiobutton path="favouriteLanguage" value="Java"/>
C <form:radiobutton path="favouriteLanguage" value="C"/>
CPP <form:radiobutton path="favouriteLanguage" value="CPP"/>
Python<form:radiobutton path="favouriteLanguage" value="Python"/>
<br><br>
Operating Systems:
<br>
Linux : <form:checkbox path="operatingSystem" value="Linux"/>
Mac OS : <form:checkbox path="operatingSystem" value="Mac OS"/>
Windows : <form:checkbox path="operatingSystem" value="Windows"/>
<br><br>
<input type = "submit" value="Submit"/>
</form:form>
</body>

</html>
