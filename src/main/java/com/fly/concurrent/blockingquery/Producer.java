package com.fly.concurrent.blockingquery;

import java.util.concurrent.BlockingQueue;

/**
 * User: Administrator
 * Date: 2018/12/25
 * Time: 15:32
 */
public class Producer implements Runnable{

    protected BlockingQueue queue = null;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            queue.put("1");
            Thread.sleep(1000);
            queue.put("2");
            Thread.sleep(1000);
            queue.put("3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
