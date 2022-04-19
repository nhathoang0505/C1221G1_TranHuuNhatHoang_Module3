<%--
  Created by IntelliJ IDEA.
  User: Hoang Tran
  Date: 4/19/2022
  Time: 9:36 PM
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
    <h1 class="text-center">Delete Product</h1>
    <a class="btn btn-primary" href="/product">Back to Product List</a>
    <form method="post">
        <h3>Are you sure?</h3>
        <fieldset>
            <legend>Product information</legend>
            <div class="form-group">
                <table class="table table-striped">
                    <tr>
                        <td>Name Product:</td>
                        <td>${product.nameProduct}</td>
                    </tr>
                    <tr>
                        <td>Price:</td>
                        <td>${product.price}</td>
                    </tr>
                    <tr>
                        <td>Description:</td>
                        <td>${product.description}</td>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" class="btn btn-danger" value="Delete Product"></td>
                        <td><a class="btn btn-primary" href="/product">Back to Product List</a></td>
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
