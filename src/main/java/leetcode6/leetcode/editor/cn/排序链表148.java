package leetcode6.leetcode.editor.cn;

import leetcode2.leetcode.editor.cn.ListNode;

/**
 * 148:排序链表
 */
public class 排序链表148 {
    public static void main(String[] args) {
         Solution solution = new 排序链表148().new Solution();
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
    // 重点在于，当元素为偶数时，慢指针需要落在中心点的左侧，这就需要快指针先跳一步
    public ListNode sortList(ListNode head) {
        // 只剩一个节点，无需处理
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (true) {
            if (fast == null || fast.next == null) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode slowNext = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slowNext);

        // 合并
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (left != null || right != null) {
            if (left == null) {
                cur.next = right;
                right = right.next;
            } else if (right == null) {
                cur.next = left;
                left = left.next;
            } else {
                if (left.val < right.val) {
                    cur.next = left;
                    left = left.next;
                } else {
                    cur.next = right;
                    right = right.next;
                }
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}