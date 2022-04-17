<%--
  Created by IntelliJ IDEA.
  User: Hoang Tran
  Date: 4/17/2022
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Products</h1>
<form action="/product" method="get">
    <input type="text"  placeholder="Search product" name="search">
    <input type="hidden" name="action" value="search">
    <button type="submit">Search product</button>
</form>
<p>
        <a href="/product?action=create">Create new product</a>
</p>
<table>
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Type</th>
        <th>Price</th>
    </tr>
    <%--    var = element trong for each--%>
    <c:forEach items='${requestScope["productsList"]}' var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.type}</td>
            <td>${product.price}</td>
            <td><a href="/product?action=delete&id=${product.id}">delete</a></td>
            <td><a href="/product?action=edit&id=${product.id}">edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
