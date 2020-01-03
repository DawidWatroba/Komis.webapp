<%--
  Created by IntelliJ IDEA.
  User: ja
  Date: 03.01.2020
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Podaj imię</title>
    <style>
        body {text-align: center;
            background-color: powderblue;
        }
        form{font-size: x-large}
        input{font-size: x-large}
    </style>
</head>
<body>
<form action="start_page.jsp" method="post" >
    Podaj imię      : <input type="text" name="name">
    <br><br>
    <input type="submit" value="Wejdź do komisu">
</form>
</body>
</html>
