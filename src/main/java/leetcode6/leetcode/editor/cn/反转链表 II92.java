package leetcode6.leetcode.editor.cn;

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
            ListNode dummy = new ListNode(-1, head);
            // 找到待反转头节点的前一个节点

            ListNode headPre = dummy;
            for (int i = 1; i < left; i++) {
                headPre = headPre.next;
            }

            ListNode tail = dummy;
            for (int i = 0; i < right; i++) {
                tail = tail.next;
            }

            ListNode newHead = headPre.next;
            ListNode tailNext = tail.next;
            headPre.next = null;
            tail.next = null;

            reserve(newHead);

            headPre.next = tail;
            newHead.next = tailNext;
            return dummy.next;

        }

        private void reserve(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
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