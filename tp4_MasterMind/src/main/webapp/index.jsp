<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<c:set var="bean" value="${bean}" scope="session" />
<c:catch var="exception"><p style="display: none">${end}</p></c:catch>
<c:if test="${exception==null}"><c:set var="jouer" value="true" /></c:if>
<c:if test="${end==true}"><c:set var="jouer" value="false" /></c:if>
<c:if test="${end==false}"><c:set var="jouer" value="true" /></c:if>
<h1 style="text-align: center">le jeu MasterMind</h1>
<form action="JeuServlet" method="post" style="display: flex; flex-direction: column;
align-items: center;justify-content: center;gap: 10px;">
    <input type="number" name="nbr" style="width: 200px;padding: 10px;" placeholder="enter un nombre"/>
    <div>
        <input type="submit" value="Jouer" name="status"/>
        <input type="submit" value="Reinitialiser le jeu" <c:if test="${jouer == true}"><c:out value="disabled='disabled'"/></c:if>  name="status"/>
        <input type="hidden" value="${game}" name="numJeu"/>
    </div>
</form>
<c:forEach var="msg" items="${bean.lstMessages}">
    <c:out value="${msg}" /> <br>
</c:forEach>
<c:if test="${end == true}">le je est terminer</c:if>
<c:if test="${nvgame == true}">un nouveau jeu a ete lancer</c:if>
</body>
</html>