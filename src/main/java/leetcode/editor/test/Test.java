package leetcode.editor.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

public class Test {

    private final static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(list);

    }

}
