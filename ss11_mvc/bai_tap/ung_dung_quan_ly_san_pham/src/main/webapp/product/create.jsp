<%--
  Created by IntelliJ IDEA.
  User: Hoang Tran
  Date: 4/15/2022
  Time: 9:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <h1>Product Information</h1>
    <a href="/product">Back to products list</a>
    Product Name <input type="text" name="addName">
    Product Type <input type="text" name="addType">
    Quantity <input type="number" name="addQuantity">
    <button type="submit">Create</button>
</form>
</body>
</html>
