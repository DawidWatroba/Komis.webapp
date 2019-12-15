<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 15.12.2019
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sprawdz dane</title>
    <style>
        table, tr, th, td {border: 1px solid ;border-collapse: collapse; text-align: center}
        h2{color: red}
    </style>
</head>
<body>
<h2>Sprawdź poprawność danych</h2>
<h3>
    <form action="add_car" method="post" >
    <td>Marka:</td>
    <td><%=request.getParameter("make")%></td><br>
    <td>Typ:</td>
    <td><%=request.getParameter("type")%></td><br>
    <td>Rok produkcji:</td>
    <td><%=request.getParameter("age")%></td><br>
    <td>Przebieg:</td>
    <td><%=request.getParameter("distance")%></td><br>
    <td>Pojemność:</td>
    <td><%=request.getParameter("capacity")%></td><br>
</tr><br>
        <input typ="hidden" name=""make value="">
    <input type="submit" value="Dodaj auto">
    </form>
</h3>

<footer><%@ include file="companyAdrress.html" %></footer>
</body>
</html>
