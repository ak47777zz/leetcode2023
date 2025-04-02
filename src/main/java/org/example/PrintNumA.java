package org.example;

public class PrintNumA {

    private static final Object lock = new Object();
    private static volatile int count = 0;

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
                    while (count % 3 != threadNum) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    // 打印
                    System.out.println(threadNum + 1 + ":" + count);
                    count++;
                    lock.notifyAll();
                }
            }
        }
    }

}
