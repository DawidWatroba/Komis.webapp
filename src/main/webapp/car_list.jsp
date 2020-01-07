<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
    <title>Samochody</title>
    <link rel="stylesheet" href="Style.css"/>
    <style>
        tr:hover {background-color: #f5f5f5;}
    </style>
</head>
<body>
<sql:setDataSource dataSource="jdbc:komis" var="db"/>

    <sql:query var="tb" dataSource="${db}" >
        SELECT * FROM pojazd
    </sql:query>
<table>
    <tr>
        <th>Id</th>
        <th>Marka</th>
        <th>Typ</th>
        <th>Rok produkcji</th>
        <th>Przebieg</th>
        <th>Ilość osób</th>
        <th>Akcje</th>
    </tr>
<c:forEach var="item" items="${tb.rows}">
    <tr>
    <td><c:out value="${item.id}"/></td>
    <td><c:out value="${item.marka}"/></td>
    <td><c:out value="${item.typ}"/></td>
    <td><c:out value="${item.rok}"/></td>
    <td> <c:out value="${item.przebieg}"/></td>
    <td><c:out value="${item.pojemnosc}"/></td>
    <td>
        <form action="findCarById">
            <input type="hidden" name= "car_id" value="<c:out value='${item.id}'/>">
            <input type="submit" value="Edytuj">
        </form>
    </td>
    </tr>
</c:forEach>

</body>
</html>
