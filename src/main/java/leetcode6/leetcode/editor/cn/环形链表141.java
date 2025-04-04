package leetcode6.leetcode.editor.cn;

import leetcode2.leetcode.editor.cn.ListNode;

/**
 * 141:环形链表
 */
public class 环形链表141 {
    public static void main(String[] args) {
        Solution solution = new 环形链表141().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }

            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    return true;
                }
            }
            return false;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}