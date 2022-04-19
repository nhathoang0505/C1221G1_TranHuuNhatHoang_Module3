<%--
  Created by IntelliJ IDEA.
  User: Hoang Tran
  Date: 4/19/2022
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="text-center">Edit User</h1>
    <a class="btn btn-primary" href="/user">Back to User List</a>
    <form method="post">
        <fieldset>
            <legend>User information</legend>
            <div class="form-group">
                <table class="table table-striped">
                    <%--                    <c:if test="${user_update != null}">--%>
                    <%--                        <input type="hidden" name="id" value="<c:out value='${user_update.id}' />"/>--%>
                    <%--                    </c:if>--%>
                    <tr>
                        <td>User Name:</td>
                        <td><input class="form-control" value="${user_update.name}" type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td>User Email:</td>
                        <td><input class="form-control" value="${user_update.email}" type="text" name="email"></td>
                    </tr>
                    <tr>
                        <td>User Country:</td>
                        <td><input class="form-control" value="${user_update.country}" type="text" name="country">
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" class="btn btn-primary" value="Edit Product"></td>
                    </tr>
                </table>
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>
