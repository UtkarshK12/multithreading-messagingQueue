package org.example;

import static java.lang.Thread.sleep;

public class Producer implements Runnable{

    QueueContainer queue;

    public Producer(QueueContainer queueContainer){
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
