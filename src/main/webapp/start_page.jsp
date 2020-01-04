<%@ page import="pl.dawid.web.listeners.SessionCounter" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Komis u Dawida</title>
    <style>
        body {text-align: center;
            background-color: powderblue;
            font-size: x-large
        }
        h1 {font-size: xx-large; color: red}

        a{color: black;font-size: large;}
        a:link {text-decoration: none}
        a:visited {text-decoration: none}
        a:active {text-decoration: none}
        a:hover {text-decoration: underline}
        h5 {}
    </style>
</head>
<body>
<br><br>
<h1>
    <% if(request.getParameter("name")!=null){%>
    <%= request.getParameter("name")%> witaj w Komisie!
    <%}else {%>
        Witaj w Komisie!
    <%}%>
</h1>
<br><br>
<a href="makeForm.html">Link do wyboru marki</a>
<br><br>
<a href="userForm.jsp">Rejestracja klienta</a>
<br><br>
<a href="read_users">Pokaż klientów</a>
<br><br>
<a href="delete">Usuń klienta</a>
<br><br>
<a href="carInfoForm.jsp">Dodaj samochód do bazy</a>
<br><br>
<a href="car_list.jsp">Pokaż listę samochodów</a>
<h5>
    <br><br>
    Liczba aktywnych użytkowników : <%=SessionCounter.getCounter()%>
    <br><br>
</h5>
</body>
</html>
