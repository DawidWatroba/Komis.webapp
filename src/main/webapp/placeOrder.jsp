<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Złóż zamówienie</title>
    <link rel="stylesheet" href="Style.css"/>
</head>
<body>
<jsp:useBean id="order" class="pl.dawid.web.OrderBean" scope="session"/>
<jsp:useBean id="klient" class="pl.dawid.web.ClientBean" scope="session"/>
<jsp:setProperty name="klient" property="*"/>
<jsp:setProperty name="order" property="*"/>
<br>
Zamówienie na klienta:
<c:out value="${klient.name}"/> <c:out value="${klient.surname}"/>
<br>
<form action="placeOrders" method="post">
    <input name="clientId" type="hidden" value="<c:out value='${klient.id}'/>"/>
    <input name="id" hidden value="0"/>
    <table>
        <tr>
            <td>Część: </td>
            <td>
                <input type="text" name="part" value="<c:out value='${order.part}'/> "/>
            </td>
        </tr>
        <tr>
            <td>Charakterystyka: </td>
            <td>
                <input type="text" name="profile" value="<c:out value='${order.profile}'/> "/>
            </td>
        </tr>
        <tr>
            <td>Ilość</td>
            <td>
                <input type="number" name="count" min="1" max="999" value="<c:out value='${order.count}'/> ">
            </td>
        </tr>
    </table>
    <br>
    <input style="font-size: x-large" type="submit" value="Złóż zamówienie">
</form>
</body>
</html>
