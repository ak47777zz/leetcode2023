//给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
//
// 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。 
//
// 返回一个表示每个字符串片段的长度的列表。 
//
// 
//示例 1：
//
// 
//输入：s = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。 
//
// 示例 2： 
//
// 
//输入：s = "eccbbbbdec"
//输出：[10]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 仅由小写英文字母组成 
// 
//
// Related Topics贪心 | 哈希表 | 双指针 | 字符串 
//
// 👍 1200, 👎 0 
//
//
//
//

package leetcode2.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 763:划分字母区间
 */
public class 划分字母区间763 {
    public static void main(String[] args) {
        Solution solution = new 划分字母区间763().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 卡子哥思路，虽然归类到贪心算法上，但还是一类技巧题
        public List<Integer> partitionLabels(String s) {
            // 1.记录每个字符出现的最远下标是多少
            char[] charArray = s.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < charArray.length; i++) {
                map.put(charArray[i], i);
            }
            // 2.遍历,持续更新遇到字符的最远下标
            List<Integer> res = new ArrayList<>();
            int left = 0;
            int rightMax = 0;
            for (int i = 0; i < charArray.length; i++) {
                // 更新当前最远下标
                rightMax = Math.max(rightMax, map.get(charArray[i]));
                // 已经到达最远下标，则收集这一组
                if (i == rightMax) {
                    res.add(rightMax - left + 1);
                    left = i + 1;
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}