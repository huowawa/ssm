<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/30
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/common.jsp" %>
<html>
<head>
    <title>布局</title>
</head>
<style type="text/css">
    .layadmin-iframe {
        position: absolute;
        width: 100%;
        height: 99%;
    }
</style>
<body class="layui-layout-body">
<div class="layui-layout  layui-layout-admin">

    <div class="layui-header">
        <div class="layui-logo">layui后台布局</div>

        <ul class="layui-nav layui-layout-left  ">
            <li class="layui-nav-item"><a href="#">主页<span class="layui-badge-dot"></span></a></li>
            <li class="layui-nav-item"><a href="#">信息公开<span class="layui-badge">12</span></a></li>
        </ul>
        <ul class="layui-nav layui-layout-right ">
            <li class="layui-nav-item"><a href="#">林金火</a>
                <dl class="layui-nav-child">
                    <dd><a href="#">基本信息</a></dd>
                    <dd><a href="#">修改密码</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="#">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree ">
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="#" class="">商品</a>
                    <dl class="layui-nav-child">
                        <dd><a href="#" class="myuser" tabTitle="用户管理" data-type="sysUser/learn.do">列表一</a></dd>
                        <dd><a href="#">列表一</a></dd>
                        <dd><a href="#">列表二</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="#">解决方案</a>
                    <dl class="layui-nav-child">
                        <dd><a href="#">方案一</a></dd>
                        <dd><a href="#">方案二</a></dd>
                        <dd><a href="#">方案三</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">云市场</a></li>
                <li class="layui-nav-item"><a href="">发布商品</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <div>

            <div class="layui-tab" lay-filter="demo" lay-allowclose="true">
                <ul class="layui-tab-title">
                    <li>用户管理</li>
                    <li>系统管理</li>
                    <li>tab3</li>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">内容1</div>
                    <div class="layui-tab-item">内容2</div>
                    <div class="layui-tab-item">内容3</div>
                </div>
            </div>


        </div>
    </div>

    <div class="layui-footer">

        底部固定位置
    </div>

</div>
<script type="text/javascript">
    layui.use(['element'], function (element) {
        var $ = layui.jquery;

        $('.myuser').on('click', function () {
            active.tabAdd("用户管理", "/sysUser/learn.do", "userid");
            //最后不管是否新增tab，最后都转到要打开的选项页面上
            active.tabChange("userid");
        });

        var active = {
            tabAdd: function (title, url, id) {
                element.tabAdd('demo', {
                    title: title
                    , content: '<iframe frameborder="0" class="layadmin-iframe" scrolling="auto" src="' + url + '"  ></iframe>'
                    , id: id
                });
                FrameWH();
            },
            tabChange: function (id) {
                //切换到指定Tab项
                element.tabChange('demo', id); //根据传入的id传入到指定的tab项
            },
            tabDelete: function (id) {
                element.tabDelete("demo", id);//删除
            }
        };

        function FrameWH() {
            var h = $(window).height();
            $("iframe").css("height", h + "px");
        }
    });


</script>
</body>
</html>
