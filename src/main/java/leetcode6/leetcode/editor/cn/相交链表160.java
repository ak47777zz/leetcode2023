package leetcode6.leetcode.editor.cn;

import leetcode2.leetcode.editor.cn.ListNode;

/**
 * 160:相交链表
 */
public class 相交链表160 {
    public static void main(String[] args) {
        Solution solution = new 相交链表160().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode A = headA;
            ListNode B = headB;
            while (A != B) {
                A = A == null ? headB : A.next;
                B = B == null ? headA : B.next;
            }
            return A;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}