//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现
//在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
//
// Related Topics栈 | 数组 | 单调栈 
//
// 👍 1834, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode2.leetcode.editor.cn;

import java.util.Stack;

/**
 * 739:每日温度
 */
public class 每日温度739 {
    public static void main(String[] args) {
        Solution solution = new 每日温度739().new Solution();
        solution.dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 当求左边或右边第一个最大或最小值时，使用单调栈
        public int[] dailyTemperatures(int[] temperatures) {
            int[] res = new int[temperatures.length];
            // 这里存的是下标
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < temperatures.length; i++) {
                // 当前元素大于栈顶元素,说明是第一个大于栈顶元素的值
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    int preIndex = stack.pop();
                    res[preIndex] = i - preIndex;
                }
                stack.push(i);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}