<%--
  Created by IntelliJ IDEA.
  User: Hoang Tran
  Date: 4/22/2022
  Time: 8:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new employee</title>
    <style>
        .message {
            color: green;
        }
    </style>
</head>
<body>
<h1>Create new employee</h1>
<%--<p>--%>
<%--    <c:if test='${requestScope["message"] != null}'>--%>
<%--        <span class="message">${requestScope["message"]}</span>--%>
<%--    </c:if>--%>
<%--</p>--%>
<p>
    <a href="/">Back to Home</a>
</p>
<p>
    <a href="/employees">Back to Employee list</a>
</p>
<form method="post">
    <%--    fieldset: Tạo đường viền bao ở ngoài--%>
    <fieldset>
        <legend>Employee information</legend>
        <table>

            <tr>
                <td>Employee Name:</td>
                <td><input type="text" name="name"></td>
            </tr>

            <tr>
                <td>Employee Birthday:</td>
                <td><input type="date" name="birthday"></td>
            </tr>

            <tr>
                <td>Employee ID Card:</td>
                <td><input type="text" name="card"></td>
            </tr>

            <tr>
                <td>Employee Salary:</td>
                <td><input type="text" name="salary"></td>
            </tr>

            <tr>
                <td>Employee Phone:</td>
                <td><input type="text" name="phone"></td>
            </tr>
            <tr>
                <td>Employee Email:</td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td>Employee Address:</td>
                <td><input type="text" name="address"></td>
            </tr>

            <tr>
                <td>Employee Position:</td>
                <td><select name="position" id="position">
                    <c:forEach var="position" items="${positionsList}">
                        <option value="${position.positionId}">
                                ${position.positionName}
                        </option>
                    </c:forEach>
                </select></td>
            </tr>

            <tr>
                <td>Employee educationDegree:</td>
                <td><select name="education" id="education">
                    <c:forEach var="education" items="${educationDegreesList}">
                        <option value="${education.educationDegreeId}">
                                ${education.educationDegreeName}
                        </option>
                    </c:forEach>
                </select></td>
            </tr>

            <tr>
                <td>Employee Division:</td>
                <td><select name="division" id="division">
                    <c:forEach var="division" items="${divisionsList}">
                        <option value="${division.divisionId}">
                                ${division.divisionName}
                        </option>
                    </c:forEach>
                </select></td>
            </tr>


            <tr>
                <td></td>
                <td><input type="submit" value="Create employee"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
