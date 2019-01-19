<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/5
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传测试</title>
</head>
<body>
     <h2>spring MVC 上传测试</h2>
    <form action="/saveAuthor" method="post" enctype="multipart/form-data">
         <table>
             <tr>
                 <td>用户名：</td>
                 <td><input type="text" name="userName"></td>
             </tr>
             <tr>
                 <td>年龄</td>
                 <td><input type="text" name="age"/></td>
             </tr>
             <tr>
                 <td>上传文件</td>
                 <td><input type="file" name="image" multiple="multiple"/></td>
             </tr>
             <tr>
                 <td colspan="2">
                     <input type="submit" name="提交" />
                 </td>
             </tr>

         </table>

    </form>
<br/>
     <form  id="authorForm" >
         <table>
             <tr>
                 <td>用户名：</td>
                 <td><input type="text" name="userName"></td>
             </tr>
             <tr>
                 <td>年龄</td>
                 <td><input type="text" name="age"/></td>
             </tr>
             <tr>
                 <td>上传文件</td>
                 <td><input type="file" name="image" multiple="multiple"/></td>
             </tr>
             <tr>
                 <td colspan="2">
                     <button type="button" onclick="send();">提交</button>
                 </td>
             </tr>

         </table>

     </form>
<progress id="pro" value="0" min="0" max="100" style="display: none"></progress>
<script type="text/javascript">
    var xhr  = new XMLHttpRequest();
    var progres = document.querySelector("#pro");
    var submitUrl = "/saveAuthor";
    function send(){

        xhr.open("POST",submitUrl,true);
        xhr.upload.onprogress = function(e){
            //根据上传进度改变上传进度的值
            progres.value = (e.loaded/e.total)*100;
            //上传完成隐藏进度条
            if(e.loaded>e.total){
                progres.style.display="none";
            }
        }
        xhr.onload = progressResponse;
        var formData = new FormData(document.querySelector("#authorForm"))
        xhr.send(formData);
        progres.style.display="";

    }
    function progressResponse(){
        if(xhr.status==200){
            alert(xhr.responseText);
        }
    }
</script>
</body>
</html>
