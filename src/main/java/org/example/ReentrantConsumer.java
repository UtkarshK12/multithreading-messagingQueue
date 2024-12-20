package org.example;

import static java.lang.Thread.sleep;

public class ReentrantConsumer implements Runnable{

    ReentrantQueue queue;

    public ReentrantConsumer(ReentrantQueue queueContainer){
        this.queue=queueContainer;
    }

    @Override
    public void run() {

        while(true){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("consumed value -> "+queue.get());
        }
        }

}
