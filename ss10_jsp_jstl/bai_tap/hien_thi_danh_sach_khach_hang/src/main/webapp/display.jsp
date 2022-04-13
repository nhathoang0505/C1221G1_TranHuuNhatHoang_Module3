<%--
  Created by IntelliJ IDEA.
  User: Hoang Tran
  Date: 4/13/2022
  Time: 10:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display Customer</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>
<table class="table table-striped table-dark">
    <tr>
        <th>Name</th>
        <th>Date of Birth</th>
        <th>Address</th>
        <th>Picture</th>
    </tr>
    <c:forEach var="element" items="${customers}">
        <tr>
            <td>${element.name}</td>
            <td>${element.dateOfBirth}</td>
            <td>${element.address}</td>
            <td><img src="${element.link}" alt="picture" style="width: 60px;"></td>
        </tr>
    </c:forEach>

</table>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
</body>
</html>
