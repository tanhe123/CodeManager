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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<jsp:include page="nav.html"/>

<form action="search.action" method="post">
    <label for="owner">提交人:</label>
    <input id="owner" type="text" name="owner" value="${owner}"/>
    <input type="submit" class="btn btn-primary" value="search"/>
</form>

<!--存在结果，菜显示表格 -->
<c:if test="${!empty codes}">
<table class="table table-bordered">
    <caption>搜索结果:</caption>

    <!-- 标题 -->
    <tr>
        <th>标题</th>
        <th>提交者</th>
        <th>语言</th>
        <th>时间</th>
        <th>操作</th>
    </tr>

<c:forEach var="code" items="${codes}">

    <tr>
        <td><a href="/display.action?id=${code.id}">${code.title}</a></td>

        <td><a href="/search.action?owner=${code.owner}">${code.owner}</a></td>
        <td>${code.type}</td>
        <td><fmt:formatDate value="${code.date.getTime()}" pattern="yyyy年MM月dd日HH点mm分ss秒"/></td>
        <td><a href="/delete.action?id=${code.id}">删除</a></td>
    </tr>
</c:forEach>
</table>

</c:if>

</body>
</html>
