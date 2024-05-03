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
// 👍 1131, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode.editor.cn;

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
        // 贪心算法，作者(代码随想录)
        public List<Integer> partitionLabels(String s) {
            // 记录每个字符的最远下标
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.toCharArray().length; i++) {
                char c = s.charAt(i);
                map.put(c, i);
            }

            List<Integer> res = new ArrayList<>();

            // 记录起始位置
            int left = 0;
            // 遍历到的最大右下标
            int right = 0;
            for (int i = 0; i < s.toCharArray().length; i++) {
                // 不断更新最大右下标
                right = Math.max(right, map.get(s.charAt(i)));
                // 当前下标等于最大右下标时,取得了一个片段
                if (i == right) {
                    res.add(right - left + 1);
                    left = i + 1;
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}