package leetcode6.leetcode.editor.cn;

/**
 * 415:字符串相加
 */
public class 字符串相加415 {
    public static void main(String[] args) {
        Solution solution = new 字符串相加415().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder sb = new StringBuilder();
            int i = num1.length() - 1;
            int j = num2.length() - 1;
            int carry = 0;
            while (i >= 0 || j >= 0 || carry != 0) {
                int value1 = i >= 0 ? num1.charAt(i) - '0' : 0;
                int value2 = j >= 0 ? num2.charAt(j) - '0' : 0;
                int sum = value1 + value2 + carry;
                carry = sum / 10;
                sb.append(sum % 10);
                i--;
                j--;
            }
            return sb.reverse().toString();

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}