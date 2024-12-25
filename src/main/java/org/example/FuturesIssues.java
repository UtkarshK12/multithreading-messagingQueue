package org.example;

public class FuturesIssues {
    public String doTask(int timeout, String taskName) throws InterruptedException {
        Thread.sleep(timeout);
        System.out.println(taskName+" finished om thread "+ Thread.currentThread().getName());
        return taskName;
    }
}
