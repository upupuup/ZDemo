package com.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author:         jiangzhihong
 * @CreateDate:     2020/12/29 17:21
 */
public class MyCreateThreadPoolDemo {
	/**
	 * 需要引入这个
	 * <!-- https://mvnrepository.com/artifact/com.google.guava/guava -->
	 * <dependency>
	 *   <groupId>com.google.guava</groupId>
	 *   <artifactId>guava</artifactId>
	 *   <version>28.2-jre</version>
	 * </dependency>
	 */
	// 线程数
	public static final int THREAD_POOL_SIZE = 16;

	public static void main(String[] args) throws InterruptedException {
//		// 使用 ThreadFactoryBuilder 创建自定义线程名称的 ThreadFactory
//		ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
//				.setNameFormat("hyn-demo-pool-%d").build();
//
//		// 创建线程池，其中任务队列需要结合实际情况设置合理的容量
//		ThreadPoolExecutor executor = new ThreadPoolExecutor(THREAD_POOL_SIZE,
//				THREAD_POOL_SIZE,
//				0L,
//				TimeUnit.MILLISECONDS,
//				new LinkedBlockingQueue<>(1024),
//				namedThreadFactory,
//				new ThreadPoolExecutor.AbortPolicy());
//
//		// 新建 1000 个任务，每个任务是打印当前线程名称
//		for (int i = 0; i < 1000; i++) {
//			executor.execute(() -> System.out.println(Thread.currentThread().getName()));
//		}
//		// 优雅关闭线程池
//		executor.shutdown();
//		executor.awaitTermination(1000L, TimeUnit.SECONDS);
//		// 任务执行完毕后打印"Done"
//		System.out.println("Done");
	}
}

