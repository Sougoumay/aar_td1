<%--
  Created by IntelliJ IDEA.
  User: elidj
  Date: 17/09/2024
  Time: 09:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<div>
    <c:choose>
        <c:when test="${random}">
            ${message}
        </c:when>
        <c:otherwise>
            <ul>
                <c:forEach items="${messages}" var="msg">
                    <li>${msg}</li>
                </c:forEach>
            </ul>
        </c:otherwise>
    </c:choose>
</div>
<div>
    <form method="post">
        <div>
            <input type="submit" name="todo" value="ajout">
            <input type="submit" name="todo" value="random">
            <input type="submit" name="todo" value="all">
        </div>
    </form>
</div>
</body>
</html>
