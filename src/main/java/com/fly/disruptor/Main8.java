package com.fly.disruptor;

/**
 * User: Administrator
 * Date: 2018/12/24
 * Time: 15:40
 */
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.Executors;

public class Main8 {

    //单生产者，多消费者模式。消费者1、2独立消费每一条消息，消费者3、4不重复消费消费者1、2均处理过的消息，消费者5消费消费者3或4消费过的消息
    public static void main(String[] args) throws Exception {
        EventFactory<Order> factory = new OrderFactory();
        int ringBufferSize = 1024 * 1024;
        Disruptor<Order> disruptor =
                new Disruptor<Order>(factory, ringBufferSize, Executors.defaultThreadFactory(), ProducerType.SINGLE, new YieldingWaitStrategy());
        disruptor.handleEventsWith(new OrderHandler1("1"), new OrderHandler1("2")).thenHandleEventsWithWorkerPool(new OrderHandler1("3"), new OrderHandler1("4")).then(new OrderHandler1("5"));
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
