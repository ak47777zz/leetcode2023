package leetcode6.leetcode.editor.cn;

/**
 * 162:寻找峰值
 */
public class 寻找峰值162 {
    public static void main(String[] args) {
        Solution solution = new 寻找峰值162().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPeakElement(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                boolean flag = true;
                if (i >= 1) {
                    if (nums[i] <= nums[i - 1]) {
                        flag = false;
                    }
                }
                if (i < nums.length - 1) {
                    if (nums[i] <= nums[i + 1]) {
                        flag = false;
                    }
                }
                if (flag) {
                    return i;
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}