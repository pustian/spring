package tian.pusen.service.impl;

import tian.pusen.service.Seller;

/**
 * Created by tianpusen on 2017/3/26.
 */
public /*final cglib代理会出问题 p:proxyTargetClass="true"*/ class SellerImpl implements Seller {
    @Override
    public void greetTo(String name) {
        System.out.println("销售greet to "+name+" ...");
    }

}
