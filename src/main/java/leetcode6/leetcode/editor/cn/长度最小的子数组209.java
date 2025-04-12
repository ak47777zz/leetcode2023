package leetcode6.leetcode.editor.cn;
  
/**
 * 209:长度最小的子数组
 */
public class 长度最小的子数组209 {
    public static void main(String[] args) {
         Solution solution = new 长度最小的子数组209().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum  = 0;
        int min = Integer.MAX_VALUE;
        int left = 0 ;
        for (int right = 0; right < nums.length; right++) {
            sum = sum + nums[right];
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum = sum - nums[left];
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}