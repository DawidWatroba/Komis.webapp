<%@ page import="pl.dawid.web.CarBean" %><%--
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


<jsp:useBean id="car" class="pl.dawid.web.CarBean" scope="session">
    <% car.setMake("");%>
    <% car.setType(""); %>
    <% car.setYear(2019); %>
    <% car.setDistance("0");%>
    <% car.setCapacity("1");%>
</jsp:useBean>

<%! private String[] makes = {"Alfa Romeo","Fiat", "Audi", "BMW", "Mercedes", "Renault", "Volvo"}; %>

<form action="checkInfoForm.jsp" method="post">

    Marka: <select name="make">
    <% CarBean car1 = (CarBean) session.getAttribute("car"); %>
    <% for (String s:makes) { %>
    <% if (car1.getMake().equals(s)) { %>
    <option selected="selected"><%=s%></option>
    <% } else { %>
    <option><%= s %></option>
    <% } %>
    <% } %>
</select><br>

    Model: <input type="text" name="type" value="<jsp:getProperty name="car" property="type"/>">
    <br>

    Rok Produkcji:
    <select name="year">
        <%for (int i = 2019; i >= 1900; i--) { %>
        <% if (car1.getYear() == i) { %>
        <option selected="selected"><%=i%></option>
        <% } else { %>
        <option><%=i%></option>
        <% } %>
        <% } %>
    </select><br>
    Przebieg:<select name="distance">
    <% for (int i = 0; i < 500000; i += 20000) { %>
    <% if (Integer.parseInt(car1.getDistance())==i) { %>
    <option selected="selected"><%=i%></option>
    <% } else { %>
    <option><%=i%></option>
    <% } %>
    <% } %>
</select><br>
    Pojemność:
    <select name="capacity">
        <% for (int i = 0; i < 9; i++) { %>
        <% if (Integer.parseInt(car1.getCapacity())==i) { %>
        <option selected="selected"><%=i%></option>
        <% } else { %>
        <option><%= i %></option>
        <% } %>
        <% } %>
    </select> osób<br>
    <br><br>
    <input style="font-size: xx-large" type="submit" value="Dodaj auto">
</form>

<footer>
    <%@ include file="companyAdrress.html" %>
</footer>
</body>
</html>