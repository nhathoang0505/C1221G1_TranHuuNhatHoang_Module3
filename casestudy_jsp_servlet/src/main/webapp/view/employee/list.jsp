<%--
  Created by IntelliJ IDEA.
  User: Hoang Tran
  Date: 4/21/2022
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<html>
<head>
    <title>Employee List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css" type="text/css">

</head>
<body>
<form action="/employee" method=""></form>

<a href="/employee"><h1>Employee List</h1></a>
<p>
    <a href="/employee?action=create">Create new Employee</a>
</p>
<form action="/employee" method="get">
    <input type="text" placeholder="Input Employee's name" name="search">
    <%--    <button type="submit">Search</button>--%>
    <%--    <input type="hidden" name="action" value="search">--%>
</form>

<table class="table table-striped" id="example">
    <thead class="thead-dark">
    <tr style="position: -webkit-sticky;
  top: 0;
  z-index: 2;">
        <th> ID</th>
        <th> Name</th>
        <th> Birthday</th>
        <th> Id Card</th>
        <th> Salary</th>
        <th> Phone</th>
        <th> Email</th>
        <th> Address</th>
        <th> Position ID</th>
        <th> Education Degree Id</th>
        <th> Divion Id</th>
        <th>Actions</th>
    </thead>
    </tr>


    <tbody>
    <c:forEach var="employee" items="${employeesList}">
    <tr>

        <td>${employee.employeeId}</td>
        <td>${employee.employeeName}</td>
        <td>${employee.employeeBirthday}</td>
        <td>${employee.employeeIdCard}</td>
<%--        <td >${employee.employeeSalary}</td>--%>
        <td><fmt:formatNumber value="${employee.employeeSalary}" type="number"/></td>
        <td>${employee.employeePhone}</td>
        <td>${employee.employeeEmail}</td>
        <td>${employee.employeeAddress}</td>

        <c:forEach var="position" items="${positionsList}">
            <c:if test="${employee.employeePositionId == position.positionId}">
                <td><c:out value="${position.positionName}"></c:out></td>
            </c:if>
        </c:forEach>

        <c:forEach var="educationDegree" items="${educationDegreesList}">
            <c:if test="${employee.employeeEducationDegreeId == educationDegree.educationDegreeId}">
                <td><c:out value="${educationDegree.educationDegreeName}"></c:out></td>
            </c:if>
        </c:forEach>

        <c:forEach var="division" items="${divisionsList}">
            <c:if test="${employee.employeeDivisionId == division.divisionId}">
                <td><c:out value="${division.divisionName}"></c:out></td>
            </c:if>
        </c:forEach>
            <td></td>
    </tr>
    </c:forEach>
</table>
<%--<!-- Modal -->--%>
<%--<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"--%>
<%--     aria-hidden="true">--%>
<%--    <div class="modal-dialog" role="document">--%>
<%--        <div class="modal-content">--%>
<%--            <div class="modal-header">--%>
<%--                <h5 class="modal-title" id="exampleModalLabel">Confirm delete?</h5>--%>
<%--                <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                    <span aria-hidden="true">&times;</span>--%>
<%--                </button>--%>
<%--            </div>--%>
<%--            <form method="post">--%>
<%--                <div class="modal-body">--%>
<%--                    Do you really want to delete ?--%>
<%--                    <div id="customerId"></div>--%>
<%--                    <div id="customerName"></div>--%>
<%--                    <input type="hidden" value="delete" name="action">--%>
<%--                    <input type="hidden" id="idDelete" name="id">--%>
<%--                </div>--%>
<%--                <div class="modal-footer">--%>

<%--                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
<%--                    <button type="submit" class="btn btn-primary">Delete</button>--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
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
    function confirmDelete(id, name) {
        document.getElementById("customerId").innerText = "Id customer: " + id;
        document.getElementById("customerName").innerText = "Customer name: " + name;
        document.getElementById("idDelete").value = id;
    }
</script>
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



