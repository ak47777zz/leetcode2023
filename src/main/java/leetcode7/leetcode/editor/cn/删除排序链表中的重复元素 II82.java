//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics链表 | 双指针 
//
// 👍 1372, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode7.leetcode.editor.cn;

import leetcode2.leetcode.editor.cn.ListNode;

/**
 * 82:删除排序链表中的重复元素 II
 */
public class 删除排序链表中的重复元素 II82 {
    public static void main(String[] args) {
        Solution solution = new 删除排序链表中的重复元素 II82().new Solution();
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
        public ListNode deleteDuplicates(ListNode head) {
            // 兼容头节点被删除的情况
            ListNode dummy = new ListNode(-1, head);
            ListNode cur = dummy;
            while (cur.next != null && cur.next.next != null) {
                if (cur.next.val != cur.next.next.val) {
                    cur = cur.next;
                } else {
                    int temp = cur.next.val;
                    while (cur.next != null && cur.next.val == temp) {
                        cur.next = cur.next.next;
                    }
                }
            }
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}