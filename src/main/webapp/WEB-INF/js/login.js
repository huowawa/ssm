layui.use(['element', 'layer', 'jquery'],function(){
    var $ = layui.$;

 // 点击验证码刷新
  $(".captcha-img").on("click",function(){
      var src = this.src.split("?")[0];
      var time = Math.random();
      this.src = src+"?s="+time;
  });

  $(".ajax-login").on("click",function(e){
      //阻止默认事件行为的触发。
      e.preventDefault();

      var action = $("form").attr("action");

      var params = $("form").serializeArray();
      console.info(params);
      $.post(action,params,function(result){
        console.info(result);
      })
  });


});