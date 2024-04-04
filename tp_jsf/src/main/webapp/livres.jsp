<%@ page import="com.isir.tp5_jpa.metier.Livre" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des Livres</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        table {
            max-width: 800px;
            margin: 50px auto;
            background: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        a {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 8px 12px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 4px;
        }

        a:hover {
            background-color: #45a049;
        }
    </style>
</head>
<%
    ArrayList<Livre> livres = (ArrayList<Livre>) request.getAttribute("livres");
%>
<body>
<div style="display: flex;align-items: center;justify-content: center;">
    <a href="ajouterLivre.jsp">Ajouter des livres</a>
</div>
<table>
    <tr>
        <th>ISBN</th>
        <th>TITRE</th>
        <th>AUTEUR</th>
        <th>NOMBRE DE PAGES</th>
        <th>Action</th>
    </tr>
    <% for (Livre l : livres) { %>
    <tr>
        <td><%= l.getIsbn() %>
        </td>
        <td><%= l.getTitre() %>
        </td>
        <td><%= l.getAuteur() %>
        </td>
        <td><%= l.getNbrPage() %>
        </td>
        <td>
            <a href="./ServletAjout?faire=supprimer&id=<%=l.getIsbn()%>">supprimer</a>
            <a href="./ServletAjout?faire=modifier&id=<%=l.getIsbn()%>">modifier</a>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>
