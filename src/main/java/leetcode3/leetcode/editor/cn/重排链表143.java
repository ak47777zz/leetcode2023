//给定一个单链表 L 的头节点 head ，单链表 L 表示为：
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
//
// Related Topics栈 | 递归 | 链表 | 双指针 
//
// 👍 1555, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode3.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

import leetcode2.leetcode.editor.cn.ListNode;

/**
 * 143:重排链表
 */
public class 重排链表143 {
    public static void main(String[] args) {
        Solution solution = new 重排链表143().new Solution();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;

        solution.reorderList(one);
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
        // 代码随想录
        public void reorderList(ListNode head) {
            // 使用双端队列
            Deque<ListNode> queue = new LinkedList<>();

            // 第一个元素不需要加入
            ListNode cur = head.next;
            while (cur != null) {
                // 队尾插入元素
                queue.add(cur);
                cur = cur.next;
            }

            // 回到头部
            cur = head;

            // 开始拼接
            int count = 0;
            while (!queue.isEmpty()) {
                // 偶数取队尾
                if (count % 2 == 0) {
                    cur.next = queue.pollLast();
                } else {
                    // 奇数取队头
                    cur.next = queue.pollFirst();
                }
                count++;
                cur = cur.next;
            }

            // 最后尾部设置为null
            cur.next = null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}