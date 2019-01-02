package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

public class ExecutorsTest {

	public static void main(String[] args) {

		// 获取默认线程工厂
		ThreadFactory threadFactory = Executors.defaultThreadFactory();
		
		// 获取缓存线程池
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		// 根据ThreadFactory获取缓存线程池
		ExecutorService	newCachedThreadPool2 = Executors.newCachedThreadPool(threadFactory);
		
		// 获取固定线程长度的线程池
		int nThreads = 3;
		ExecutorService	newFixedThreadPool = Executors.newFixedThreadPool(nThreads);
		// 根据ThreadFactory获取固定长度的线程池
		ExecutorService	newFixedThreadPool2 = Executors.newFixedThreadPool(nThreads, threadFactory);
		
		// 获取调度线程池
		int corePoolSize = 3;
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(corePoolSize);
		// 根据ThreadFactory获取调度线程池
		ScheduledExecutorService newScheduledThreadPool2 = Executors.newScheduledThreadPool(corePoolSize, threadFactory);
		
		// 创建单一线程执行器
		ExecutorService	newSingleThreadExecutor = Executors.newSingleThreadExecutor();
		// 根据ThreadFactory创建单一线程执行器
		ExecutorService	newSingleThreadExecutor2 = Executors.newSingleThreadExecutor(threadFactory);
		
		// 创建单一线程调度执行器
		ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
		// 根据threadFactory创建单一线程调度执行器
		ScheduledExecutorService newSingleThreadScheduledExecutor2 = Executors.newSingleThreadScheduledExecutor(threadFactory);
		
		// 新建工作窃取线程池
		ExecutorService	newWorkStealingPool = Executors.newWorkStealingPool();
		// 根据并行等级创建工作窃取线程池
		int parallelism = 3;
		ExecutorService	newWorkStealingPool2 = Executors.newWorkStealingPool(parallelism);
	}

}
