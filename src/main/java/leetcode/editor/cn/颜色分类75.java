  //给定一个包含红色、白色和蓝色、共 n 个元素的数组
// nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库内置的 sort 函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
//
// Related Topics数组 | 双指针 | 排序 
//
// 👍 1753, 👎 0 
//
//
//
//

  
  package leetcode.editor.cn;
  
  /**
   * 75:颜色分类
   */
  public class 颜色分类75 {
      public static void main(String[] args) {
           Solution solution = new 颜色分类75().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public void sortColors(int[] nums) {
        // 使用两次循环移动
        int length = nums.length;
        int head = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                int temp = nums[head];
                nums[head] = 0;
                nums[i] = temp;
                head++;
            }
        }
        for (int i = head; i < length; i++) {
            if (nums[i] == 1) {
                int temp = nums[head];
                nums[head] = 1;
                nums[i] = temp;
                head++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }