package org.example;

public class Consumer implements Runnable{

    QueueContainer queue;

    public Consumer(QueueContainer queueContainer){
        this.queue=queueContainer;
    }

    @Override
    public void run() {

        while(queue.available){
            try {
                System.out.println("consumed value -> "+queue.getValues());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        }

}
