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
<jsp:useBean id="auto" class="pl.dawid.web.CarBean" scope="session"/>
<%--<jsp:setProperty name="auto" property="make"/>--%>
<%--<jsp:setProperty name="auto" property="type"/>--%>
<%--<jsp:setProperty name="auto" property="year" param="production_year"/>--%>
<%--<jsp:setProperty name="auto" property="distance" param="milage"/>--%>
<%--<jsp:setProperty name="auto" property="capacity" />--%>

<jsp:setProperty name="auto" property="*"/>

<table>
    <tr>
        <td>Marka</td>
        <td><jsp:getProperty name="auto" property="make"/></td>
    </tr>
    <tr>
        <td>Typ</td>
        <td><jsp:getProperty name="auto" property="type"/></td>
    </tr>
    <tr>
        <td>Rok produkcji</td>
        <td><jsp:getProperty name="auto" property="year"/></td>
    </tr>
    <tr>
        <td>Przebieg</td>
        <td><jsp:getProperty name="auto" property="distance"/></td>
    </tr>
    <tr>
        <td>Pojemność</td>
        <td><jsp:getProperty name="auto" property="capacity"/></td>
    </tr>
</table>

<form action="carInfoForm.jsp">
    <input style="font-size: x-large" type="submit" value="Edytuj samochód">
</form>

<form action="add_car">
    <input style="font-size: xx-large" type="submit" value="Zapisz samochód">
</form>


<footer><%@ include file="companyAdrress.html" %></footer>
</body>
</html>
