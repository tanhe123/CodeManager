<%@ page import="com.xiayule.utils.TimeUtil" %>
<%@ page import="com.xiayule.domain.Code" %>
<%@ page import="java.util.Calendar" %>
<%--
  Created by IntelliJ IDEA.
  User: tan
  Date: 14-6-22
  Time: 下午8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<s:form action="search" method="post">
    <s:textfield name="owner" key="search"/>
    <s:submit value="search"/>
</s:form>

<!--存在结果，菜显示表格 -->
<c:if test="${!empty codes}">
<table border="1">
    <!-- 标题 -->
    <tr>
        <th>title</th>
        <th>owner</th>
      <!--  <th>date</th> -->
        <th>type</th>
    </tr>

<c:forEach var="code" items="${codes}">

    <tr>
        <td><a href="/display.action?id=${code.id}">${code.title}</a></td>

        <td>${code.owner}</td>
        <td>${code.type}</td>
 <!--       <td>${code.date}</td> -->
        <td><a href="/delete.action?id=${code.id}">删除</a></td>
    </tr>
</c:forEach>
</table>

</c:if>

</body>
</html>
