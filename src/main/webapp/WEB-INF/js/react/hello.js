var h1 = React.createElement('h1', null, 'Hello World');
var bdl = React.createElement('a', {href:'http://www.baidu.com'},'百度地址');

/*ReactDOM.render(
    React.createElement('div',null,h1,bdl),
    document.getElementById("content")
);*/

/*
class Point{
    constructor(x,y){
        this.x = x;
        this.y = y;
    }
    toString(){
        return '('+this.x+","+this.y+')';
    }
}

var point = new Point(2,4);
console.info(point.toString());*/

//创建组件
class HelloWorld extends  React.Component{
    render(){
        return React.createElement(
            'h1'
            ,this.props
            ,'Hello '+this.props.title
        );
    }
}
