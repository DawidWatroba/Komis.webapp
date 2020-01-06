<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Sprawdź informacje</title>
    <link rel="stylesheet" href="Style.css">
</head>
<body>
<jsp:useBean id="auto" class="pl.dawid.web.CarBean" scope="session"/>
<%--<jsp:setProperty name="auto" property="make"/>--%>
<%--<jsp:setProperty name="auto" property="type"/>--%>
<%--<jsp:setProperty name="auto" property="year" param="production_year"/>--%>
<%--<jsp:setProperty name="auto" property="distance" param="milage"/>--%>
<%--<jsp:setProperty name="auto" property="capacity" />--%>

<jsp:setProperty name="auto" property="*"/>

<table style="">
    <tr>
        <td>Marka</td>
        <td><c:out value="${auto.make}"/></td>
    </tr>
    <tr>
        <td>Typ</td>
        <td><c:out value="${auto.type}"/></td>
    </tr>
    <tr>
        <td>Rok produkcji</td>
        <td><c:out value="${auto.year}"/></td>
    </tr>
    <tr>
        <td>Przebieg</td>
        <td><c:out value="${auto.distance}"/></td>
    </tr>
    <tr>
        <td>Pojemność</td>
        <td><c:out value="${auto.capacity}"/></td>
    </tr>
</table>
<br><br>

<form action="carInfoForm.jsp">
    <input style="font-size: x-large" type="submit" value="Edytuj samochód">
</form>

<form action="add_car">
    <input style="font-size: xx-large" type="submit" value="Zapisz samochód">
</form>


<footer>
    <%@ include file="companyAdrress.html" %>
</footer>
</body>
</html>
