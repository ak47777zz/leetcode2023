  //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics栈 | 数组 | 双指针 | 动态规划 | 单调栈 
//
// 👍 5144, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package leetcode.editor.cn;

  import java.util.Stack;

  /**
   * 42:接雨水
   */
  public class 接雨水42 {
      public static void main(String[] args) {
           Solution solution = new 接雨水42().new Solution();
          solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          // 使用单调栈,横向计算雨水区间
          // 作者(代码随想录)
    public int trap(int[] height) {
        // 单调栈,存的是数组下标
        Stack<Integer> stack = new Stack<>();

        int sum = 0;

        for (int i = 0; i < height.length; i++) {
            // 如果当前元素大于栈顶,就找到了栈顶元素右侧第一个比它大的元素,开始计算
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // 沟槽底部元素下标
                Integer mid = stack.pop();
                if (!stack.isEmpty()) {
                    // 左边第一个比沟槽大的元素
                    Integer leftBigFirst = stack.peek();
                    // 求面积
                    int high = Math.min(height[leftBigFirst],height[i]) - height[mid];
                    int wide = i - leftBigFirst - 1;
                    sum = sum + high * wide;
                }
            }
            stack.push(i);
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }