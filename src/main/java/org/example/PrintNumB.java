package org.example;

import java.util.concurrent.locks.ReentrantLock;

public class PrintNumB {

    private static volatile int count = 0;
    private final static ReentrantLock lock = new ReentrantLock();

    // 使用
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task(0));
        Thread thread2 = new Thread(new Task(1));
        Thread thread3 = new Thread(new Task(2));
        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class Task implements Runnable {

        private final int threadNum;

        public Task(int threadNum) {
            this.threadNum = threadNum;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                if (count % 3 == threadNum) {
                    System.out.println(threadNum + 1 + ":" + count);
                    count++;
                }
                lock.unlock();
            }
        }
    }
}
