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
// 👍 2367, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode2.leetcode.editor.cn;

/**
 * 283:移动零
 */
public class 移动零283 {
    public static void main(String[] args) {
        Solution solution = new 移动零283().new Solution();
        solution.moveZeroes(new int[] {1,0});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 快慢指针
        // 把所有非零的数字往前移，省下的位置都填入0
        public void moveZeroes(int[] nums) {
            // 快指针找到下一个非0的数字
            int fast = 0;
            // 快指针找到的数字赋值给慢指针
            int slow = 0;

            while (fast < nums.length) {
                if (nums[fast] != 0) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }

            // slow后面的都置为0
            while (slow < nums.length) {
                nums[slow] = 0;
                slow++;
            }
        }

        public void swap(int[] nums, int a, int b) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}