package org.example;

public class PrintNums {

    private static Object lock = new Object();
    private static int currentNumber = 1;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new PrintRunnable(1));
        Thread thread2 = new Thread(new PrintRunnable(2));
        Thread thread3 = new Thread(new PrintRunnable(3));
        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class PrintRunnable implements Runnable {
        private final int number;

        public PrintRunnable(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (number != currentNumber) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print(number);
                    currentNumber = (number % 3) + 1;
                    lock.notifyAll();
                }
            }
        }
    }

}
