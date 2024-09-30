
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>METEO</title>
</head>
<body>

<!-- implanter ici le nombre de fois où chaque option de météo a été validée -->

<form method="post">
    <select name="meteo">
        <c:forEach items="${options}" var="opt">
            <c:choose>
                <c:when test="${opt == choice}"><option value="${opt}" selected>${opt}</option></c:when>
                <c:otherwise><option value="${opt}">${opt}</option></c:otherwise>
            </c:choose>
        </c:forEach>
    </select>
    <button type="submit">Valider</button>
</form>

<br>



<div> Le nombre de selection de chaque temps</div>
    <ul>
        <c:forEach var="opt" items="${counter}">
            <li>${opt.key} : ${opt.value}</li>
        </c:forEach>
    </ul>
</body>
</html>
