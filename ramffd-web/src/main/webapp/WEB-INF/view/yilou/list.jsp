<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/10
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/page.css">
    <script src="<%=path%>/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/page.js"></script>
    <style type="text/css">
        .tablePage{ width: 1000px; height: 50px; margin-top: 100px;    }
        .activP{
            background-color: #367fa9!important;
            color: #fff!important;
        }
    </style>
</head>

<body>
    <table>
        <thead>
        <tr>
            <th width="80px">站点编号</th>
            <th width="80px">终端类型</th>
            <th width="80px">终端子类型</th>
            <th width="80px">终端物理地址</th>
            <th width="80px">终端型号</th>
            <th width="80px">版本号</th>
            <th width="80px">开通授权</th>
            <th width="80px">下载状态</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${yilous}" var="item">
                <tr>
                    <td>${item.countDatetime}</td>
                    <td>${item.playCode}</td>
                    <td>${item.chartType}</td>
                    <td>${item.playEname}</td>
                    <td>${item.termCode}</td>
                    <td>${item.maxVal}</td>
                    <td>${item.curVal}</td>
                    <td>${item.timesVal}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="tablePage"></div>
    <script type="text/javascript">

        $('.tablePage').page({
            leng: 66,//分页总数
            activeClass: 'activP' , //active 类样式定义
            clickBack:function(page){
                console.log(page)
            }
        })
        // $('.pageTest').setLength(10)
    </script>

</body>
</html>
