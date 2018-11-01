/*
 * Copyright (c)
 */
package test.designpattern.proxy;

/**
 * 代理类
 *
 * @author David Lin
 * @version: 1.0
 * @date 2018-10-28 23:15
 */
public class Proxy implements  Subject {
    //要代理哪个实现类
    private Subject subject = null;

    // 通过构造函数传递被代理者
    public Proxy(Subject subject){
        this.subject = subject;
    }

    // 实现接口中定义的方法
    @Override
    public void request() {
        this.before();
        this.subject.request();
        this.after();
    }
    // 预处理
    private void before(){

    }
    // 善后处理
    private void after(){

    }
}
