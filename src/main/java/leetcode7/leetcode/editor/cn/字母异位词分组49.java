//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics数组 | 哈希表 | 字符串 | 排序 
//
// 👍 2291, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode7.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49:字母异位词分组
 */
public class 字母异位词分组49 {
    public static void main(String[] args) {
         Solution solution = new 字母异位词分组49().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String normWord = new String(charArray);
            List<String> list = map.getOrDefault(normWord, new ArrayList<>());
            list.add(str);
            map.put(normWord, list);
        }
        return new ArrayList<>(map.values());
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}