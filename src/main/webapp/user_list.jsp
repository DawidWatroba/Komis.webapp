<%@ page import="java.util.List" %>
<%@ page import="pl.dawid.web.ClientBean" %>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ page pageEncoding="UTF-8"%>

<html>
<head>
    <title>Spis klientów</title>
    <link rel="stylesheet" href="Style.css">
    <style>
        tr:hover {background-color: #f5f5f5;}
    </style>
</head>
<body>

śźćęą
<table>
    <tr>
        <th>Id</th>
        <th>Imie</th>
        <th>Nazwisko</th>
        <th>Wiek</th>
        <th>Region</th>
        <th>Plec</th>
        <th>Usuń</th>
        <th>Edytuj</th>
        <th>Złóż zamówienie</th>
    </tr>

    <% Object oClients = request.getAttribute("clients"); %>
    <% List clients = (List) oClients; %>
    <% for (Object o : clients) { %>
        <% ClientBean c = (ClientBean)o; %>
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
                    <input style="font-size: medium;padding: 2px 5px;" type="submit" value="Usun">
                </form>
            </td>
            <td>
                <form action="userForm.jsp">
                    <input type="hidden" name="id" value="<%=c.getId()%>">
                    <input type="hidden" name="name" value="<%=c.getName()%>">
                    <input type="hidden" name="surname" value="<%=c.getSurname()%>">
                    <input type="hidden" name="age" value="<%=c.getAge()%>">
                    <input type="hidden" name="region" value="<%=c.getRegion()%>">
                    <input type="hidden" name="sex" value="<%=c.getSex()%>">
                    <input style="font-size: medium;padding: 2px 5px;" type="submit" value="Edytuj">
                </form>
            </td>
            <td>
                <form action="placeOrder.jsp">
                    <input type="hidden" name="id" value="<%=c.getId()%>">
                    <input type="hidden" name="name" value="<%=c.getName()%>">
                    <input type="hidden" name="surname" value="<%=c.getSurname()%>">
                    <input type="hidden" name="age" value="<%=c.getAge()%>">
                    <input type="hidden" name="region" value="<%=c.getRegion()%>">
                    <input type="hidden" name="sex" value="<%=c.getSex()%>">
                    <input style="font-size: medium;padding: 2px 5px;" type="submit" value="Złóż zamówienie">
                </form>
            </td>
        </tr>
    <% } %>
</table>
<br><br>
<a href="read_users">Dodaj nastepnego klienta</a><br><br>
<a href="delete">Usun klienta</a><br><br>
<a href="start_page.jsp">Strona startowa</a>
</body>
</html>