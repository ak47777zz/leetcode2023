package leetcode.editor.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Test {

    private final static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        Integer[] nums = new Integer[] {1, 4, 3, 5, 2, 7, 6};
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(nums));
    }

}
