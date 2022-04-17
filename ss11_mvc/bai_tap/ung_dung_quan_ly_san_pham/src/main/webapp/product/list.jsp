<%--
  Created by IntelliJ IDEA.
  User: Hoang Tran
  Date: 4/15/2022
  Time: 8:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product list</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Product name</th>
        <th>Type of product</th>
        <th>Quantity</th>
    </tr>
    <c:forEach var="product" items="${productLists}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.type}</td>
            <td>${product.quantity}</td>
        </tr>
    </c:forEach>

</table>
<a href="/product?action=create">Create</a>
</body>
</html>
