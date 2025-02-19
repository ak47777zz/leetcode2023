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
// 👍 2005, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package leetcode4.leetcode.editor.cn;

  import leetcode2.leetcode.editor.cn.ListNode;

  /**
   * 234:回文链表
   */
  public class 回文链表234 {
      public static void main(String[] args) {
           Solution solution = new 回文链表234().new Solution();
          ListNode one = new ListNode(1);
          ListNode two1 = new ListNode(2);
          ListNode two2 = new ListNode(2);
          ListNode one2 = new ListNode(1);
          one.next = two1;
          two1.next = two2;
          two2.next = one2;
          solution.isPalindrome(one);
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
    public boolean isPalindrome(ListNode head) {
        // 使用快慢指针找到链表的中点
        // 当链表数量为奇数时，slow指针正好是中心节点
        // 当链表数量为偶数时，slow指针在中心点的右侧
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow= slow.next;
            fast = fast.next.next;
        }

        // 反转右侧的链表, 如果是奇数个，此时左侧链表会比右侧链表数量多1个
        ListNode pre = null, cur = slow;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        // 反转后，通过右侧链表头对比左侧链表头，判断是否为回文
        while (pre != null) {
            if (pre.val != head.val) {
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }