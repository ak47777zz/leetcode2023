package org.example;

public class PrintNumbersInThreads {
    // 用于控制当前应该打印的数字
    private static int currentNumber = 1;
    // 用于线程间的同步
    private static final Object lock = new Object();

    public static void main(String[] args) {
        // 创建三个线程
        Thread thread1 = new Thread(new PrintNumberTask(1));
        Thread thread2 = new Thread(new PrintNumberTask(2));
        Thread thread3 = new Thread(new PrintNumberTask(3));

        // 启动三个线程
        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class PrintNumberTask implements Runnable {
        private final int number;

        public PrintNumberTask(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    // 当前应该打印的数字不是本线程要打印的数字时，线程等待
                    while (currentNumber != number) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    // 打印当前数字
                    System.out.print(number);
                    // 更新当前应该打印的数字
                    currentNumber = (currentNumber % 3) + 1;
                    // 唤醒其他等待的线程
                    lock.notifyAll();
                }
            }
        }
    }
}