package org.example;

public class ArrayFiller {
    private int [] arr;

    public ArrayFiller(){
        arr=new int[200];
    }

    void add(int index, int value) throws InterruptedException {
        Thread.sleep(50);
        arr[index] = value;
    }
}
