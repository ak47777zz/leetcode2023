package org.print;

/**
 * 使用对象锁,最简单的拿锁无脑判断
 */
public class PrintMethod1 {
    private static Object lock = new Object();

    private static  volatile int count = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task(0));
        Thread thread2 = new Thread(new Task(1));
        Thread thread3 = new Thread(new Task(2));
        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class Task implements Runnable {

        private int threadNum;

        public Task(int threadNum) {
            this.threadNum = threadNum;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (count % 3 == threadNum) {
                        System.out.println(threadNum + 1);
                        count++;
                    }
                }
            }
        }
    }

}
