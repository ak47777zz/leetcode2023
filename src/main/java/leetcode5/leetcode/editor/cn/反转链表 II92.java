  //给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics链表 
//
// 👍 1935, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package leetcode5.leetcode.editor.cn;

  import leetcode2.leetcode.editor.cn.ListNode;

  /**
   * 92:反转链表 II
   */
  public class 反转链表 II92 {
      public static void main(String[] args) {
           Solution solution = new 反转链表 II92().new Solution();
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 4点位法
        ListNode dummy = new ListNode(-1, head);

        // 1. 找到待反转链表的前一个节点
        ListNode pre = dummy;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        // 2.找到待反转链表的最后一个节点
        ListNode tail = dummy;
        for (int i = 0; i < right; i++) {
            tail = tail.next;
        }

        ListNode preNext = pre.next;
        ListNode tailNext = tail.next;
        pre.next = null;
        tail.next = null;
        reserve(preNext);

        pre.next = tail;
        preNext.next = tailNext;
        return dummy.next;
    }

    private void reserve(ListNode root) {
        ListNode pre = null;
        ListNode cur = root;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }