package maysjl.com.cn.handwrittencode;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-09 15:33
 **/
@Slf4j
public class DifyThreadPool {

    // 存放任务的阻塞队列
    BlockingQueue<Runnable> taskQueue;
    //线程列表
    List<DifyThread> threads;

    DifyThreadPool(BlockingQueue<Runnable> taskQueue, int threadSize){
        this.taskQueue = taskQueue;
        threads = new ArrayList<>(threadSize);
        //初始化线程，并定义名称
        IntStream.rangeClosed(1, threadSize).forEach((i) ->{
            DifyThread thread =  new DifyThread("dify-task-thread-" + i);
            thread.start();
            threads.add(thread);
        });
    }

    //提交任务只是往任务队列里面赛任务
    public void execute(Runnable task) throws InterruptedException {
        taskQueue.put(task);
    }


    class DifyThread extends Thread {
        public DifyThread(String name){
            super(name);
        }

        @Override
        public void run() {
            while(true){
                Runnable task = null;
                try{
                    task = taskQueue.take();
                }catch (InterruptedException e){
                    log.error("记录点东西......",e);
                }
                task.run();
            }
        }
    }

    public static void main(String[] args) {
        DifyThreadPool pool = new DifyThreadPool(new LinkedBlockingQueue<>(10),3);
        IntStream.rangeClosed(1, 5).forEach((i) ->{
            try{
                pool.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }catch (InterruptedException e){
                log.error("记录报错",e);
            }
        });
    }
}
