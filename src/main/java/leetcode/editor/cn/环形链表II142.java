  //给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 
//
// 不允许修改 链表。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
//
// 
//
// 进阶：你是否可以使用 O(1) 空间解决此题？ 
//
// Related Topics哈希表 | 链表 | 双指针 
//
// 👍 2370, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package leetcode.editor.cn;

  import java.util.HashSet;
  import java.util.Set;

  /**
   * 142:环形链表 II
   */
  public class 环形链表II142 {
      public static void main(String[] args) {
           Solution solution = new 环形链表II142().new Solution();
          ListNode node1 = new ListNode(3);
          ListNode node2 = new ListNode(2);
          ListNode node3 = new ListNode(0);
          ListNode node4 = new ListNode(4);
          node1.next =node2;
          node2.next=node3;
          node3.next=node4;
          node4.next= node2;
          solution.detectCycle(node1);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //public ListNode detectCycle(ListNode head) {
    //    // 使用哈希存储判断
    //    Set<ListNode> set = new HashSet<>();
    //    while (head != null) {
    //        if (!set.add(head)) {
    //            return head;
    //        }
    //        head = head.next;
    //    }
    //    return null;
    //}

    // 卡子哥解法 快慢指针
    // 出发点到环入口定义为x，环入口到相交点为y，相交点到环入口定义为z
    // 通过数学推导，相交点快指针与起始点一起移动，相交时为环入口，
    public ListNode detectCycle(ListNode head) {
        // 1. 先找相交点
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            // 快指针访问到链表末尾了,无环
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. fast为快慢指针相交点，与起始点同时移动
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }