package leetcode6.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 560:和为 K 的子数组
 */
public class 和为 K 的子数组560 {
    public static void main(String[] args) {
         Solution solution = new 和为 K 的子数组560().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int res = 0;
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum = preSum + nums[i];
            int need = preSum - k;
            if (map.containsKey(need)) {
                res = res + map.get(need);
            }
            Integer value = map.getOrDefault(preSum, 0);
            value++;
            map.put(preSum, value);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}