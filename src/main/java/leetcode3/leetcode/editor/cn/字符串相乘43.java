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
// 👍 1400, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode3.leetcode.editor.cn;

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
            if ("0".equals(num1) || "0".equals(num2)) {
                return "0";
            }

            String res = "0";
            // 用nums2的每一位乘nums1
            for (int i = num2.length() - 1; i >= 0; i--) {
                // 保存 num2 第i位数字与 num1 相乘的结果
                StringBuilder sb = new StringBuilder();
                // 补0
                for (int j = 0; j < num2.length() - 1 - i; j++) {
                    sb.append(0);
                }

                int num2value = num2.charAt(i) - '0';
                int carry = 0;

                // 与nums1相乘
                for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                    int num1value = j < 0 ? 0 : num1.charAt(j) - '0';
                    int value = num1value * num2value + carry;
                    sb.append(value % 10);
                    carry = value / 10;
                }
                res = addStrings(res, sb.reverse().toString());

            }
            return res;
        }

        public String addStrings(String num1, String num2) {
            StringBuilder sb = new StringBuilder();
            int i = num1.length() - 1;
            int j = num2.length() - 1;
            int carry = 0;
            while (i >= 0 || j >= 0) {
                int value1 = i >= 0 ? num1.charAt(i) - '0' : 0;
                int value2 = j >= 0 ? num2.charAt(j) - '0' : 0;
                int tmp = value1 + value2 + carry;
                carry = tmp / 10;
                int curValue = tmp % 10;
                sb.insert(0, curValue);
                i--;
                j--;
            }

            if (carry != 0) {
                sb.insert(0, carry);

            }
            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}