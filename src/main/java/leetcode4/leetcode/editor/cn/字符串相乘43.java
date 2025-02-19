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
// 👍 1401, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode4.leetcode.editor.cn;

/**
 * 43:字符串相乘
 */
public class 字符串相乘43 {
    public static void main(String[] args) {
        Solution solution = new 字符串相乘43().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 123 * 456 = 56088
        //     7 3 8
        //   6 1 5 0
        // 4 9 2 0 0

        public String multiply(String num1, String num2) {
            if ("0".equals(num1) || "0".equals(num2)) {
                return "0";
            }

            // 用num2的每一位与num1相乘
            // 从个位数选择num2
            String res = "0";
            for (int i = num2.length() - 1; i >= 0; i--) {
                StringBuilder sb = new StringBuilder();
                // 补0
                int zeroNum = num2.length() - 1 - i;
                for (int j = 0; j < zeroNum; j++) {
                    sb.append("0");
                }

                // 开始相乘
                int num2Value = num2.charAt(i) - '0';
                int carry = 0;
                int j = num1.length() - 1;
                while (j >= 0 || carry != 0) {
                    int num1Value = j >= 0 ? num1.charAt(j) - '0' : 0;
                    int value = num1Value * num2Value + carry;
                    sb.append(value % 10);
                    carry = value / 10;
                    j--;
                }
                res = addString(res, sb.reverse().toString());
            }
            return res;
        }

        private String addString(String num1, String num2) {
            StringBuilder sb = new StringBuilder();
            int i = num1.length() - 1;
            int j = num2.length() - 1;
            int carry = 0;
            while (i >= 0 || j >= 0 || carry != 0) {
                int value1 = i >= 0 ? num1.charAt(i) - '0' : 0;
                int value2 = j >= 0 ? num2.charAt(j) - '0' : 0;
                int value = value1 + value2 + carry;
                sb.append(value % 10);
                carry = value / 10;
                i--;
                j--;
            }
            return sb.reverse().toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}