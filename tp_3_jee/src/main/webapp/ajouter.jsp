<%--
  Created by IntelliJ IDEA.
  User: J.P.M
  Date: 14/02/2024
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="monLivre" class="com.isir.tp_3_jee.bean.Livre" scope="request">
    <jsp:setProperty name="monLivre" property="*"/>
</jsp:useBean>
ISBN :
<jsp:getProperty name="monLivre" property="isbn"/>
<br/>
titre :
<jsp:getProperty name="monLivre" property="titre"/>
<br/>
auteur :
<jsp:getProperty name="monLivre" property="auteur"/>
<br/>
nombre de pages :
<jsp:getProperty name="monLivre" property="nbrPage"/>
<br/>
<jsp:forward page="ServletAjout"/>
</body>
</html>
