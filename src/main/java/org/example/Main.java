package org.example;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static  void main(String[]args) throws InterruptedException, ExecutionException {

//    QueueContainer queueContainer = new QueueContainer();
//    Producer producer = new Producer(queueContainer);
//    Consumer consumer = new Consumer(queueContainer);
//    Thread t1 = new Thread(producer);
//    Thread t2 = new Thread(consumer);
//
//    t1.start();
//    t2.start();

//    ReentrantLock re = new ReentrantLock();
//    ReentrantQueue reentrantQueue = new ReentrantQueue(re);
//    ReentrantProducer pr = new ReentrantProducer(reentrantQueue);
//    ReentrantConsumer cr = new ReentrantConsumer(reentrantQueue);
//
//            //producer 1
//            Thread t1 = new Thread(pr);
//
//            //producer 2
//            Thread t3 = new Thread(pr);
//
//            //consumer 1
//            Thread t2 = new Thread(cr);
//
//
//            t1.start();
//            t2.start();
//
//            //after messages published from t1, we check consume messages after every 1 sec
//            t1.join();
//            Thread.sleep(500);
//            t3.start();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,30,1, TimeUnit.HOURS,new ArrayBlockingQueue<Runnable>(10),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());


        Callable<Integer> callable= new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(10000);
                return 1;
            }
        };

        APIFetcher apiFetcher = new APIFetcher();
        System.out.println(apiFetcher.getPokemonNamesAsync().get());
        System.out.println("Hello");
        Thread.sleep(3000);


    }



}