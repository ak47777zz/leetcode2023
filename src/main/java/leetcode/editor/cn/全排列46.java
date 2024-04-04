  //给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 2858, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.List;

  /**
   * 46:全排列
   */
  public class 全排列46 {
      public static void main(String[] args) {
          Solution solution = new 全排列46().new Solution();
      }

      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {

          // 回溯
          public List<List<Integer>> permute(int[] nums) {
              int length = nums.length;
              List<List<Integer>> result = new ArrayList<>();
              if (length == 0) {
                  return result;
              }

              boolean[] used = new boolean[length];
              List<Integer> path = new ArrayList<>();
              dfs(nums, 0, length, path, result, used);
              return result;
          }

          private void dfs(int[] nums, int depth, int length, List<Integer> path, List<List<Integer>> result, boolean[] used) {
              if (depth == length) {
                  result.add(new ArrayList<>(path));
                  return;
              }
              //  在非叶子结点处，产生不同的分支, 选择一个还未使用的数
              for (int i = 0; i < length; i++) {
                  if (!used[i]) {
                      used[i] = true;
                      path.add(nums[i]);
                      dfs(nums, depth + 1, length, path, result, used);
                      // 返回需要还原状态
                      // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                      used[i] = false;
                      path.remove(path.size() - 1);
                  }
              }
          }
      }
      //leetcode submit region end(Prohibit modification and deletion)

  }