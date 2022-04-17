<%--
  Created by IntelliJ IDEA.
  User: Hoang Tran
  Date: 4/17/2022
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Edit customer</title>
    <style>
        .message {
            color: green;
        }
    </style>
</head>
<body>
<h1>Edit product</h1>
<%--<p>--%>
<%--    <c:if test='${requestScope["message"] != null}'>--%>
<%--        <span class="message">${requestScope["message"]}</span>--%>
<%--    </c:if>--%>
<%--</p>--%>
<p>
    <a href="/product">Back to products list</a>
</p>
<form method="post">
    <%--    fieldset: Tạo đường viền bao ở ngoài--%>
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Product Name:</td>
                <td><input type="text" name="name" value="${productsEdit.name}"></td>
            </tr>
            <tr>
                <td>Product type:</td>
                <td><input type="text" name="type" value="${productsEdit.type}"></td>
            </tr>
            <tr>
                <td>Product Price:</td>
                <td><input type="text" name="price" value="${productsEdit.price}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Edit product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
