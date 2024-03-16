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
// 👍 1718, 👎 0 
//
//
//
//

package leetcode.editor.cn;

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
        public int[] dailyTemperatures(int[] temperatures) {
            // 存的是下标
            Stack<Integer> stack = new Stack<>();
            int[] result = new int[temperatures.length];
            for (int i = 0; i < temperatures.length; i++) {
                // 如果当前元素值大于栈顶元素,说明是第一个大于的温度
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    Integer preIndex = stack.pop();
                    result[preIndex] = i - preIndex;
                }
                stack.push(i);
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}