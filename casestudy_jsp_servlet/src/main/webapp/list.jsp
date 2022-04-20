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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css" type="text/css">

</head>
<body>
<form action="/customer" method=""></form>

<a href="/customers"><h1>Customers List</h1></a>
<p>
    <a href="/customers?action=create">Create new customer</a>
</p>
<form action="/customers" method="get">
    <input type="text" placeholder="Input Customer's name" name="search">
    <button type="submit">Search</button>
    <input type="hidden" name="action" value="search">
</form>
<table class="table" id="example">
    <thead class="thead-dark">
    <tr style="position: -webkit-sticky;
  position: sticky;
  top: 0;
  z-index: 2;">
        <th scope="col">Customer ID</th>
        <th scope="col">Customer Type</th>
        <th scope="col">Customer name</th>
        <th scope="col">Customer Birthday</th>
        <th scope="col">Customer Gender</th>
        <th scope="col">CustomerID card</th>
        <th scope="col">Customer Phone Number</th>
        <th scope="col">Customer Email</th>
        <th scope="col">Customer Address</th>
    </thead>
    </tr>
    <tbody>
    <c:forEach var="customer" items="${customersList}">
        <tr>
            <td>${customer.customerId}</td>
            <c:forEach var="customerType" items="${customerTypeList}">
                <c:if test="${customer.customerTypeId == customerType.customerTypeId}">
                    <td><c:out value="${customerType.customerTypeName}"></c:out></td>
                </c:if>
            </c:forEach>
            <td><c:out value="${customer.customerName}"/></td>
            <td><c:out value="${customer.customerBirthday}"/></td>
            <td><c:if test="${customer.customerGender==1}">
                <c:out value="Male"></c:out>
            </c:if>
                <c:if test="${customer.customerGender==0}">
                    <c:out value="Female"></c:out>
                </c:if>
            </td>
            <td>${customer.customerIdCard}</td>
            <td>${customer.customerPhone}</td>
            <td>${customer.customerEmail}</td>
            <td>${customer.customerAddress}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
<%--bootrap 4.6 + 3.5  + phân trang--%>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>
<%--<script src="https://code.jquery.com/jquery-3.5.1.js"></script>--%>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#example').DataTable(
            {
                "dom": 'lrtip',
                // "lengthChange": false,
                // "pageLength": 5
            }
        );
    });
</script>
