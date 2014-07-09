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

    <link id="css" type="text/css" rel="stylesheet" href="styles/shCoreDefault.css"/>

    <script type="text/javascript" src="http://raining.qiniudn.com/jquery.min.js"></script>

    <script>
        function change(type){    //更改样式
            var css=document.getElementById("css");
            if ("default"==type)
                css.setAttribute("href","styles/shCoreDefault.css");
            else if ("emacs"==type)
                css.setAttribute("href","styles/shCoreEmacs.css");
            else if ("django"==type)
                css.setAttribute("href","styles/shCoreDjango.css");
            else if ("eclipse"==type)
                css.setAttribute("href","styles/shCoreEclipse.css");
            else if ("fadetogrey"==type)
                css.setAttribute("href","styles/shCoreFadeToGrey.css");
            else if ("mdultra"==type)
                css.setAttribute("href","styles/shCoreMDUltra.css");
            else if ("midnight"==type)
                css.setAttribute("href","styles/shCoreMidnight.css");
            else if ("rdark"==type)
                css.setAttribute("href","styles/shCoreRDark.css");

            render();
        }

        $(document).ready(function() {
            SyntaxHighlighter.all()
            $(":radio").click(function() {
                change($(this).val());
            });
        })

        function render() {
            SyntaxHighlighter.highlight();
        }
    </script>

</head>

<body>

<jsp:include page="nav.html"/>

<table>
    <tr><td><h1>${code.title}</h1></td></tr>
    <tr><td><h2>by ${code.owner}</h2></td></tr>

    <tr>
        <!-- 切换显示效果 -->
        <td>
            <label><input type="radio" name="higilight_style" checked="checked" value="default"/>默认样式</label>
            <label><input type="radio" name="higilight_style" value="emacs"/>Emacs样式</label>
            <label><input type="radio" name="higilight_style" value="eclipse"/>Eclipse样式</label>
            <label><input type="radio" name="higilight_style" value="django"/>Django样式</label>
            <label><input type="radio" name="higilight_style" value="fadetogrey"/>FadeToGrey样式</label>
            <label><input type="radio" name="higilight_style" value="mdultra"/>MDUltra样式</label>
            <label><input type="radio" name="higilight_style" value="midnight"/>Midnight样式</label>
            <label><input type="radio" name="higilight_style" value="rdark"/>RDark样式</label>
        </td>
    </tr>
</table>
</body>
</html>

    <tr>
        <td><div style="background: black; width: 80%;"  id="codebox" >
            <pre class="brush: ${code.type}};">${code.source}</pre>
        </div></td>
    </tr>

<tr>
    <td>
        <img alt="显示图片" style="float: right;"
             src="<s:url action='qrcode'><s:param name='id' value='#request.code.id'></s:param></s:url>"/>
    </td>
</tr>

</table>
