
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Essai</title>
</head>
<body>
<p>Il est temps de deviner...</p>
Quel caractère proposez-vous ?
<form method="post">
    <input type="text" name="lecaractere">
    <button type="submit">Envoyer</button> <!-- TODO compléter le bouton -->
</form>

Pour l'instant vous avez trouvé : ${devine}<!-- TODO le mot en partie découvert (ou pas)-->
<div style="color: red">${msg}</div>
<div>Il vous reste <strong style="color: red">${nbEssai} essai</strong> </div>
</body>
</html>