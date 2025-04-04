package leetcode6.leetcode.editor.cn;

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
            if (head == null || head.next == null) {
                return head;
            }

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