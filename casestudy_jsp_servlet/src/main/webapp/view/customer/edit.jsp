<%--
  Created by IntelliJ IDEA.
  User: Hoang Tran
  Date: 4/20/2022
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management Application</title>
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="customers?action=customers">List All Customers</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Customer
                </h2>
            </caption>
            <c:if test="${customer != null}">
                <input type="hidden" name="id" value="<c:out value='${customer.customerId}' />"/>
            </c:if>
            <tr>
                <th>Customer Type:</th>
                <td><select name="type" id="type">
                    <c:forEach var="customerType" items="${customerTypeList}">
                        <c:if test="${customerType.customerTypeId==customer.customerTypeId}">
                            <option value="${customerType.customerTypeId}"
                                    selected>${customerType.customerTypeName}</option>
                        </c:if>
                        <c:if test="${customerType.customerTypeId!=customer.customerTypeId}">
                            <option value="${customerType.customerTypeId}"
                            >${customerType.customerTypeName}</option>
                        </c:if>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <th>Customer Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${customer.customerName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Birthday:</th>
                <td>
                    <input type="date" name="birthday" size="15"
                           value="<c:out value='${customer.customerBirthday}' />"
                    />
                </td>
            </tr>

            <tr>
                <th>Customer Gender:</th>
                <td>
                    <c:if test="${customer.customerGender ==1}">
                        <c:set var="isMale" value="selected"></c:set>
                    </c:if>
                    <c:if test="${customer.customerGender !=1}">
                        <c:set var="isFemale" value="selected"></c:set>
                    </c:if>
                    <select name="gender">
                        <option value="0" ${isFemale}>Female</option>
                        <option value="1" ${isMale}>Male</option>
                    </select>
                </td>
            </tr>

            <tr>
                <th>Customer IdCard:</th>
                <td>
                    <input type="text" name="idcard" size="15"
                           value="<c:out value='${customer.customerIdCard}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Phone:</th>
                <td>
                    <input type="text" name="phone" size="15"
                           value="<c:out value='${customer.customerPhone}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Email:</th>
                <td>
                    <input type="text" name="email" size="15"
                           value="<c:out value='${customer.customerEmail}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Address:</th>
                <td>
                    <input type="text" name="address" size="15"
                           value="<c:out value='${customer.customerAddress}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
