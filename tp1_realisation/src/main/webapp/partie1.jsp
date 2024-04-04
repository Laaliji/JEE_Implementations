<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>
    Formulaire
</h1>
<%
    String erreur = (String)request.getAttribute("erreur");
    if(erreur != null){
%>
<p style="color: red;font-weight: bold">${erreur}</p>
<% } %>
<form action="login" method="post">
    <label>
        nom :
        <input type="text" name="nom" />
    </label>
    <label>
        password :
        <input type="password" name="password" />
    </label>
    <input type="submit">
</form>
</body>
</html>