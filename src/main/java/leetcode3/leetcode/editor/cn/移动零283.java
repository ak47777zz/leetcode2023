//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics数组 | 双指针 
//
// 👍 2434, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode3.leetcode.editor.cn;

/**
 * 283:移动零
 */
public class 移动零283 {
    public static void main(String[] args) {
        Solution solution = new 移动零283().new Solution();
        solution.moveZeroes(new int[] {0, 1, 0, 3, 12});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 快慢指针，数值交换
        public void moveZeroes(int[] nums) {
            if (nums == null || nums.length == 1) {
                return;
            }
            int slow = 0;
            int fast = 0;
            while (fast < nums.length) {
                if (nums[fast] != 0) {
                    int temp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = temp;
                    slow++;
                }
                fast++;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}