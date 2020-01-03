<%@ page import="java.util.List" %>
<%@ page import="pl.dawid.web.Client" %><%--
  Created by IntelliJ IDEA.
  User: student
  Date: 15.12.2019
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>

<html>
<head>
    <title>Spis klientów</title>
    <style>
        body {
            background-color: powderblue;
            font-size: x-large
        }
        table{
            font-size: large;
            text-align: center;
            border: 1px solid black;
        }
        th,td{
            padding: 5px 10px;
            border-bottom: 1px solid black;
            font-size: large;
            text-align: center;}
        form{
            padding: 1px;
            font-size: medium;
            text-align: center;}
        tr:hover {background-color: #f5f5f5;}
    </style>
</head>
<body>
<%@include file="header.jsp"%>
<table>
    <tr>
        <th>Id</th>
        <th>Imie</th>
        <th>Nazwisko</th>
        <th>Wiek</th>
        <th>Region</th>
        <th>Plec</th>
        <th>Akcja</th>
    </tr>

    <% Object oClients = request.getAttribute("clients"); %>
    <% List clients = (List) oClients; %>
    <% for (Object o : clients) { %>
        <% Client c = (Client)o; %>
        <tr>
            <td><%= c.getId() %></td>
            <td><%= c.getName() %></td>
            <td><%= c.getSurname() %></td>
            <td><%= c.getAge() %></td>
            <td><%= c.getRegion()%></td>
            <td><%= c.getSex()%></td>
            <td>
                <form action="delete_user_by_id">
                    <!--.
                    <input type="text" disabled="true" name="id" value="<%= c.getId() %>">
                    -->
                    <input type="hidden" name="id" value="<%= c.getId() %>">
                    <input type="submit" value="Usun">
                </form>
                <form action="edit_user">
                    <input type="hidden" name="id" value="<%=c.getId()%>">
                    <input type="hidden" name="name" value="<%=c.getName()%>">
                    <input type="hidden" name="surname" value="<%=c.getSurname()%>">
                    <input type="hidden" name="age" value="<%=c.getAge()%>">
                    <input type="hidden" name="region" value="<%=c.getRegion()%>">
                    <input type="hidden" name="sex" value="<%=c.getSex()%>">
                    <input type="submit" value="Edytuj">
                </form>
            </td>
        </tr>
    <% } %>
</table>
<br><br>
<a href="userForm.jsp">Dodaj nastepnego klienta</a><br><br>
<a href="delete">Usun klienta</a><br><br>
<a href="start_page.jsp">Strona startowa</a>
</body>
</html>