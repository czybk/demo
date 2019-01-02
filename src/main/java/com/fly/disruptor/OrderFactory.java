package com.fly.disruptor;

/**
 * User: Administrator
 * Date: 2018/12/24
 * Time: 15:01
 */
import com.lmax.disruptor.EventFactory;

public class OrderFactory implements EventFactory<Order> {

    public Order newInstance() {
        return new Order();
    }
}
