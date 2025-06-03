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
// 👍 1431, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode7.leetcode.editor.cn;

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
        public String multiply(String num1, String num2) {
            if (Objects.equals(num1, "0") || Objects.equals(num2, "0")) {
                return "0";
            }

            String res = "0";
            // num2从右往左乘num1
            for (int i = num2.length() - 1; i >= 0; i--) {
                StringBuilder sb = new StringBuilder();
                // 补 0
                for (int j = 0; j < num2.length() - 1 - i; j++) {
                    sb.append("0");
                }
                // 相乘
                int num2Val = num2.charAt(i) - '0';
                int carry = 0;
                int num1Index = num1.length() - 1;
                while (num1Index >= 0 || carry != 0) {
                    int num1Val = num1Index >= 0 ? num1.charAt(num1Index) - '0' : 0;
                    int value = num1Val * num2Val + carry;
                    carry = value / 10;
                    sb.append(value % 10);
                    num1Index--;
                }
                res = add(res, sb.reverse().toString());
            }
            return res;
        }

        private String add(String a, String b) {
            StringBuilder res = new StringBuilder();
            int i = a.length() - 1;
            int j = b.length() - 1;
            int carry = 0;
            while (i >= 0 || j >= 0 || carry != 0) {
                int val1 = i >= 0 ? a.charAt(i) - '0' : 0;
                int val2 = j >= 0 ? b.charAt(j) - '0' : 0;
                int value = val1 + val2 + carry;
                carry = value / 10;
                res.append(value % 10);
                i--;
                j--;
            }
            return res.reverse().toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}