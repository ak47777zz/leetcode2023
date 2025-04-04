package leetcode6.leetcode.editor.cn;
  
/**
 * 69:x 的平方根 
 */
public class x 的平方根 69 {
    public static void main(String[] args) {
         Solution solution = new x 的平方根 69().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        while (left < right) {
            long mid = (left + right) / 2 + 1;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int)left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}