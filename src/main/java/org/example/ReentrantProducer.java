package org.example;

public class ReentrantProducer implements Runnable{

    ReentrantQueue queue;

    public ReentrantProducer(ReentrantQueue queueContainer){
        this.queue=queueContainer;
    }

    @Override
    public void run() {
        for(int i=0;i<20;i++){
            try {
                queue.add(i);
                //change this to interesting behavior
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
