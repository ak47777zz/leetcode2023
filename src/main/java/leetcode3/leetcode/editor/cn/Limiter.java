package leetcode3.leetcode.editor.cn;

import java.util.concurrent.atomic.AtomicLong;

public class Limiter {

    // 窗口时间大小
    private final long windowSize;

    // 窗口时限内最大请求量
    private final long maxRequest;

    // 当前窗口的开始时间
    private final AtomicLong windowStart;

    // 当前窗口的已请求量
    private final AtomicLong count;

    public Limiter(long windowSize, long maxRequest) {
        this.windowSize = windowSize;
        this.maxRequest = maxRequest;
        windowStart = new AtomicLong(System.currentTimeMillis());
        count = new AtomicLong(0);
    }

    public boolean allowRequest() {
        long currentTime = System.currentTimeMillis();
        long windowStartTime = windowStart.get();

        // 如果超出窗口，更新窗口时间和计数器
        if (currentTime - windowStartTime > windowSize) {
            windowStart.set(currentTime);
            count.set(0);
        }

        return count.incrementAndGet() <= maxRequest;
    }

    public static void main(String[] args) throws InterruptedException {
        // 示例：每秒最多处理5个请求
        Limiter limiter = new Limiter(1000, 5);

        // 模拟20个请求，每隔100ms发送一个
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.println("Request " + (i+1) +
                                   " allowed: " + limiter.allowRequest() +
                                   " | Counter: " + limiter.count.get());
        }
    }
}
