<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 14.12.2019
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Silnia</title>
    <style>
        table, tr, th, td {border: 1px solid ;border-collapse: collapse; text-align: center}
    </style>
</head>
<body>
<% int n = 10; %>
<% Object p = request.getParameter("n"); %>
<% if(p!=null)n = Integer.parseInt(p.toString()); %>
<%!
    private int silnia(int n){
        if(n<=0)return 1;
        return n*silnia(n-1);
    }
%>
<table>
    <tr>
        <th>n</th>
        <th>n!</th>
    </tr>
    <% for(int i=1; i<=n; i++){ %>
    <tr>
        <td><%= i %></td>
        <td><%= silnia(i) %></td>
        <% } %>
    </tr>
</table>

</body>
</html>
