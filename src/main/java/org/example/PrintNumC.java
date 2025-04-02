package org.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintNumC {

    private final static ReentrantLock lock = new ReentrantLock();

    private static volatile int count = 0;

    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();
    private static Condition condition3 = lock.newCondition();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task(0, condition1, condition2));
        Thread thread2 = new Thread(new Task(1, condition2, condition3));
        Thread thread3 = new Thread(new Task(2, condition3, condition1));
        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class Task implements Runnable {
        private int threadNum;
        private Condition curCond;
        private Condition nextCond;

        public Task(int threadNum, Condition curCond, Condition nextCond) {
            this.threadNum = threadNum;
            this.curCond = curCond;
            this.nextCond = nextCond;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                while (count % 3 != threadNum) {
                    try {
                        curCond.await();
                        if (count == 100) {
                            nextCond.signal();
                            lock.unlock();
                            return;
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(threadNum + 1 + ":" + count);
                count++;
                nextCond.signal();
                lock.unlock();
            }
        }
    }

}
