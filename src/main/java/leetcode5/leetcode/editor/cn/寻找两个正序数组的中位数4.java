  //给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics数组 | 二分查找 | 分治 
//
// 👍 7460, 👎 0 
//
//
//
//

  
  package leetcode5.leetcode.editor.cn;

  /**
   * 4:寻找两个正序数组的中位数
   */
  public class 寻找两个正序数组的中位数4 {
      public static void main(String[] args) {
           Solution solution = new 寻找两个正序数组的中位数4().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] arr = new int[n + m];
        int idx = 0;
        int i = 0;
        int j = 0;
        while (i < n || j < m) {
            if (i >= n) {
                arr[idx] = nums2[j];
                j++;
            } else if (j >= m) {
                arr[idx] = nums1[i];
                i++;
            } else {
                if (nums1[i] < nums2[j]) {
                    arr[idx] = nums1[i];
                    i++;
                } else {
                    arr[idx] = nums2[j];
                    j++;
                }
            }
            idx++;
        }




        // 奇数
        int left = 0;
        int right = arr.length - 1;
        if (arr.length % 2 == 1) {
            return arr[(left + right) / 2];
        }

        int midLeft = arr[(left + right) / 2];
        int midRight = arr[(left + right) / 2 + 1];
        return (midLeft + midRight) / 2.0;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }