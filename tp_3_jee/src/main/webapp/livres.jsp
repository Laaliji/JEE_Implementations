<%--
  Created by IntelliJ IDEA.
  User: J.P.M
  Date: 14/02/2024
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.isir.tp_3_jee.bean.Livre" %>
<%@ page import="java.util.ArrayList" %>
<%
    ArrayList<Livre> livres = (ArrayList<Livre>) request.getAttribute("mesLivres");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td>ISBN</td>
        <td>TITRE</td>
        <td>AUTEUR</td>
        <td>NOMBRE DE PAGES</td>
    </tr>
    <%for (Livre l : livres) { %>
    <tr>
        <td><%=l.getIsbn()%>
        </td>
        <td><%=l.getTitre()%>
        </td>
        <td><%=l.getAuteur()%>
        </td>
        <td><%=l.getNbrPage()%>
        </td>
    </tr>
    <%}%>
    <br>
    <a href="ajouterLivre.jsp">Ajouter des livrves</a>
</table>
</body>
</html>
