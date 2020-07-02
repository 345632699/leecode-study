package leetcode23;

import java.util.HashSet;

public class l23 {
    public static void main(String[] args) {
        int[] integers = new int[]{1, 2, 3, 4, 6, 7};
        useSet(integers, 9);

    }

    public static void useSet(int[] integers, int k) {
        HashSet<Integer> integers1 = new HashSet<>();
        for (int i = 0; i < integers.length; i++) {
            if (integers1.contains(k - integers[i])){
                System.out.println(integers[i] + ":"+ (k-integers[i]));
            }else {
                integers1.add(integers[i]);
            }
        }
    }

    public static void  hardCode(int[] integers, int k) {
        for (int i = 0; i < integers.length; i++) {
            for (int j = i + 1; j < integers.length; j++) {
                if (integers[i] + integers[j] == k) {
                    System.out.println(integers[i] + ":" + integers[j]);
                }
            }
        }
    }
}
