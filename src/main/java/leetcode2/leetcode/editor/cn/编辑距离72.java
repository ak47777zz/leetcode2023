//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
//
// Related Topics字符串 | 动态规划 
//
// 👍 3532, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode2.leetcode.editor.cn;

/**
 * 72:编辑距离
 */
public class 编辑距离72 {
    public static void main(String[] args) {
        Solution solution = new 编辑距离72().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // dp[i][j] = 以i-1为结尾的word1 和 以j-1为结尾的word2的最少操作次数
        public int minDistance(String word1, String word2) {
            // 1. dp数组定义
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];

            // 2. dp数组初始化

            // 初始化第一列dp[i,0] , 这时j-1 = -1 ,-1为空串, 问题转化为i减几次为空串
            for (int i = 0; i <= word1.length() ; i++) {
                dp[i][0] = i;
            }

            // 初始化第一行dp[0,j], 这时 i-1 = -1 ,-1为空串,问题转化为j减几次为空串
            for (int j = 0; j <= word2.length() ; j++) {
                dp[0][j] = j;
            }

            // 3. dp数组遍历
            for (int i = 1; i <= word1.length() ; i++) {
                for (int j = 1; j <= word2.length() ; j++) {
                    // 字符相同无需操作，结果等于之前
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        // 不相等的情况下
                        // 1.删除word1当前元素
                        // 2.删除word2当前元素 等价于增 (word2删除等价于word1增加)
                        // 3.改元素
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                }
            }

            return dp[word1.length()][word2.length()];

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}