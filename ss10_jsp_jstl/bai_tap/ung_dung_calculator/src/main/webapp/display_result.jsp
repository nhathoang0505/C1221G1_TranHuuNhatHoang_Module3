<%--
  Created by IntelliJ IDEA.
  User: Hoang Tran
  Date: 4/13/2022
  Time: 11:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${exceptions == null}">
    Calculate: ${num1} ${operators} ${num2}
    <br>
    Result: <c:out value="${results}"/>
</c:if>

<c:if test="${exceptions != null}">
    <c:out value="${exceptions}"/>
</c:if>

</body>
</html>
