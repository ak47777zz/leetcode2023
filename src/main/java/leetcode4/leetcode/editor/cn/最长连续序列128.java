  //给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics并查集 | 数组 | 哈希表 
//
// 👍 2374, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package leetcode4.leetcode.editor.cn;

  import java.util.HashSet;
  import java.util.Set;

  /**
   * 128:最长连续序列
   */
  public class 最长连续序列128 {
      public static void main(String[] args) {
           Solution solution = new 最长连续序列128().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        // 1.通过hash存储数组
        HashSet<Integer> hash = new HashSet<>();
        for (int num : nums) {
            hash.add(num);
        }

        // 2.找到每组首位，统计这组的长度
        int max = 0;
        for (int num : hash) {
            // 如果hash中存在比当前数字小1的数，说明这个数不是这组连续数组的首位
            if (hash.contains(num - 1)) {
                continue;
            }
            int length = 1;
            while (hash.contains(++num)) {
                length++;
            }
            max = Math.max(max, length);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }