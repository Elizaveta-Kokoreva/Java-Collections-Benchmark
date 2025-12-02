package org.example;

public class Result {
    public String method;
    public int count;
    public double arrayListTime;
    public double linkedListTime;

    public Result(String method, int count, double arrayListTime, double linkedListTime) {
        this.method = method;
        this.count = count;
        this.arrayListTime = arrayListTime;
        this.linkedListTime = linkedListTime;
    }
}
