package leecode20;

import java.util.HashMap;
import java.util.Stack;

public class l20 {
    public static void main(String[] args) {
        // 题目的意思
        // 可能性
//        括号的集合
        boolean valid = isValid("]");
        System.out.println(valid);

        // code
        // review
    }

    private static boolean isValid(String s) {


        HashMap<Character, Character> set = new HashMap<>();
        set.put('}', '{');
        set.put(']', '[');
        set.put(')', '(');

        //前置判断
        if(s.length() > 0 && !set.containsKey(s.charAt(0))) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.containsKey(c)) {
                stack.push(c);
                // else if 需要判断第一个进入栈的元素 如果不在hashmap中  则也是无效的括号
                // 如果栈顶的元素 不等于准备输入栈的元素 则也是无效的括号
            }else if (stack.empty() || !stack.pop().equals(set.get(s.charAt(i)))) {
                return false;
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }
}
