//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics栈 | 递归 | 链表 | 双指针 
//
// 👍 1929, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode2.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

import leetcode2.leetcode.editor.cn.反转链表206.ListNode;

/**
 * 234:回文链表
 */
public class 回文链表234 {
    public static void main(String[] args) {
        Solution solution = new 回文链表234().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            // 使用额外数组进行回文判断
            List<Integer> list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }

            int left = 0;
            int right = list.size() - 1;
            while (left < right) {
                if (list.get(left) != list.get(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}