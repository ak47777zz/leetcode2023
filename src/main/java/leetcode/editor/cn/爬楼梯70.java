//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
//
// Related Topics记忆化搜索 | 数学 | 动态规划 
//
// 👍 3488, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode.editor.cn;

/**
 * 70:爬楼梯
 */
public class 爬楼梯70 {
    public static void main(String[] args) {
        Solution solution = new 爬楼梯70().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[] map = new int[50];
        // https://blog.csdn.net/Coder_ljw/article/details/134904291
        // 带map优化性能版的递归
        public int climbStairs(int n) {
            if (map[n] != 0) {
                return map[n];
            }
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            int step = climbStairs(n - 1) + climbStairs(n - 2);
            map[n] = step;
            return step;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}