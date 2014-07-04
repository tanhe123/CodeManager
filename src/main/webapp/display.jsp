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


    <script>
        function change(type){    //更改样式
            var css=document.getElementById("css");
            if ("default"==type)
                css.setAttribute("href","styles/shCoreDefault.css");
            if ("emacs"==type)
                css.setAttribute("href","styles/shCoreEmacs.css");
            if ("django"==type)
                css.setAttribute("href","styles/shCoreDjango.css");
            if ("eclipse"==type)
                css.setAttribute("href","styles/shCoreEclipse.css");
            if ("fadetogrey"==type)
                css.setAttribute("href","styles/shCoreFadeToGrey.css");
            if ("mdultra"==type)
                css.setAttribute("href","styles/shCoreMDUltra.css");
            if ("midnight"==type)
                css.setAttribute("href","styles/shCoreMidnight.css");
            if ("rdark"==type)
                css.setAttribute("href","styles/shCoreRDark.css");

            SyntaxHighlighter.all();
//            render();
        }

    </script>

</head>

<body>
<table>
    <tr><td><h1>${code.title}</h1></td></tr>
    <tr><td><h2>by ${code.owner}</h2></td></tr>

    <tr>
        <td>
            <label class="radio"><input type="radio" name="higilight_style" checked="checked" onclick="change('default')" value="default"/>默认样式</label>
            <label class="radio"><input type="radio" name="higilight_style" value="emacs" onclick="change('emacs')"/>Emacs样式</label>
            <label class="radio"><input type="radio" name="higilight_style" value="eclipse" onclick="change('eclipse')"/>Eclipse样式</label>
            <label class="radio"><input type="radio" name="higilight_style" value="django" onclick="change('django')"/>Django样式</label>
            <label class="radio"><input type="radio" name="higilight_style" value="fadetogrey" onclick="change('fadetogrey')"/>FadeToGrey样式</label>
            <label class="radio"><input type="radio" name="higilight_style" value="mdultra" onclick="change('mdultra')"/>MDUltra样式</label>
            <label class="radio"><input type="radio" name="higilight_style" value="midnight" onclick="change('midnight')"/>Midnight样式</label>
            <label class="radio"><input type="radio" name="higilight_style" value="rdark" onclick="change('rdark')"/>RDark样式</label>
        </td>
    </tr>

</body>
</html>


<tr>
    <td><div style="background: black; width: 80%; height: 100"  id="codebox" >
        <pre class="brush: ${code.type}};">${code.source}</pre>
    </div></td>
</tr>

<tr>
    <td>
        <img alt="显示图片" style="float: right;"
             src="<s:url action='qrcode'><s:param name='id' value='#request.code.id'></s:param></s:url>"/></td>
</tr>

<script type="text/javascript">SyntaxHighlighter.all();</script>
<!-- <script type="text/javascript">SyntaxHighlighter.parent().html()</script>-->
</table>
