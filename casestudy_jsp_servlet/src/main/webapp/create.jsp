<%--
  Created by IntelliJ IDEA.
  User: Hoang Tran
  Date: 4/19/2022
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new customer</title>
    <style>
        .message {
            color: green;
        }
    </style>
</head>
<body>
<h1>Create new customer</h1>
<%--<p>--%>
<%--    <c:if test='${requestScope["message"] != null}'>--%>
<%--        <span class="message">${requestScope["message"]}</span>--%>
<%--    </c:if>--%>
<%--</p>--%>
<p>
    <a href="/customers">Back to products list</a>
</p>
<form method="post">
    <%--    fieldset: Tạo đường viền bao ở ngoài--%>
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Customer Type:</td>
                <td><select name="type" id="type">
                    <c:forEach var="customerType" items="${customerTypeList}">
                        <option value="${customerType.customerTypeId}">${customerType.customerTypeName}</option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <td>Customer Name:</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Customer Birthday:</td>
                <td><input type="date" name="birthday"></td>
            </tr>
            <tr>
                <td>Customer Gender:</td>
                <td><select name="gender" id="gender">
                    <option value="0">Female</option>
                    <option value="1">Male</option>
                </select></td>
            </tr>
            <tr>
                <td>Customer ID Card:</td>
                <td><input type="text" name="card"></td>
            </tr>
            <tr>
                <td>Customer Phone:</td>
                <td><input type="text" name="phone"></td>
            </tr><tr>
                <td>Customer Email:</td>
                <td><input type="text" name="email"></td>
            </tr><tr>
                <td>Customer Address:</td>
                <td><input type="text" name="address"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create customer"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
