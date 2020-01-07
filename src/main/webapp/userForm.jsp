<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Rejestracja użytkownika</title>
    <link rel="stylesheet" href="Style.css">
</head>
<body>
<c:set var="countries" value="Polska,Niemcy,Francja,Włochy,Anglia,Hiszpania,Szwecja,Norwegia,Rosja,USA"/>
<jsp:useBean id="klient" class="pl.dawid.web.ClientBean" scope="session"/>
<jsp:setProperty name="klient" property="*"/>

<form action="add_user" method="post">
    <table>
        <tr>
            <td>Imie :</td>
            <td>
                <input type="text" name="name" value="<c:out value='${klient.name}'/>"/>
            </td>
        </tr>
        <tr>
            <td>Nazwisko:</td>
            <td>
                <input type="text" name="surname" value="<c:out value='${klient.surname}'/>"/>
            </td>
        </tr>
        <tr>
            <td>Wiek:</td>
            <td>
                <select name="age">
                    <c:forEach var="i" begin="18" end="99">
                        <c:choose>
                        <c:when test="${i eq klient.age}">
                            <option selected="selected"><c:out value="${i}"/></option>
                        </c:when>
                        <c:otherwise>
                        <option><c:out value="${i}"/></option>
                        </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Region :</td>
            <td><select name="region">
                <c:forEach var="country" items="${countries}">
                    <c:choose>
                        <c:when test="${country eq klient.region}">
                            <option selected="selected"><c:out value="${country}"/> </option>
                        </c:when>
                    <c:otherwise>
                    <option><c:out value="${country}"/></option>
                    </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
            </td>
        </tr>
        <tr>
            <td>Płeć :</td>
            <td>
                <c:choose>
                    <c:when test="${klient.sex eq 'MALE'}">
                    <input type="radio" name="sex" value="MALE" checked>mezczyzna
                    <input type="radio" name="sex" value="FEMALE">kobieta
                    </c:when>
                    <c:otherwise>
                        <input type="radio" name="sex" value="MALE" >mezczyzna
                        <input type="radio" name="sex" value="FEMALE" checked>kobieta
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
        <input type="hidden" name="id" value="<c:out value='${klient.id}'/>"/>
    </table>
    <br><br>
    <input style="font-size: x-large" type="submit" value="Utwórz użytkownika">
</form>
<br><br>
<a href="start_page.jsp">Wróć do strony startowej</a>
</body>
</html>