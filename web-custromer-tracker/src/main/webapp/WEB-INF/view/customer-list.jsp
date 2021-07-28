<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
<title> List Customers </title>
<body>

<div id="wrapper">
<div id="header">
<h2>CRM- CUSTOMER RELATIONSHIP MANAGER</h2>
</div>
</div>

<input type="button" value="ADD CUSTOMER"
onclick="window.location.href='customerForm';
return false;"/>
<div id="container">
<div id="content">
<table>
<tr>
<th> First Name </th>
<th> Last Name </th>
<th> Email </th>
<th> Action </th>

</tr>

<c:forEach var="temp" items="${customers}">

<c:url var="updateLink" value="/customer/showFormUpdate">
<c:param name="customerId" value="${temp.id}"/>
</c:url>
<c:url var="deleteLink" value="/customer/deleteCustomer">
<c:param name="customerId" value="${temp.id}"/>
</c:url>

<tr>
<td> ${temp.firstName} </td>
<td> ${temp.lastName} </td>
<td> ${temp.email} </td>

<td>
<!-- display update Link -->
<a href="${updateLink}">Update</a> |<a href="${deleteLink}">Delete</a>
</td>
</tr>

</c:forEach>
</table>
</div>
</div>
</body>

</html>