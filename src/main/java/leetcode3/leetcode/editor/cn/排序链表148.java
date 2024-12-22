//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
// 
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// Related Topics链表 | 双指针 | 分治 | 排序 | 归并排序 
//
// 👍 2412, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode3.leetcode.editor.cn;

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
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode sortList(ListNode head) {
            // 当前节点为空或当前节点下一个节点为空,说明链表已经拆分到单个节点,无需排序直接返回
            if (head == null || head.next == null) {
                return head;
            }

            // 通过快慢指针,寻找链表中心节点
            // 当链表长度为偶数时，slow为中心点的前一位
            // 当链表长度为奇数时，slow正好为中心点
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // 从中心点将链表切开
            ListNode rightHead = slow.next;
            slow.next = null;

            // 递归排序左链表和右链表
            ListNode left = sortList(head);
            ListNode right = sortList(rightHead);

            // 双指针比较大小合并两条链表
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    cur.next = left;
                    cur = cur.next;
                    left = left.next;
                } else {
                    cur.next = right;
                    cur = cur.next;
                    right = right.next;
                }
            }

            // 走到这里说明有一条链表已经排序完毕,直接把另一条链表接到当前链表的尾部
            if (left != null) {
                cur.next = left;
            }
            if (right != null) {
                cur.next = right;
            }

            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}