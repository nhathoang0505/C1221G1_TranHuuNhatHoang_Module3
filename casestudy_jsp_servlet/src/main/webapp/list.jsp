<%--
  Created by IntelliJ IDEA.
  User: Hoang Tran
  Date: 4/18/2022
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<p>
    <a href="/customers?action=create">Create new customer</a>
</p>
<form action="/customer" method=""></form>
<h1>customer list</h1>
<table >
    <tr>
        <th>id</th>
        <th>type</th>
        <th>name</th>
        <th>birthday</th>
        <th>gender</th>
        <th>idcard</th>
        <th>phone</th>
        <th>email</th>
        <th>address</th>
    </tr>
<c:forEach var="customer" items="${customersList}">
    <tr>
        <td>${customer.customerId}</td>
        <td>${customer.customerTypeId}</td>
        <td>${customer.customerName}</td>
        <td>${customer.customerBirthday}</td>
        <td>${customer.customerGender}</td>
        <td>${customer.customerIdCard}</td>
        <td>${customer.customerPhone}</td>
        <td>${customer.customerEmail}</td>
        <td>${customer.customerAddress}</td>
        <td></td>
    </tr>
</c:forEach>
</table>
</body>
</html>
