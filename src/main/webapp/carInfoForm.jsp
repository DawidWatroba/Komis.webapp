<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 15.12.2019
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Dodaj samochód</title>
    <style>
        body {text-align: center;
            background-color: powderblue;
            font-size: x-large
        }
    </style>
</head>
<body>
<%! private String[] makes = {"Fiat", "Audi", "BMW", "Mercedes", "Renault", "Volvo"}; %>

<form action="checkInfoForm.jsp" method="post">

    Marka: <select name="make">
    <% for (String s:makes) { %>
    <option><%= s %>
    </option>
    <% } %>
</select><br>

    Model: <input type="text" name="type"><br>

    Rok Produkcji:
    <select name="production_year">
        <% for (int i = 2019; i >= 1900; i--) { %>
        <option><%=i%>
        </option>
        <% } %>
    </select><br>
    Przebieg:<select name="milage">
    <% for (int i = 0; i < 500000; i += 20000) { %>
    <option><%=i%>
    </option>
    <% } %>
</select><br>
    Pojemność:
    <select name="capacity">
        <% for (int i = 0; i < 9; i++) { %>
        <option><%= i %>
        </option>
        <% } %>
    </select> osób<br>
    <input style="font-size: xx-large" type="submit" value="Dodaj auto">
</form>

<footer>
    <%@ include file="companyAdrress.html" %>
</footer>
</body>
</html>