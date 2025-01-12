//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics递归 | 链表 
//
// 👍 2465, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode3.leetcode.editor.cn;

import leetcode2.leetcode.editor.cn.ListNode;

/**
 * 25:K 个一组翻转链表
 */
public class K 个一组翻转链表25 {
    public static void main(String[] args) {
        Solution solution = new K 个一组翻转链表25().new Solution();
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
        // leetcode中reedfan的解法
        public ListNode reverseKGroup(ListNode head, int k) {
            // k个元素后的下个元素定义为tail
            ListNode tail = head;
            for (int i = 0; i < k; i++) {
                // 说明长度不足k,直接返回头
                if (tail == null) {
                    return head;
                }
                tail = tail.next;
            }

            // 反转head到tail之间的链表，不包含tail，左闭右开
            ListNode newHead = reserve(head, tail);
            head.next = reverseKGroup(tail, k);
            return newHead;
        }

        /**
         * 反转head到tail之间的链表，不包含tail，左闭右开
         * 返回新的链表头
         */
        public ListNode reserve(ListNode head, ListNode tail) {
            ListNode pre = null, cur = head;
            while (cur != tail) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}