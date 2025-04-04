package leetcode6.leetcode.editor.cn;

import leetcode2.leetcode.editor.cn.ListNode;

/**
 * 19:删除链表的倒数第 N 个结点
 */
public class 删除链表的倒数第 N 个结点19 {
    public static void main(String[] args) {
         Solution solution = new 删除链表的倒数第 N 个结点19().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);

        ListNode slow = dummy;
        ListNode fast = dummy;
        // 快指针先移动n个距离
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // 快指针移动到最后一位
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}