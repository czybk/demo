package com.fly.disruptor;

/**
 * User: Administrator
 * Date: 2018/12/24
 * Time: 15:04
 */
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.Executors;

/**
 * 这种情况最为简单，单生产者，仅需在Disruptor初始化时，传入ProducerType.SINGLE即可。
 * 使用disruptor.handleEventsWith传入单消费者。
 * Thread.sleep方法调用是为了保证，在调用disruptor.shutdown方法前，
 * 所有的消费者线程都已经启动，防止shutdown失效的问题.
 */
public class Main1 {

    //单生产者模式，单消费者模式
    public static void main(String[] args) throws Exception {
        EventFactory<Order> factory = new OrderFactory();
        int ringBufferSize = 1024 * 1024;
        Disruptor<Order> disruptor =
                new Disruptor<Order>(factory, ringBufferSize, Executors.defaultThreadFactory(), ProducerType.SINGLE, new YieldingWaitStrategy());
        //设置一个消费者
        disruptor.handleEventsWith(new OrderHandler1("1"));
        disruptor.start();
        RingBuffer<Order> ringBuffer = disruptor.getRingBuffer();
        Producer producer = new Producer(ringBuffer);
        //单生产者，生产3条数据
        for (int l = 0; l < 3; l++) {
            producer.onData(l + "");
        }
        //为了保证消费者线程已经启动，留足足够的时间。具体原因详见另一篇博客：disruptor的shutdown失效问题
        Thread.sleep(1000);
        disruptor.shutdown();
    }
}
