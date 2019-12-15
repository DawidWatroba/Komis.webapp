<%@ page import="java.util.List" %>
<%@ page import="pl.dawid.web.client.Client" %><%--
  Created by IntelliJ IDEA.
  User: student
  Date: 15.12.2019
  Time: 09:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Rejestracja użytkownika</title>
</head>
<body>

<% Object oClients = request.getAttribute("clients"); %>
<% List clients = (List) oClients; %>

<form action="delete_client">
    <select name = "client">
        <% for (Object o : clients) { %>
        <% Client c = (Client) o; %>
        <option><%= c.getName() %> <%= c.getSurname() %></option>
        <%  } %>
    </select>
    <input type="submit" value="Usuń klienta">
</form>
</body>
</html>