<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Zamówienia</title>
    <link rel="stylesheet" href="Style.css"/>
    <style>
        tr:hover {
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>
<br>
<sql:setDataSource dataSource="jdbc:komis" var="db"/>
<jsp:useBean id="order" class="pl.dawid.web.OrderBean" scope="session"/>
<sql:query var="orders" dataSource="${db}">
    SELECT * FROM zamowienie
</sql:query>
<table>
    <tr>
        <th>Id zlecenia</th>
        <th>Id Klienta</th>
        <th>Część</th>
        <th>Charakterystyka części</th>
        <th>Ilość</th>
        <th>Akcje</th>
    </tr>
    <c:forEach var="item" items="${orders.rows}">
        <tr>
            <td><c:out value="${item.id}"/></td>
            <td><c:out value="${item.klient_id}"/></td>
            <td><c:out value="${item.czesc}"/></td>
            <td><c:out value="${item.charakt_czesci}"/></td>
            <td><c:out value="${item.ilosc}"/></td>
            <td>
                <form action="editOrder.jsp">
                    <input type="hidden" name= "id" value="<c:out value='${item.id}'/>"/>
                    <input type="hidden" name= "part" value="<c:out value='${item.czesc}'/>"/>
                    <input type="hidden" name= "profile" value="<c:out value='${item.charakt_czesci}'/>"/>
                    <input type="hidden" name= "count" value="<c:out value='${item.ilosc}'/>"/>
                    <input type="hidden" name= "clientId" value="<c:out value='${item.klient_id}'/>"/>
                    <input type="submit" value="Edytuj">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<br><br>
<a href="read_users">Dodaj następne zlecenie</a>
<br><br>
<a href="start_page.jsp">Strona startowa</a>
</body>
</html>
