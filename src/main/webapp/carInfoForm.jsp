<%@ page import="pl.dawid.web.CarBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
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

<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate var="currentYear" value="${now}" pattern="yyyy" />

<jsp:useBean id="auto" class="pl.dawid.web.CarBean" scope="session"/>

<%-- <%! private String[] makes =
                    {"Alfa Romeo","Fiat", "Audi", "BMW", "Mercedes", "Renault", "Volvo"}; %> --%>
<c:set var="makes" value="Alfa Romeo,Audi,BMW,Citroen,Ford,Fiat,Honda,Mercedes,Volkswagen,Volvo"/>

<form action="checkInfoForm.jsp" method="post">
    <% CarBean car1 = (CarBean) session.getAttribute("auto"); %>

    Marka:
    <select name="make">
        <c:forEach var="m" items="${makes}">
            <c:choose>
                <c:when test="${m eq auto.make}">
                    <option selected="selected"> <c:out value="${m}"/> </option>
                </c:when>
                <c:otherwise>
                    <option> <c:out value="${m}"/> </option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
</select><br>

    Model:   <input type="text" name="type" value="<c:out value='${auto.type}'/>"/> <br>

    Rok Produkcji:
    <select name="year">
        <c:forEach var="i" begin="0" end="49">
            <option
                    <c:if test="${currentYear - i == auto.year}">
                        selected="selected"
                    </c:if>
            >
                <c:out value="${currentYear - i}"/></option>
        </c:forEach>

    </select><br>
    Przebieg:<select name="distance">
    <c:forEach var="i" begin="0" end="500000" step="10000">
        <option <c:if test="${i == auto.distance}">selected="selected"</c:if>>
            <c:out value="${i}"/>
        </option>
    </c:forEach>
</select><br>
    Pojemność:
    <select name="capacity">
        <c:forEach var="i" begin="1" end="7">
            <option
                    <c:if test="${i == auto.capacity}">
                        selected="selected"
                    </c:if>
            >
                <c:out value="${i}"/></option>
        </c:forEach>
    </select> osób<br>
    <br><br>
    <input style="font-size: xx-large" type="submit" value="Dodaj auto">
</form>

<footer>
    <br><br><br><br><br><br><br><br><br><br>
    <%@ include file="companyAdrress.html" %>
</footer>
</body>
</html>