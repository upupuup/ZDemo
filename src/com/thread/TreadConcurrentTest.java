package com.thread;

/**
 * @Author:         jiangzhihong
 * @CreateDate:     2020/12/28 18:18
 */
public class TreadConcurrentTest {
	private static final long count = 10000;//10万
	public static void main(String[] args) throws Exception
	{
		//并发
		concurrent();
		//串行
		serial();
	}
	//并发执行
	private static void concurrent() throws Exception
	{
		long start = System.currentTimeMillis();
		Thread thread = new Thread(new Runnable(){
			public void run()
			{
				int a = 0;
				for (int i = 0; i < count; i++)
				{
					a += 5;
				}
			}
		});
		thread.start();
		Thread thread2 = new Thread(new Runnable(){
			public void run()
			{
				int b = 0;
				for (long i = 0; i < count; i++)
				{
					b --;
				}
			}
		});
		thread2.start();
		//阻塞主线程，等待htread和thread2线程执行完再往下执行
		thread.join();
		thread2.join();
		long time = System.currentTimeMillis() - start;
		System.out.println("Concurrency：" + time + "ms");
	}
	//串行执行
	private static void serial()
	{
		long start = System.currentTimeMillis();
		int a = 0;
		for (long i = 0; i < count; i++)
		{
			a += 5;
		}
		int b = 0;
		for (int i = 0; i < count; i++)
		{
			b --;
		}
		long time = System.currentTimeMillis() - start;
		System.out.println("Serial：" + time + "ms");
	}
}