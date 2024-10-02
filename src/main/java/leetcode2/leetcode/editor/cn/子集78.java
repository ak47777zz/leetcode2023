//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics位运算 | 数组 | 回溯 
//
// 👍 2368, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode2.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 78:子集
 */
public class 子集78 {
    public static void main(String[] args) {
        Solution solution = new 子集78().new Solution();
        solution.subsets(new int[] {1, 2, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 卡子哥方法
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            List<Integer> path = new ArrayList<>();
            backTracking(nums, 0, path);
            return res;
        }

        /**
         * 回溯就是层层递进，收集完结果后,返回上一层时还原
         * 结果顺序如下：[][1][1,2][1,2,3][1,3][2][2,3][3]
         * @param nums
         * @param startIndex
         * @param path
         */
        public void backTracking(int[] nums, int startIndex, List<Integer> path) {
            res.add(new ArrayList<>(path));
            if (startIndex >= nums.length) {
                return;
            }

            // 通过startIndex控制往后面循序,这样不会重复
            for (int i = startIndex; i < nums.length; i++) {
                path.add(nums[i]);
                backTracking(nums, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}