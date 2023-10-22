//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics栈 | 递归 | 链表 | 双指针 
//
// 👍 1805, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode.editor.cn;

import java.util.List;

/**
 * 234:回文链表
 */
public class 回文链表234 {
    public static void main(String[] args) {
        Solution solution = new 回文链表234().new Solution();

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        solution.isPalindrome(a);

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
        public boolean isPalindrome(ListNode head) {
            // 空间复杂度O(n)，使用额外的数组存储
            //List<Integer> values = new ArrayList<>();
            //while (head != null) {
            //    values.add(head.val);
            //    head = head.next;
            //}
            //
            //int first = 0, tail = values.size() - 1;
            //while (first < tail) {
            //    if (!values.get(first).equals(values.get(tail)) ) {
            //        return false;
            //    }
            //    first++;
            //    tail--;
            //}
            //return true;

            // 空间复杂度O(1),链表后半部分反转,双指针判断
            // 1.先使用快慢指针找到中点
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // fast不为空,链表长度为奇数，show往前移动一位
            if (fast != null) {
                slow = slow.next;
            }

            ListNode right = reserve(slow);
            ListNode left = head;

            while (right != null) {
                if (right.val != left.val) {
                    return false;
                }
                right = right.next;
                left = left.next;
            }
            return true;

        }

        public ListNode reserve(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}