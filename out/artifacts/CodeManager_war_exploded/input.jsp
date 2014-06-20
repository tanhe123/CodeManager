<%--
  Created by IntelliJ IDEA.
  User: tan
  Date: 14-6-19
  Time: 下午11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form action="/CoreServlet" method="post">
<table>
    <tr>
        <th><label for="id_poster">Poster:</label></th>
        <td><input id="id_poster" name="poster" maxlength="30" type="text"/></td>
    </tr>

    <tr>
        <th><label for="id_syntax">Syntax:</label></th>
        <td> <select id="id_syntax" name="type">
            <option value="js">js</option>
            <option value="java">java</option>
        </select></td>
    </tr>

    <tr>
        <th><label for="id_content">Content:</label></th>
        <td><textarea id="id_content" rows="20" cols="80" name="source"></textarea></td>
    </tr>

    <tr>
        <td></td>
        <td><input type="submit" value="提交"/></td>
    </tr>
</table>

</form>

</body>
</html>
