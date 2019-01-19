layui.use('table', function(){
    var usertable = layui.table;
    usertable.render({
        elem:'#userTable',
        height:460,
        url:'/sysUser/userGrid',
        toolbar: '#userToolbar',
        page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
        layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
            //,curr: 5 //设定初始在第 5 页
            ,groups: 2 //只显示 1 个连续页码
            ,first: true //不显示首页
            ,last: true //不显示尾页
    },
        cols:[[
            {type:'checkbox'},
            {field:'userId',title:'用户ID',width:300},
            {field:'username',title:'账号名称',width:100},
            {field:'fullname',title:'用户姓名',width:200},
            {field:'mobile',title:'手机号码',width:150},
            {field:'createTime',title:'创建时间',width:180},
          {fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
        ]]
    });
})