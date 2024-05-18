//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics链表 | 双指针 
//
// 👍 2852, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode.editor.cn;

/**
 * 19:删除链表的倒数第 N 个结点
 */
public class 删除链表的倒数第 N 个结点19 {
    public static void main(String[] args) {
        Solution solution = new 删除链表的倒数第 N 个结点19 ().new Solution();
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
        // 使用虚拟头节点,快慢指针
        // 作者(代码随想录)
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 特殊判空
            if (head == null) {
                return head;
            }

            // 定义虚拟头节点
            ListNode dummyHead = new ListNode();
            dummyHead.next = head;

            // 定义快慢指针
            ListNode fast = dummyHead;
            ListNode slow = dummyHead;

            // 需要找到倒数第n个节点的前一个节点,这样才能将这个节点删除
            n++;

            // 先将快指针移动n+1个位置
            for (int i = 1; i <= n; i++) {
                fast = fast.next;
            }

            // 再同时移动快指针和慢指针,当快指针=null时,慢指针位置倒数n+1的位置
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }

            // 移除倒数第n个节点
            slow.next = slow.next.next;
            return dummyHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}