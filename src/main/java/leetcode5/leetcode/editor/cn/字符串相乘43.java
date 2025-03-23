//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
//
// Related Topics数学 | 字符串 | 模拟 
//
// 👍 1411, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode5.leetcode.editor.cn;

import java.util.Objects;

/**
 * 43:字符串相乘
 */
public class 字符串相乘43 {
    public static void main(String[] args) {
        Solution solution = new 字符串相乘43().new Solution();
        solution.multiply("2", "3");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //     7 3 8
        //   6 1 5 0
        // 4 9 2 0 0
        // 5 6 0 8 8
        public String multiply(String num1, String num2) {
            if (Objects.equals(num1, "0") || Objects.equals(num2, "0")) {
                return "0";
            }
            String res = "0";
            // 用num2的每一位乘num1
            for (int i = num2.length() - 1; i >= 0; i--) {
                StringBuilder sb = new StringBuilder();
                // 补 0
                for (int j = 0; j < num2.length() - i - 1; j++) {
                    sb.append("0");
                }

                int value2 = num2.charAt(i) - '0';
                int index = num1.length() - 1;
                int carry = 0;
                while (index >= 0 || carry != 0) {
                    int value1 = index >= 0 ? num1.charAt(index) - '0' : 0;
                    int result = value1 * value2 + carry;
                    carry = result / 10;
                    sb.append(result % 10);
                    index--;
                }
                res = add(res, sb.reverse().toString());
            }
            return res;
        }

        private String add(String num1, String num2) {
            StringBuilder sb = new StringBuilder();
            int l1 = num1.length() - 1;
            int l2 = num2.length() - 1;
            int carry = 0;
            while (l1 >= 0 || l2 >= 0 || carry != 0) {
                int value1 = l1 >= 0 ? num1.charAt(l1) - '0' : 0;
                int value2 = l2 >= 0 ? num2.charAt(l2) - '0' : 0;
                int sum = value1 + value2 + carry;
                carry = sum / 10;
                sb.append(sum % 10);
                l1 --;
                l2--;
            }
            return sb.reverse().toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}