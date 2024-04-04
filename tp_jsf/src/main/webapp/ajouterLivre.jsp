<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un Livre</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        form {
            max-width: 400px;
            margin: 50px auto;
            background: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #333;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<form action="ServletAjout" method="post">
    <label for="isbn">ISBN:</label>
    <input type="text" id="isbn" name="isbn" required><br>

    <label for="titre">Titre:</label>
    <input type="text" id="titre" name="titre" required><br>

    <label for="auteur">Auteur:</label>
    <input type="text" id="auteur" name="auteur" required><br>

    <label for="nbrPage">Nombre de Pages:</label>
    <input type="number" id="nbrPage" name="nbrPage" required><br>

    <input type="submit" value="Ajouter">
</form>
</body>
</html>
