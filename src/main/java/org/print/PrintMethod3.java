package org.print;

/**
 * 使用对象的 wait和 notifyAll
 */
public class PrintMethod3 {

    private static Object lock = new Object();

    private static volatile int count = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new PrintMethod1.Task(0));
        Thread thread2 = new Thread(new PrintMethod1.Task(1));
        Thread thread3 = new Thread(new PrintMethod1.Task(2));
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
                        // 当前不需要自己打印，则等待，并释放锁
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    // 需要自己打印,打印完唤醒其他 2 个线程
                    System.out.println(threadNum + 1);
                    count++;
                    lock.notifyAll();
                }
            }
        }
    }
}
