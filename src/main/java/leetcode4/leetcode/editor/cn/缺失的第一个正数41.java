//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 请你实现时间复杂度为
//O(n) 并且只使用常数级别额外空间的解决方案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
//解释：范围 [1,2] 中的数字都在数组中。 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
//解释：1 在数组中，但 2 没有。 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
//解释：最小的正数 1 没有出现。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// Related Topics数组 | 哈希表 
//
// 👍 2308, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode4.leetcode.editor.cn;

/**
 * 41:缺失的第一个正数
 */
public class 缺失的第一个正数41 {
    public static void main(String[] args) {
        Solution solution = new 缺失的第一个正数41().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 作者liweiwei
        // https://www.bilibili.com/video/BV167411N7vd/?spm_id_from=333.337.search-card.all.click&vd_source=59cabb2bef774a4a1049ba1357ebc931
        public int firstMissingPositive(int[] nums) {
            int length = nums.length;
            for (int i = 0; i < length; i++) {
                while (nums[i] >= 1 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                    swap(nums, i, nums[i] - 1);
                }
            }
            for (int i = 0; i < length; i++) {
                if (i + 1 != nums[i]) {
                    return i + 1;
                }
            }
            return length + 1;
        }

        private void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}