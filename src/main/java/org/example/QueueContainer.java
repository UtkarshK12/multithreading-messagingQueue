package org.example;

import java.util.*;

public class QueueContainer {
    private Queue<Integer>queue = new LinkedList<Integer>();
    boolean available = false;

    public synchronized List<Integer> getValues() throws InterruptedException {
        while(queue.isEmpty()) {
            available=false;
            wait();
        }
        ArrayList<Integer> ar = new ArrayList<>();
        while(!queue.isEmpty()){
            ar.add(queue.poll());
        }
       return ar;
    }

    public synchronized void add(int val) throws InterruptedException {
        available=true;
        System.out.println("added value -> "+val);
        queue.add(val);
        notifyAll();
    }
}
