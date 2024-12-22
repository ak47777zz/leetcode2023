//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics链表 | 双指针 
//
// 👍 2994, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode3.leetcode.editor.cn;

import leetcode2.leetcode.editor.cn.ListNode;

/**
 * 19:删除链表的倒数第 N 个结点
 */
public class 删除链表的倒数第 N 个结点19 {
    public static void main(String[] args) {
        Solution solution = new 删除链表的倒数第 N 个结点19 ().new Solution();
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 使用虚拟头节点，避免head被删的情况
            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            // 定义快慢指针
            ListNode fast = dummy;
            ListNode slow = dummy;

            // 快指针移动n个节点
            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }

            // 快慢指针共同移动, 快指针移动到最后一个元素停止
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }

            // slow节点替换
            slow.next = slow.next.next;

            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}