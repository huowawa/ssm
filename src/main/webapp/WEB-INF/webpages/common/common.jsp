
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<script type="text/javascript" src="<%=basePath%>/resources/layui-2.4/layui.js"></script>
<%--
<script type="text/javascript" src="<%=basePath%>/resources/react15/react.js"></script>
<script type="text/javascript" src="<%=basePath%>/resources/react15/react-dom.js"></script>
--%>



<link rel="stylesheet" type="text/css" href="<%=basePath%>/resources/layui-2.4/css/layui.css"/>