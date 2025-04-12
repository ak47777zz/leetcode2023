package leetcode6.leetcode.editor.cn;

import java.util.Stack;

/**
 * 394:字符串解码
 */
public class 字符串解码394 {
    public static void main(String[] args) {
         Solution solution = new 字符串解码394().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            // 字母或左括号
            if (Character.isLetter(c) || '[' == c) {
                stack.push(String.valueOf(c));
                i++;
            }
            // 数字
            else if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                while (Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }
                stack.push(sb.toString());
            } else {
                // 右括号
                StringBuilder sb = new StringBuilder();
                while (!stack.peek().equals("[")){
                    sb.insert(0, stack.pop());
                }

                // 弹出左括号
                stack.pop();

                // 栈顶为重复次数
                int count = Integer.parseInt(stack.pop());

                // 构建重复字符串
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < count; j++) {
                    str.append(sb.toString());
                }
                stack.push(str.toString());
                i++;
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}