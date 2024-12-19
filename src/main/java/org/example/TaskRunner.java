package org.example;

public class TaskRunner implements Runnable{

    private int counter;
    String threadName;
    public TaskRunner(int counter, String threadName){
        this.counter=counter;
        this.threadName= threadName;

    }
    @Override
    public void run() {
        int n=10;
        if(threadName.equals("1"))n=100;
        for(int i=0;i<n;i++){
            counter++;
            System.out.println("threadName :" + threadName+" counter ->"+counter);
        }
    }
}
