package org.print;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock的 conditional通信
 */
public class PrintMethod4 {

    private static ReentrantLock lock = new ReentrantLock();

    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();
    private static Condition condition3 = lock.newCondition();

    private static volatile int count = 0;


    public static void main(String[] args) {
        Thread thread1 = new Thread(new PrintMethod4.Task(0, condition1, condition2));
        Thread thread2 = new Thread(new PrintMethod4.Task(1, condition2, condition3));
        Thread thread3 = new Thread(new PrintMethod4.Task(2, condition3, condition1));
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
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(threadNum + 1);
                count++;
                nextCond.signal();
                lock.unlock();
            }
        }
    }


}
