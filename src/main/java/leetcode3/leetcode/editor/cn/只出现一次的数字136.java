  //给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。 
//
// 
// 
// 
// 
// 
//
// 示例 1 ： 
//
// 
// 输入：nums = [2,2,1] 
// 
//
// 输出：1 
//
// 示例 2 ： 
//
// 
// 输入：nums = [4,1,2,1,2] 
// 
//
// 输出：4 
//
// 示例 3 ： 
//
// 
// 输入：nums = [1] 
// 
//
// 输出：1 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -3 * 10⁴ <= nums[i] <= 3 * 10⁴ 
// 除了某个元素只出现一次以外，其余每个元素均出现两次。 
// 
//
// Related Topics位运算 | 数组 
//
// 👍 3247, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package leetcode3.leetcode.editor.cn;
  
  /**
   * 136:只出现一次的数字
   */
  public class 只出现一次的数字136 {
      public static void main(String[] args) {
           Solution solution = new 只出现一次的数字136().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        // 利用异或运算的特性,两个相同的数字异或结果为0
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }