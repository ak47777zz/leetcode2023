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
// 👍 3716, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode5.leetcode.editor.cn;

import leetcode2.leetcode.editor.cn.ListNode;

/**
 * 21:合并两个有序链表
 */
public class 合并两个有序链表21 {
    public static void main(String[] args) {
        Solution solution = new 合并两个有序链表21().new Solution();
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            while (list1 != null || list2 != null) {
                // 直接拼接 list2
                if (list1 == null) {
                    cur.next = list2;
                    list2 = list2.next;
                } else if (list2 == null) {
                    cur.next = list1;
                    list1 = list1.next;
                } else {
                    if (list1.val < list2.val) {
                        cur.next = list1;
                        list1 = list1.next;
                    } else {
                        cur.next = list2;
                        list2 = list2.next;
                    }
                }
                cur = cur.next;
            }
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}