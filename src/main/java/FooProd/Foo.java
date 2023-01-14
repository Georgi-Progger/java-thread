package main.java.FooProd;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Foo {
    Semaphore sSecond, sThird;

    public Foo() {
        sSecond = new Semaphore(0);
        sThird = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        sSecond.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        sSecond.acquire();
        printSecond.run();
        sThird.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        sThird.acquire();
        printThird.run();
    }
}


