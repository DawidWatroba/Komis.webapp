<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>Sprawdź informacje</title>
    <style>
        body {text-align: center;
            background-color: powderblue;
            font-size: x-large
        }
    </style>
</head>
<body>

<table>
    <tr>
        <td>Marka</td>
        <td><%= request.getParameter("make")%></td>
    </tr>
    <tr>
        <td>Typ</td>
        <td><%= request.getParameter("type")%></td>
    </tr>
    <tr>
        <td>Rok produkcji</td>
        <td><%= request.getParameter("production_year")%></td>
    </tr>
    <tr>
        <td>Przebieg</td>
        <td><%= request.getParameter("milage")%></td>
    </tr>
    <tr>
        <td>Pojemność</td>
        <td><%= request.getParameter("capacity")%></td>
    </tr>
</table>

<form action="add_car">
    <input type="hidden" name="make" value='<%= request.getParameter("make")%>'>
    <input type="hidden" name="type" value='<%= request.getParameter("type")%>'>
    <input type="hidden" name="year" value='<%= request.getParameter("production_year")%>'>
    <input type="hidden" name="distance" value='<%= request.getParameter("milage")%>'>
    <input type="hidden" name="capacity" value='<%= request.getParameter("capacity")%>'>
    <input style="font-size: xx-large" type="submit" value="Zapisz samochód">
</form>

<footer><%@ include file="companyAdrress.html" %></footer>
</body>
</html>
