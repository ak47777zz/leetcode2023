package leetcode6.leetcode.editor.cn;

import leetcode2.leetcode.editor.cn.ListNode;

/**
 * 142:环形链表 II
 */
public class 环形链表 II142 {
    public static void main(String[] args) {
         Solution solution = new 环形链表 II142().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null || fast.next == null) {
                return null;
            }
            if (slow == fast) {
                break;
            }
        }

        slow = head;

        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}