package leetcode6.leetcode.editor.cn;
  
/**
 * 88:合并两个有序数组
 */
public class 合并两个有序数组88 {
    public static void main(String[] args) {
         Solution solution = new 合并两个有序数组88().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int i = 0;
        int j = 0;
        while (i < m || j < n) {
            if (i >= m) {
                res[i + j] = nums2[j];
                j++;
            } else if (j >= n) {
                res[i + j] = nums1[i];
                i++;
            } else {
                if (nums1[i] < nums2[j]) {
                    res[i + j] = nums1[i];
                    i++;
                } else {
                    res[i + j] = nums2[j];
                    j++;
                }
            }
        }

        for (int k = 0; k < res.length; k++) {
            nums1[k] = res[k];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}