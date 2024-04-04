<%--
  Created by IntelliJ IDEA.
  User: J.P.M
  Date: 14/02/2024
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="ajouter.jsp" method="post">
    <label for="isbn">ISBN:</label> <input type="text" id="isbn" name="isbn"><br>
    <label for="titre">Titre:</label><input type="text" id="titre" name="titre"><br>
    <label for="auteur">Auteur:</label><input type="text" id="auteur" name="auteur">
    <br><label for="nbrPage">Nombre de Pages:</label>
    <input type="number" id="nbrPage" name="nbrPage"><br>
    <input type="submit" value="Ajouter">
</form>
<br>
</body>
</html>
