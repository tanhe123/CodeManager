<%--
  Created by IntelliJ IDEA.
  User: tan
  Date: 14-6-19
  Time: 下午11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Hello SyntaxHighlighter</title>
    <script type="text/javascript" src="scripts/shCore.js"></script>
    <script type="text/javascript" src="scripts/shBrushJScript.js"></script>
    <script type="text/javascript" src="scripts/shBrushJava.js"></script>
    <link type="text/css" rel="stylesheet" href="styles/shCoreDefault.css"/>
    <script type="text/javascript">SyntaxHighlighter.all();</script>
</head>

<body>
<h1>Hello SyntaxHighlighter</h1>

<pre class="brush: <%=request.getParameter("type")%>;">
<%=request.getParameter("source")%>
</pre>

</body>
</html>
