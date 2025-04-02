package org.example;

public class findPeakInMountainArray {

    public int findPeakInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                // 处于递增部分，峰值在右侧
                left = mid + 1;
            } else {
                // 处于递减部分，峰值在左侧（包含mid）
                right = mid;
            }
        }

        // 当left == right时找到峰值
        return arr[left];
    }

}
