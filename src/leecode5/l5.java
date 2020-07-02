package leecode5;

public class l5 {
    public static void main(String[] args) {
        String s = "abcda";

        String abs = abs(s);
        String s1 = longestPalindrome(s);
        System.out.println(abs);
        System.out.println(s1);
    }

    public static String abs(String s) {
        int max = 0;
        int maxLeft = 0;
        int maxRight = 0;
        if(s.equals("")) {
            return "";
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    String substring = s.substring(i, j + 1);
                   if (!isP(substring)) {
                       break;
                   }
                    if (j - i + 1 > max) {
                        max = Math.max(j - i + 1, max);
                        maxLeft = i;
                        maxRight = j;
                    }
                }
            }
        }
        return s.substring(maxLeft, maxRight + 1);
    }
    public static boolean isP(String s) {
        for (int k = 0; k < s.length() / 2; k++) {
            if (s.charAt(k) != s.charAt(s.length() - k - 1)){
                return false;
            }
        }
        return true;
    }
    public static String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        return ans;
    }
    public static boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
