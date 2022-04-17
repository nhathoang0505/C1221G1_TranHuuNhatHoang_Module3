<%--
  Created by IntelliJ IDEA.
  User: Hoang Tran
  Date: 4/17/2022
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete product</title>
</head>
<body>
<p>
    <a href="/product">Back to products list</a>
</p>
<form method="post">
    <%--    fieldset: Tạo đường viền bao ở ngoài--%>
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>ID</td>
                <td>${productsDelete.id}</td>
            </tr>
            <tr>
                <td>Product Name:</td>
                <td>${requestScope["productsDelete"].name}</td>
            </tr>
            <tr>
                <td>Product type:</td>
                <td>${productsDelete.type}</td>
            </tr>
            <tr>
                <td>Product Price:</td>
                <td>${productsDelete.price}</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Delete"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
