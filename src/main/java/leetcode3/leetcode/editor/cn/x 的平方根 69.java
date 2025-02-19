//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
//
// Related Topics数学 | 二分查找 
//
// 👍 1623, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode3.leetcode.editor.cn;

/**
 * 69:x 的平方根
 */
public class x的平方根 69{
public static void main(String[]args){
    Solution solution=new x 的平方根 69().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // liweiwei1419
    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        while (left < right) {
            //注意这一行代码
            long mid = (right + left) / 2 + 1;
            // 大于的话要范围要减1
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                // 小于的话当前值有可能是所需的值
                left = mid;
            }
        }
        return (int)left;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}