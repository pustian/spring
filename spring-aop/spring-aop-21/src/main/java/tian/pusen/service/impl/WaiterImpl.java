package tian.pusen.service.impl;

import tian.pusen.service.Waiter;

/**
 * Created by tianpusen on 2017/3/26.
 */
public /*final 代理会出问题*/ class WaiterImpl implements Waiter {
    @Override
    public void greetTo(String name) {
        System.out.println("greet to "+name+" ...");
    }
    @Override
    public void serveTo(String name) {
        System.out.println("serve to "+name+" ...");
    }

    @Override
    public void waiting(String name) {
        System.out.println("no service to "+name+" ...");
        throw new RuntimeException("I have been waiting ");
    }
}
