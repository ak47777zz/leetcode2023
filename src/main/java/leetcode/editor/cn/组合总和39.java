//给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的
// 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。 
//
// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
//
// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入：candidates = [2,3,6,7], target = 7
//输出：[[2,2,3],[7]]
//解释：
//2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
//7 也是一个候选， 7 = 7 。
//仅有这两种组合。 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 2 <= candidates[i] <= 40 
// candidates 的所有元素 互不相同 
// 1 <= target <= 40 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 2754, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39:组合总和
 */
public class 组合总和39 {
    public static void main(String[] args) {
        Solution solution = new 组合总和39().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 回溯,挺复杂的，参考K神的答案
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<Integer> state = new ArrayList<>();
            int start = 0;
            List<List<Integer>> res = new ArrayList<>();
            backTrack(state, candidates, target, start, res);
            return res;
        }

        private void backTrack(List<Integer> state, int[] candidates, int target, int start, List<List<Integer>> res) {
            // target等于0时，满足条件
            if (target == 0) {
                res.add(new ArrayList<>(state));
                return;
            }

            // 第二层剪枝,从start层开始遍历，避免生产重复子集
            for (int i = start; i < candidates.length; i++) {
                // 剪枝一：若子集和超过 target ，则直接结束循环
                // 这是因为数组已排序，后边元素更大，子集和一定超过 target
                if (target - candidates[i] < 0) {
                    break;
                }

                // 尝试：做出选择，更新 target, start
                state.add(candidates[i]);
                // 进行下一轮选择
                backTrack(state, candidates, target - candidates[i], i, res);
                // 回撤选择
                state.remove(state.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}