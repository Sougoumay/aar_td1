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
    <form method="post">
        <div>
            <label>Saisissez un message :
                <input type="text" name="message"/>
            </label>
        </div>
        <div>
            <input type="submit" name="todo" value="ajout">
            <input type="submit" name="todo" value="affichage">
        </div>
    </form>
</div>
</body>
</html>
