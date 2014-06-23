<%--
  Created by IntelliJ IDEA.
  User: tan
  Date: 14-6-22
  Time: 下午8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="a" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<a:form action="search" method="post">
    <a:textfield name="owner" key="search"/>
    <a:submit value="search"/>
</a:form>

<c:forEach var="code" items="${codes}">
    ${code.title} <br/>
    ${code.owner} <br/>
    ${code.type} <br/>
    ${code.code} <br/>
</c:forEach>

</body>
</html>
