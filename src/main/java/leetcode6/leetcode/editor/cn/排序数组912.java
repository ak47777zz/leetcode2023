package leetcode6.leetcode.editor.cn;

/**
 * 912:排序数组
 */
public class 排序数组912 {
    public static void main(String[] args) {
        Solution solution = new 排序数组912().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            sortArray(nums, 0, nums.length - 1);
            return nums;
        }

        private void sortArray(int[] nums, int left, int right) {
            if (left >= right) {
                return;
            }
            int pivotIndex = pivotIndex(nums, left, right);
            sortArray(nums, left, pivotIndex - 1);
            sortArray(nums, pivotIndex + 1, right);
        }

        private int pivotIndex(int[] nums, int left, int right) {
            int pivotValue = nums[left];

            int i = left;
            for (int j = left + 1; j <= right; j++) {
                if (nums[j] <= pivotValue) {
                    i++;
                    swap(nums, i, j);
                }
            }
            // 把最左边的元素交换过去
            swap(nums, left, i);
            return i;
        }

        private void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}