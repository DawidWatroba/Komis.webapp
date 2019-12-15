<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 15.12.2019
  Time: 09:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Rejestracja użytkownika</title>
</head>
<body>
<form action="add_user" method="post" >
    Imie      : <input type="text" name="name"><br>
    Nazwisko: <input type="text" name="surname"><br>
    Wiek: <select name="age">
    <% for(int i =1; i<=100; i++){ %>
    <option value="<%= i %>"><%= i %></option>
    <% } %>

</select><br>
    Region  : <select name = "region">
    <option>Polska</option>
    <option>Niemcy</option>
</select><br>
    Płeć   :<input type="radio" name="sex" value="MALE">mezczyzna<br>
    <input type="radio" name="sex" value="FEMALE">kobieta<br>
    <input type="submit" value="Utwórz uzytkownika">
</form>
</body>
</html>