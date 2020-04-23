package leecode2;

import java.util.HashMap;
import java.util.Map;

public class l2 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(abs5(s));
        System.out.println(abs6(s));
    }

    public static int abs(String s) {
        int max = 0;
        int length = s.length();
        if (length == 1) {
            return 1;
        }
        for (int i = 0; i < length; i++) {
            Map map = new HashMap();
            map.put(s.charAt(i), -1);
            for (int j = i + 1; j < length; j++) {
                if (map.containsKey(s.charAt(j))) {
                    max = Math.max(max, j - i);
                    break;
                }
                map.put(s.charAt(j), -1);
                max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }


    public static int abs2(String s) {
        int size, i = 0, j, k, max = 0;
        size = s.length();
        for (j = 0; j < size; j++) {
            for (k = i; k < j; k++)
                if (s.charAt(k) == s.charAt(j)) {
                    i = k + 1;
                    break;
                }
            if (j - i + 1 > max)
                max = j - i + 1;
        }
        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] hash = new int[500];
        int max = 0;
        int i = 0, j = 0;

        while (i < s.length() && j < s.length()) {
            if (hash[s.charAt(j)] == 0) {
                hash[s.charAt(j)] = 1;
                j++;
                max = (j - i) > max ? (j - i) : max;
            } else {
                hash[s.charAt(i)] = 0;
                i++;
            }
        }
        return max;
    }


    /**
     * flag  标志位
     * 当快指针移动到重复的位置时 慢指针向前移动一位 快指针继续向前
     * 如果快指针的值再次重复的字符 满秩阵的flag标志位 继续向前移动一位 一直到结束
     * @param s
     * @return
     */
    public static int abs3(String s) {
        int flag = 0;
        int i = 0;
        int max = 0;
        int[] hash = new int[500];
        while (i < s.length()) {
            if (hash[s.charAt(i)] == 0) {
                hash[s.charAt(i)] = 1;
                i++;
                max = Math.max(max, i - flag);
            } else {
                hash[s.charAt(flag)] = 0;
                flag++;
            }
        }
        return max;
    }

    public static int abs5(String s) {
        int i = 0; // 标志位置
        int max = 0;
        int length = s.length();

        Map<Character, Integer> map = new HashMap<>();

        for (int j = 0; j < length; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            max = Math.max(max, j - i + 1);
            map.put(s.charAt(j), j);
        }
        return max;

    }

    public static int abs6(String s) {
        int flag = 0;
        int max = 0;
        int[] hash = new int[500];
        for (int i = 0; i < s.length(); i++) {
            if (hash[s.charAt(i)] > 0) {
                flag = Math.max(flag, hash[s.charAt(i)]);
            }
            max = Math.max(max, i - flag + 1);
            hash[s.charAt(i)] = i + 1;
        }

        return max;
    }

}
