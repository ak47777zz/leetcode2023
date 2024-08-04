  //将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics递归 | 链表 
//
// 👍 3565, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package leetcode2.leetcode.editor.cn;
  
  /**
   * 21:合并两个有序链表
   */
  public class 合并两个有序链表21 {
      public static void main(String[] args) {
           Solution solution = new 合并两个有序链表21().new Solution();
          ListNode node1 = new ListNode(1);
          ListNode node2 = new ListNode(2);
          ListNode node4 = new ListNode(4);
          node1.next = node2;
          node2.next = node4;

          ListNode node7 = new ListNode(1);
          ListNode node8 = new ListNode(3);
          ListNode node9 = new ListNode(4);
          node7.next = node8;
          node8.next = node9;
          solution.mergeTwoLists(node1, node7);

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 虚拟头节点 + 双指针
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if (list1 == null) {
            cur.next = list2;
        }

        if (list2 == null) {
            cur.next = list1;
        }

        return dummy.next;


        //if (list1 == null && list2 == null) {
        //    return null;
        //}
        //if (list1 == null) {
        //    return list2;
        //}
        //if (list2 == null) {
        //    return list1;
        //}
        //ListNode dummy = new ListNode(-1);
        //ListNode cur = dummy;
        //ListNode left = list1;
        //ListNode right = list2;
        //while (true) {
        //    if (left == null) {
        //        cur.next = right;
        //        break;
        //    }
        //    if (right == null) {
        //        cur.next = left;
        //        break;
        //    }
        //    if (left.val < right.val) {
        //        cur.next = left;
        //        left = left.next;
        //    } else {
        //        cur.next = right;
        //        right = right.next;
        //    }
        //    cur = cur.next;
        //}
        //return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }