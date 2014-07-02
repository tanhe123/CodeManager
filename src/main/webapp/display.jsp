<%--
  Created by IntelliJ IDEA.
  User: tan
  Date: 14-6-19
  Time: 下午11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>Hello SyntaxHighlighter</title>
    <script type="text/javascript" src="scripts/shCore.js"></script>

    <script type="text/javascript" src="scripts/shBrushBash.js"></script>
    <script type="text/javascript" src="scripts/shBrushJScript.js"></script>
    <script type="text/javascript" src="scripts/shBrushJava.js"></script>
    <script type="text/javascript" src="scripts/shBrushCpp.js"></script>

    <link type="text/css" rel="stylesheet" href="styles/shCoreDefault.css"/>
    <script type="text/javascript">SyntaxHighlighter.all();</script>
</head>

<body>
<table>
    <tr><td><h1>${code.title}</h1></td></tr>
    <tr><td><h2>by ${code.owner}</h2></td></tr>

    <tr>
        <td><pre class="brush: ${code.type}};">${code.source}</pre></td>
    </tr>

    <tr>
        <td>
            <img alt="显示图片"
                 src="<s:url action='qrcode'><s:param name='id' value='#request.code.id'></s:param></s:url>"/></td>
    </tr>
</table>


</body>
</html>
