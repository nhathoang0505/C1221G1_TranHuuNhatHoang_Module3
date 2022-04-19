<%--
  Created by IntelliJ IDEA.
  User: Hoang Tran
  Date: 4/19/2022
  Time: 9:36 PM
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
    <h1 class="text-center">Create User</h1>
    <h2>
        <a class="btn btn-primary" href="/user">List All Users</a>
    </h2>
    <div align="center">
        <form method="post">
            <table class="table table-striped">
                <tr>
                    <th>User Name:</th>
                    <td>
                        <input class="form-control" type="text" name="name" id="name" />
                    </td>
                </tr>
                <tr>
                    <th>User Email:</th>
                    <td>
                        <input class="form-control" type="text" name="email" id="email" />
                    </td>
                </tr>
                <tr>
                    <th>Country:</th>
                    <td>
                        <input class="form-control" type="text" name="country" id="country" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <button class="btn btn-primary" type="submit">Save</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

</body>
</html>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>