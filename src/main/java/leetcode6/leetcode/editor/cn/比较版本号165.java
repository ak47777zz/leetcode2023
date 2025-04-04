package leetcode6.leetcode.editor.cn;

/**
 * 165:比较版本号
 */
public class 比较版本号165 {
    public static void main(String[] args) {
        Solution solution = new 比较版本号165().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int compareVersion(String version1, String version2) {

            String[] v1 = version1.split("\\.");
            String[] v2 = version2.split("\\.");

            int i = 0;
            int j = 0;
            while (i < v1.length || j < v2.length) {
                int a = 0;
                int b = 0;
                if (i < v1.length) {
                    a = Integer.parseInt(v1[i]);
                }
                if (j < v2.length) {
                    b = Integer.parseInt(v2[j]);
                }
                if (a < b) {
                    return -1;
                }
                if (a > b) {
                    return 1;
                }
                i++;
                j++;
            }
            return 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}