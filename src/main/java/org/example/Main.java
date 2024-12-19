package org.example;

public class Main {

    public static  void main(String[]args) throws InterruptedException {

    QueueContainer queueContainer = new QueueContainer();
    Producer producer = new Producer(queueContainer);
    Consumer consumer = new Consumer(queueContainer);
    Thread t1 = new Thread(producer);
    Thread t2 = new Thread(consumer);

    t1.start();
    t2.start();

    }

}