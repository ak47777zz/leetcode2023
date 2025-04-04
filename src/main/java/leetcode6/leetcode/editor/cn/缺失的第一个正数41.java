package leetcode6.leetcode.editor.cn;

/**
 * 41:缺失的第一个正数
 */
public class 缺失的第一个正数41 {
    public static void main(String[] args) {
        Solution solution = new 缺失的第一个正数41().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] >= 1 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                    swap(nums, i, nums[i] - 1);
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] - 1 != i) {
                    return i + 1;
                }
            }
            return nums.length + 1;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}