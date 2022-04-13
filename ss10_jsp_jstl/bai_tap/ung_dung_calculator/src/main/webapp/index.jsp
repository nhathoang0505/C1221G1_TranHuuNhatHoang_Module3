<%--
  Created by IntelliJ IDEA.
  User: Hoang Tran
  Date: 4/13/2022
  Time: 11:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>
<h1>Simple Calculator</h1>
<form action="/calculate" method="get">
    <fieldset>
        <legend>Calculator</legend>
        First Operand: <input type="text" name="operand1">
        <br>
        Operator <select name="dropdownOperator" id="">
        <option value="add">Addition</option>
        <option value="minus">Minus</option>
        <option value="mul">Multiple</option>
        <option value="div">Division</option>
    </select>
        <br>
        Second operand <input type="text" name="operand2">
      <br>
        <button type="submit">Calculate</button>
    </fieldset>

</form>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
</body>
</html>
