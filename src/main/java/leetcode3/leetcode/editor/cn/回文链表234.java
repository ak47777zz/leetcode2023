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
// 👍 1983, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode3.leetcode.editor.cn;

import leetcode2.leetcode.editor.cn.ListNode;

/**
 * 234:回文链表
 */
public class 回文链表234 {
    public static void main(String[] args) {
        Solution solution = new 回文链表234().new Solution();
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
            //// 解法1：使用额外数组 空间复杂度O(n) 时间复杂度O(n)
            //
            //// 使用额外数组
            //List<Integer> list = new ArrayList<>();
            //while (head != null) {
            //    list.add(head.val);
            //    head = head.next;
            //}
            //
            //// 双指针头尾判断
            //int left = 0, right = list.size() - 1;
            //while (left < right) {
            //    if (!Objects.equals(list.get(left), list.get(right))) {
            //        return false;
            //    }
            //    left++;
            //    right--;
            //}
            //return true;

            // 解法2：找到链表中心点，反转中心点后面的链表，链表起点和中心点依次对比
            // 空间复杂度O(1) 时间复杂度O(n)

            // 找到链表中心点
            // 如果节点数为奇数，找到的是正中间的节点
            // 如果节点数为偶数，找到的是正中间右边的节点
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // 基于找到的中心点，反转右侧的链表
            ListNode pre = null, cur = slow;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            // 链表起点和中心点依次对比
            while (pre != null) {
                if (head.val != pre.val) {
                    return false;
                }
                head = head.next;
                pre = pre.next;
            }
            return true;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}