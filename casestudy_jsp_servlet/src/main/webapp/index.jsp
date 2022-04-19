<%--
  Created by IntelliJ IDEA.
  User: Hoang Tran
  Date: 4/17/2022
  Time: 10:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<style>
    .name {
        text-align: center;
        margin-right: 40px;
    }
</style>
<body>
<div class="container-fluid border-bottom border-dark">
    <div class=" row p-1 container-fluid d-flex justify-content-between ">
        <div class="col-auto col-sm-5 col-lg-3 d-flex align-items-center bestel-logo">
<%--            logo furama--%>
            <a href=""><img src="https://furamavietnam.com/wp-content/uploads/2018/10/logo.png" alt=""
                            width="80px" class="img-fluid"></a>
        </div>
        <div class="d-flex align-items-center">
            <a href="">Nhật Hoàng <i class="fa fa-sign-in"></i></a>
        </div>
    </div>
</div>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse p-1" id="navbarTogglerDemo03 ">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
                <a class="nav-link " href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link " href="/employees">Employee <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/customers">Customer <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/services">Service <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="#">Contract <span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input style="border-radius: 20px" class="form-control mr-sm-2" type="search" placeholder="Search"
                   aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<div class="row d-flex mx-0 ">
    <div class="col-2 d-flex flex-column child px-2">
        <p>Item One</p>
        <p>Item Two</p>
        <p>Item Three</p>
    </div>
    <div class="col-10 d-flex justify-content-center align-items-center">
        <p>Body...</p>
    </div>
</div>
<div class="row mx-0 footer border-top fixed-bottom">
    <div class="col-12 d-flex justify-content-center align-items-center py-2">
        <p class="mb-0">Footer...</p>
    </div>
</div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>

</html>