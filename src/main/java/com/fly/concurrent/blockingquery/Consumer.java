package com.fly.concurrent.blockingquery;

import java.util.concurrent.BlockingQueue;

/**
 * User: Administrator
 * Date: 2018/12/25
 * Time: 15:32
 */
public class Consumer implements Runnable{

    protected BlockingQueue queue = null;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
