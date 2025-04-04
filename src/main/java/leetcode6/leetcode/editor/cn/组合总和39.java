package leetcode6.leetcode.editor.cn;

import java.util.ArrayList;
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
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backTracking(res, candidates, 0, new ArrayList<>(), target);
        return res;
    }

    private void backTracking(List<List<Integer>> res, int[] candidates , int index, List<Integer> path , int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            backTracking(res, candidates, i, path, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}