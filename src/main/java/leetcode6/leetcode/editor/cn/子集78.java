package leetcode6.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 78:子集
 */
public class 子集78 {
    public static void main(String[] args) {
        Solution solution = new 子集78().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            bachTracking(res, new ArrayList<>(), nums, 0);
            return res;
        }

        private void bachTracking(List<List<Integer>> res, List<Integer> path, int[] nums, int index) {
            res.add(new ArrayList<>(path));
            for (int i = index; i < nums.length; i++) {
                path.add(nums[i]);
                bachTracking(res, path, nums, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}