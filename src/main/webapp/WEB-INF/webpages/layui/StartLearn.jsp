<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/29
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/common.jsp" %>
<html>
<script type="text/javascript">
    layui.use(['layer'], function (layer) {
      //  layer.msg('hello world');

    });
    //localStorage 持久化存储：layui.data(table, settings)，数据会永久存在，除非物理删除。
    //sessionStorage 会话性存储：layui.sessionData(table, settings)，页面关闭后即失效。注：layui 2.2.5 新增
    layui.data('myname',{
        key:'myname',
        value:'fire'
    });
    var obj = layui.data('myname');
    console.info(obj.myname);

    var div = layui.device();
    console.info(div);
</script>
<style type="text/css">
    .demo{
        background-color: #63BA79;
        line-height: 50px;
        text-align: center;
    }
</style>
<head>
    <title>Title</title>
</head>

<body>
   <div class="layui-container">
       <blockquote class="layui-elem-quote">我的布局  引用区块文字</blockquote>

       <div class="layui-row layui-col-space10">
           <div class="layui-col-md2 layui-bg-red">姓名</div>
           <div class="layui-col-md4 layui-bg-green" >hello</div>
           <div class="layui-col-md2 layui-bg-blue">姓名</div>
           <div class="layui-col-md4 layui-bg-orange">hello</div>
       </div>
       <hr class="layui-bg-red"/>
       <fieldset class="layui-elem-field">
           <legend>我的布局</legend>
           <div class="layui-field-box">内容区域</div>
       </fieldset>
       <div class="layui-row layui-col-space5">
           <div class="layui-col-md4 ">
               <div class="demo">姓名</div>
           </div>
           <div class="layui-col-md8 " >
               <div class="demo">陈某某</div>
           </div>
       </div>
       <hr class="layui-bg-orange"/>
       <div class="layui-row">
           <div class="layui-col-md4">
               <div class="demo">1/3</div>
           </div>
           <div class="layui-col-md4">
               <div class="demo">1/3</div>
           </div>
           <div class="layui-col-md4">
               <div class="demo">1/3</div>
           </div>
       </div>
       <hr class="layui-bg-blue"/>
       <div class="layui-row layui-col-space5">
           <div class="layui-col-lg2">
               <div class="demo">1/6</div>
           </div>
           <div class="layui-col-lg4">
               <div class="demo">1/3</div>
           </div>
           <div class="layui-col-lg2">
               <div class="demo">1/6</div>
           </div>
           <div class="layui-col-lg4">
               <div class="demo">1/3</div>
           </div>
       </div>

   </div>
<hr class="layui-bg-black" />
<blockquote class="layui-elem-quote">
    图标示例
</blockquote>
   <fieldset class="layui-elem-field">
       <legend>我的图标</legend>
       <div class="layui-field-box">
           <li class="layui-icon layui-icon-face-smile" style="font-size: 30px;color: red"></li>
           <li class="layui-icon layui-icon-release" style="font-size: 30px;color: blue"></li>
       </div>
   </fieldset>

</body>
</html>
