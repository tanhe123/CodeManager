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
    <title>极速分享</title>
</head>
<body>

<jsp:include page="nav.html"/>

<form action="commit.action" method="post">
    <table>
        <tr>
            <td><label>标题:</label></td>
            <td><input type="text" size="20" name="title"></td>

          <%--  <td><s:textfield name="title" key="title"/></td> --%>
        </tr>
        <tr>
            <td><label>上传者:</label></td>
            <td><input type="text" size="20" name="owner"></td>
            <%--<td><s:textfield name="owner" key="owner"/></td>--%>
        </tr>

        <tr>
            <td><label>语言:</label></td>
            <td>
                <%--<s:select label="language"
                          list="#{'java':'java','js':'js','cpp':'c++','sh':'bash'}"
                          name="type"
                        listkey="key" listvalue="value"/>--%>
                <select name="type">
                    <option>java</option>
                    <option>js</option>
                    <option>cpp</option>
                    <option>sh</option>
                </select>
            </td>
        </tr>

        <tr>
            <td><label>代码:</label></td>
            <td><textarea name="source" rows="20" cols="80"></textarea></td>
            <%--<td><s:textarea rows="20" cols="80" name="source"></s:textarea></td>--%>
        </tr>

        <tr>
            <td></td>
            <td><input class="btn btn-primary" type="submit" value="提交"/></td>
        </tr>
    </table>

</form>

<jsp:include page="bottom.jsp"/>

</body>
</html>