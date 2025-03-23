//给定一个头节点为 head 的链表用于记录一系列核心肌群训练项目编号，请查找并返回倒数第 cnt 个训练项目编号。
//
// 
//
// 示例 1： 
//
// 
//输入：head = [2,4,7,8], cnt = 1
//输出：8 
//
// 
//
// 提示： 
//
// 
// 1 <= head.length <= 100 
// 0 <= head[i] <= 100 
// 1 <= cnt <= head.length 
// 
//
// 
//
// Related Topics链表 | 双指针 
//
// 👍 527, 👎 0 
//
//
//
//

package leetcode5.leetcode.editor.cn;

import leetcode2.leetcode.editor.cn.ListNode;

/**
 * LCR 140:训练计划 II
 */
public class 训练计划 IILCR 140{
public static void main(String[]args){
    Solution solution=new 训练计划 IILCR 140().new Solution();
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
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < cnt; i++) {
            fast = fast.next;
        }

        // 快慢指针同时移动
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }