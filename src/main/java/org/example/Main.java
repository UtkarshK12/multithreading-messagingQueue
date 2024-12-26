package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

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

 //       ----------------Reentrant lock queue

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


//        ---------------- completablefuture api representation
//
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,30,1, TimeUnit.HOURS,new ArrayBlockingQueue<Runnable>(10),
//                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
//
//
//        Callable<Integer> callable= new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                Thread.sleep(10000);
//                return 1;
//            }
//        };
//
//        APIFetcher apiFetcher = new APIFetcher();
//        System.out.println(apiFetcher.getPokemonNamesAsync().get());
//        System.out.println("Hello");
//        Thread.sleep(3000);


      //  ------------ futures issues
//
//       ExecutorService executorService = Executors.newFixedThreadPool(3);
//
//        Future<String> task1Future = executorService.submit(()-> {
//            try {
//                return new FuturesIssues().doTask(5000,"task 1");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        Future<?> task2Future = executorService.submit(()-> {
//            try {
//                return new FuturesIssues().doTask(1000,"task 2");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        Future<?> task3Future = executorService.submit(()-> {
//            try {
//                return new FuturesIssues().doTask(3000,"task 3");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//
//
//        //lets try to get task 1, 2 and 3. Ideally the order should be 2,3,1
//        //but as soon as we call the get method on the future we start to make the thraead blocking and make it wait
//
//
//        System.out.println("Task returned ! ->" + task1Future.get());
//        System.out.println("Task returned ! ->" + task2Future.get());
//        System.out.println("Task returned ! ->" + task3Future.get());
//
//        // this creates a problem for us as the threads now become blocking instead of having the non blocking nature that we wanted
//
//        // the solution is completeableFuture
//
//
//


//        ExecutorService executor = Executors.newFixedThreadPool(4);
//
//        CompletableFuture<?> pipeline = CompletableFuture.supplyAsync(() -> {
//                    try {
//                        Thread.sleep(5000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    System.out.println("reply received");
//                    return "reply received";
//                }, executor)
//                .exceptionally(throwable -> {
//                    System.out.println(throwable.getMessage());
//                    return null;
//                })
//                .thenApply(taskResult -> {
//                    System.out.println("processing reply");  // Changed to be more descriptive
//                    return taskResult + ":::: task acknowledged";
//                })
//                .thenAccept(time -> System.out.println("Final result: " + time));
//
//        pipeline.join();
//        executor.shutdown();
//
//
//
//
//

//        ExecutorService pool = Executors.newFixedThreadPool(5);
//        Supplier<String> futuretask1 = () -> {
//            try {
//                return new FuturesIssues().doTask(3000,"task 1");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        };
//        Supplier<String> futuretask2 = () -> {
//            try {
//                return new FuturesIssues().doTask(3000,"task 2");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        };
//        Supplier<String> futuretask3 = () -> {
//            try {
//                return new FuturesIssues().doTask(5000,"task 3");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        };
//        Supplier<String> futuretask4 = () -> {
//            try {
//                return new FuturesIssues().doTask(6000,"task 4");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        };
//
//       CompletableFuture pipeline = CompletableFuture.supplyAsync(futuretask1,pool)
//               .thenCombine(CompletableFuture.supplyAsync(futuretask2,pool),(res1,res2)->res1+" "+res2)
//               .thenCompose(res -> CompletableFuture.supplyAsync(futuretask3,pool)
//                       .thenCombine(
//                               CompletableFuture.supplyAsync(futuretask4,pool),
//                               (res1,res2)->res+" "+res1+" "+res2)
//               )
//               .thenAccept(res -> {System.out.println("tasks completed ->"+res);});
//
//        System.out.println("tasks running in bg");
//        pipeline.join();
//
//

//        ExecutorService pool = Executors.newFixedThreadPool(5);
//
//        Callable cll = () ->{
//            Thread.sleep(5000);
//            return "received string !!";
//        };
//
//        Future f1 = pool.submit(cll);
//
//
//        System.out.println("future running in bg");
//        System.out.println(f1.get()+ " " +f1.isDone());


//        CompletableFuture<String> cf = CompletableFuture.supplyAsync(()->{
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            String a = "task";
//            return String.format("completed all %s",a);
//        });
//
//
//       CompletableFuture<String> cf2=cf.thenApply(res -> {
//           try {
//               Thread.sleep(1000);
//           } catch (InterruptedException e) {
//               throw new RuntimeException(e);
//           }
//           return res+" done2";});
//
//       System.out.println("tasks delegated");
//
//       cf2.whenComplete((res, error)->{
//           if(error!=null){
//               System.out.println("error");
//           }
//           else{
//               System.out.println(res);
//           }
//       });
//
//        cf2.join();



        //      ----------------performance testing --------------


        long startTime = System.nanoTime();
        ArrayFiller ar = new ArrayFiller();
        for(int i=0;i<200;i++){
            ar.add(i,i);
        }
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("total time method 1 ->"+ totalTime);


        long startTime2 = System.nanoTime();
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        ArrayFiller ar2= new ArrayFiller();
        // Store futures to track completion
        List<Future<?>> futures = new ArrayList<>();
        for(int i = 0; i < 200; i++) {
            final int ind = i;
            Future<?> future = executorService.submit(() -> {
                try {
                    ar2.add(ind, ind);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            futures.add(future);
        }

// Wait for all tasks to complete
        for(Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        long endTime2 = System.nanoTime();
        long totalTime2 = endTime2 - startTime2;
        System.out.println("total time method 2 -> " + totalTime2);

// Shutdown the executor
        executorService.shutdown();



    }

}