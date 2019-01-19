
<%@include file="../common/common.jsp" %>


<html>
<head>
    <title>reactDemo</title>
</head>
<body>

   <div id="content"></div>

</body>

<script type="text/javascript" src="<%=basePath%>/js/react/hello.js"></script>

<script type="text/javascript">
    ReactDOM.render(
         React.createElement('div',null
         ,React.createElement(HelloWorld,{
             id:'firstHello'
             ,title:'Devid'
         }),
             React.createElement(HelloWorld,{
                 id:'secondHello'
                 ,title:'Jom'
             })

         )
        ,document.getElementById('content')

    );
</script>
</html>
