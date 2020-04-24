package leecode3;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class l3 {
    public static void main(String[] args) {
        String s = "a";
        String t = "a";
        String s1 = minWindow(s, t);
        String s2 = minWindo1w(s, t);
        String s3 = test(s, t);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }


    public static String minWindow(String s, String t) {
        if (s == "" || t == "") {
            return "";
        }
        int right = 0, left = 0, count = 0;
        int minLeft = 0;
        int minRight = 0;
        int lengthOfMin = -1;
        boolean flag = false;
        Map<Character, Integer> windowsCount = new HashMap<>();
        // 遍历T字符串
        Map<Character, Integer> dictT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count1 = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count1 + 1);
        }
        // 遍历S字符窜
        while (right < s.length()) {
            char c = s.charAt(right);
            // 窗口包含元素数量+1
            windowsCount.put(c, windowsCount.getOrDefault(c, 0) + 1);
            // 如果目标的dict中包含了该元素 且 匹配到相同的数量 则统计+1
            if (dictT.containsKey(c) && windowsCount.get(c).intValue() == dictT.get(c).intValue()) {
                count++;
            }

            // 当包含了所有的元素后 left指针 不断右移 缩小满足的窗口界限
            while (right >= left && count == dictT.size()) {
                c = s.charAt(left);
                flag = true;

                // 判断若是否是最小的子窜 或者 为空窜执行
                if (right - left + 1 < lengthOfMin || lengthOfMin == -1) {
                    lengthOfMin = right - left + 1;
                    minLeft = left;
                    minRight = right;

                }

                // 指针右移后 当前元素在窗口的包含-1
                windowsCount.put(c, windowsCount.get(c) - 1);
                // left 向右移动前 窗体是否包含了该元素 如果包含 则检查 窗体减去计数1后 与实际目标条件 dictT需求的个数比较 若小于 则 统计计数减一
                if (dictT.containsKey(c) && windowsCount.get(c).intValue() < dictT.get(c).intValue()) {
                    count--;
                }

                left++;
            }

            right++;
        }
        // 此处判断为若只有一个元素的时候 s 为"a" t为"a"
        if (!flag) {
            return "";
        }
        return s.substring(minLeft, minRight + 1);
    }

    public static String minWindo1w(String s, String t) {
        if (s == "" || t == "") {
            return "";
        }
        int left = 0, right = 0, minLength = s.length();
        int minLeft = 0;
        int minRight = 0;
        HashMap<Character, Integer> hashMap = new HashMap();
        // cnt 用来统计目标字符串的出现次数
        int cnt = 0;
        boolean flag = false;

        // 遍历字符串t 赋予相应的数值 每一次 +1
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        // 遍历S字符串 right 指针右移
        while (right < s.length()) {
            char c = s.charAt(right);

            if (hashMap.containsKey(c)) {

                // 当字符串出现足够次数后  比如 AAABB  目标字符串AAB 时  检测到第三个A的时候 计数值为-1
                // 但是 cnt不再增加 因为已出现足够的A再出现也不会满足条件
                if (hashMap.get(c).intValue() > 0) {
                    cnt++;
                }
                // 当目标字符窜 每出现一次 使用计数需要减1 原本根据字符窜需要个数 设置正值
                hashMap.put(c, hashMap.get(c) - 1);
            }

            while (cnt == t.length()) {
                char c1 = s.charAt(left);
                flag = true;
                if (right - left + 1 <= minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                    minRight = right;
                }
                // 不管是否总计数减1 当前该char的使用计数需要+1
                if (hashMap.containsKey(c1)) {
                    if (hashMap.get(c1) + 1 > 0) {
                        cnt--;
                    }
                    // 移除1后 目标值的 原数值都需要+1
                    hashMap.put(c1, hashMap.get(c1) + 1);
                }
                left++;
            }
            right++;
        }
        if (!flag) {
            return "";
        }
        return s.substring(minLeft, minRight + 1);
    }


    // 暴力循环
    public static String test(String s, String t) {
        if (s == "" || t == "" || s.length() < t.length()) {
            return "";
        }
        if (s.equals(t)) {
            return t;
        }
        int minLeft = 0;
        int minRight = 0;
        int mintLenth = -1;
        Map<Character, Integer> dictT = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ci1 = s.charAt(i);
            for (int i1 = 0; i1 < t.length(); i1++) {
                dictT.put(t.charAt(i1), dictT.getOrDefault(t.charAt(i1), 0) + 1);
            }
            count = 0;
            if (dictT.containsKey(ci1)) {
                if (dictT.get(ci1) > 0) {
                    count++;
                }
                dictT.put(ci1, dictT.get(ci1) - 1);
            }
            for (int j = i + 1; j < s.length(); j++) {
                char c = s.charAt(j);
                if (dictT.containsKey(c)) {
                    if (dictT.get(c) > 0) {
                        count++;
                    }
                    dictT.put(c, dictT.get(c) - 1);
                }

                if (count == t.length()) {
                    if (t.length() == 1) {
                        return t;
                    }
                    if (mintLenth > j - i + 1 || mintLenth < 0) {
                        mintLenth = j - i + 1;
                        minLeft = i;
                        minRight = j;
                    }
                    break;
                }
            }
            for (int i1 = 0; i1 < t.length(); i1++) {
                dictT.put(t.charAt(i1), 0);
            }
        }
        if (mintLenth < 0) {
            return "";
        }
        return s.substring(minLeft, minRight + 1);

    }
}
