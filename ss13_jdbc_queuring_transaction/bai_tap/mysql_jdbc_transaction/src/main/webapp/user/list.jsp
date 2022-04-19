<%--
  Created by IntelliJ IDEA.
  User: Hoang Tran
  Date: 4/19/2022
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="text-center">User Management</h1>
    <h2 class="text-center">List of Users</h2>

    <div class="col-4 float-left">
        <a class="btn btn-primary " href="/users?action=create">Add New User</a>
    </div>
    <div class="col-4 float-left">
        <form action="/users">
            <select name="sort_method" class="form-control col-8 float-left">
                <option>ascending</option>
                <option>descending</option>
            </select>
            <button class="btn btn-success col-2" type="submit" name="action" value="sort">Sort</button>
        </form>
    </div>
    <div class="col-4 form-group d-flex justify-content-end">
        <form action="/users">

            <div class="form-outline">
                <input name="search_input" value="${search_input}" type="search" id="form1"
                       class="form-control col-9 float-left"/>
                <input type="hidden" name="action" value="search">
                <button type="submit" class="btn btn-info col-3">
                    Search
                </button>
            </div>

        </form>
    </div>

    <div>
        <table class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.country}"/></td>
                    <td>
                        <a class="btn btn-info" href="/users?action=edit&id=${user.id}">Edit</a>
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#staticBackdrop"
                                onclick="confirmDelete(${user.id},'${user.name}','${user.email}','${user.country}')">
                            Delete</a>
                        </button>
                    </td>

                </tr>
            </c:forEach>
        </table>

    </div>
</div>

<div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1"
     aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Delete Confirm</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="post">
                <div class="modal-body">
                    <h3>Are you sure?</h3>
                    <div id="user_id"></div>
                    <div id="user_name"></div>
                    <div id="user_email"></div>
                    <div id="user_country"></div>

                    <%--gửi id cần xoá lên servlet--%>
                    <input type="hidden" name="id" id="id_delete">
                    <%--gửi action lên servlet--%>
                    <input type="hidden" name="action" value="delete">
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-danger">Yes</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
<script>
    function confirmDelete(id, name, email, country) {
        document.getElementById("id_delete").value = id;
        document.getElementById("user_id").innerText = "id: " + id;
        document.getElementById("user_name").innerText = "name: " + name;
        document.getElementById("user_email").innerText = "email: " + email;
        document.getElementById("user_country").innerText = "country: " + country;
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>
