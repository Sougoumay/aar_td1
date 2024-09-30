<%--
Cette JSP accueillera un form avec les deux champs login et password
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>LOGIN</title>
</head>
<body>

    <c:if test="${not empty message}">
        <div style="color: red">${message}</div>
    </c:if>

    <form method="post">
        <div>
            <label>
                Login :
                <input type="text" name="login">
            </label>
        </div>
        <div>
            <label>
                Password :
                <input type="text" name="password">
            </label>
        </div>
        <button type="submit">Envoyer</button>
    </form>
</body>
</html>
