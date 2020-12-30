package com.thread;

import com.staticDemo.Base;

import java.util.UUID;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * @Author:         jiangzhihong
 * @CreateDate:     2020/12/29 15:53
 */
public class Oom1 {
	public static void main(String[] args) throws InterruptedException {
		ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
		//打印线程池的信息，稍后我会解释这段代码
//		printStats(threadPool);
		for (int i = 0; i < 100000000; i++) {
			System.out.println(i);
			threadPool.execute(() -> {
				String payload = IntStream.rangeClosed(1, 1000000)
						.mapToObj(__ -> "a")
						.collect(Collectors.joining("")) + UUID.randomUUID().toString();
				System.out.println(payload);
				try {
					TimeUnit.HOURS.sleep(1);
				} catch (InterruptedException e) {
				}
				System.out.println(payload);
			});
		}

		threadPool.shutdown();
		threadPool.awaitTermination(1, TimeUnit.HOURS);
	}

}
