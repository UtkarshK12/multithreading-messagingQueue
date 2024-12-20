package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantQueue {
    private Queue<Integer> queue;
    volatile boolean available;
    private ReentrantLock reentrantLock=new ReentrantLock();

    public ReentrantQueue(ReentrantLock reentrantLock){
        this.reentrantLock=reentrantLock;
        queue=new LinkedList<>();
        available=false;
    }

    public List<Integer> get() {
        reentrantLock.lock();
        if(queue.isEmpty()) {
            reentrantLock.unlock();
            return new ArrayList<>();  // Return empty if no data
        }
        // If we have data, consume it
        ArrayList<Integer> ar = new ArrayList<>();

        ar.add(queue.poll());

        available = !queue.isEmpty();  // Update flag based on remaining items
        reentrantLock.unlock();
        return ar;
    }

    public void add(int val) {
        reentrantLock.lock();
        queue.add(val);
        available = true;
        System.out.println("added value -> "+val);
        reentrantLock.unlock();
    }

}
