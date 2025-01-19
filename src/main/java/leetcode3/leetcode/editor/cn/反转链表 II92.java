//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics链表 
//
// 👍 1905, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode3.leetcode.editor.cn;

import leetcode2.leetcode.editor.cn.ListNode;

/**
 * 92:反转链表 II
 */
public class 反转链表 II92 {
    public static void main(String[] args) {
        Solution solution = new 反转链表 II92().new Solution();
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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            // bad case
            if (head == null || head.next == null) {
                return head;
            }

            ListNode dummy = new ListNode(-1, head);
            // 找到待反转链表头的前一个元素
            ListNode pre = dummy;
            for (int i = 0; i < left - 1; i++) {
                pre = pre.next;
            }

            // 找到待反转链表的最后一个元素
            ListNode tail = dummy;
            for (int i = 0; i < right; i++) {
                tail = tail.next;
            }

            // 记录4个点位
            ListNode newHead = pre.next;
            ListNode tailNext = tail.next;

            // 切断子链表
            pre.next = null;
            tail.next = null;

            // 反转子链表
            reserve(newHead);

            // 拼接
            pre.next = tail;
            newHead.next = tailNext;

            return dummy.next;
        }

        private void reserve(ListNode head) {
            ListNode pre = null , cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

