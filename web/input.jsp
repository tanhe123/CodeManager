<%--
  Created by IntelliJ IDEA.
  User: tan
  Date: 14-6-19
  Time: 下午11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<s:form action="commit" method="post">
    <table>
        <tr>
            <td><s:textfield name="title" key="title"/> </td>
        </tr>
        <tr>
            <td><s:textfield name="owner" key="owner"/></td>
        </tr>

        <tr>

            <td>
                <s:select label="language"
                          list="#{'java':'java','js':'js','cpp':'c++','sh':'bash'}"
                          name="type"
                        listkey="key" listvalue="value"/>
            </td>
        </tr>

        <tr>
            <td><s:textarea rows="20" cols="80" name="source"></s:textarea></td>
        </tr>

        <tr>
            <td><s:submit value="提交"/></td>
        </tr>
    </table>

</s:form>

<%@ include file="bottom.jsp"%>
</body>
</html>