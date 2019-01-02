package lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
	    public static void main(String[] args) {
	        ReentrantLock lock = new ReentrantLock();// 初始化lock对象
	        Fruit fruit = new Fruit("苹果", 100);// 初始化苹果的数量
	        ThreadDemo threadDemo = new ThreadDemo(lock, 10, fruit);// 初始化线程对象
	        Thread t1 = new Thread(threadDemo, "线程1");// 创建线程
	        Thread t2 = new Thread(threadDemo, "线程2");
	        Thread t3 = new Thread(threadDemo, "线程3");
	        t1.start();// 启动线程
	        System.out.println("判断锁是否在使用："+lock.isLocked());
	        t2.start();
	        t3.start();
	        // 判断指定的线程是否在等待锁
	        System.out.println("t3线程是否在等待："+lock.hasQueuedThread(t3));
	        // 判断是否存在等待的线程
	        System.out.println("是否存在等待的线程："+lock.hasQueuedThreads());
	    }
	}

	class ThreadDemo implements Runnable {
	    private int count;
	    private ReentrantLock lock;
	    private Fruit fruit;

	    public ThreadDemo(ReentrantLock lock, int count, Fruit fruit) {
	        this.lock = lock;
	        this.count = count;
	        this.fruit = fruit;
	    }

	    public void run() {

	        lock.lock();// 枷锁

	        try {
	        	//返回lock()方法调用次数
	        	System.out.println("HoldCount:"+lock.getHoldCount());
	        	//返回正在等待线程数量
	        	System.out.println("QueueLength:"+lock.getQueueLength());
	        	// 判断是否存在等待的线程
		        System.out.println("是否存在等待的线程："+lock.hasQueuedThreads());
		        // 判断锁是否在使用
		        System.out.println("判断锁是否在使用："+lock.isLocked());

	        	fruit.DiscountApple(count);
	        } catch (Exception e) {
	            System.out.print("调用卖苹果的方法发生异常！");
	        } finally {
	            lock.unlock();// 解锁
	        }
	    }
	}

	class Fruit {
	    private String name;
	    int count;

	    /**
	     * @param name 苹果的名字
	     * @param count 初始化苹果的数量
	     */
	    public Fruit(String name, int count) {
	        this.name = name;
	        this.count = count;
	    }

	    public void DiscountApple(int discount) {
	        this.count = this.count - discount;
	        System.out.println(Thread.currentThread().getName() + ":苹果的数量为：" + this.count + ",卖掉了" + discount);
	    }
	}
