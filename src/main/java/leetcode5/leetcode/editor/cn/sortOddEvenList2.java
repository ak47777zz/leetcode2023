package leetcode5.leetcode.editor.cn;


/**
 * 排序奇升偶降链表
 */
public class sortOddEvenList2 {

    public class Solution {
        public ListNode sortOddEvenList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            // 奇数
            ListNode odd  = head;
            // 偶数
            ListNode even = head.next;

            // mark
            ListNode evenHead = head.next;

            while (even != null && even.next != null) {
                odd.next = even.next;
                odd = odd.next;
                even.next = even.next.next;
                even = even.next;
            }
            odd.next = null;

            ListNode newEvenHead = reserve(evenHead);
            return merge(head, newEvenHead);
        }

        private ListNode merge(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            ListNode l1 = list1;
            ListNode l2 = list2;
            while (l1 != null || l2 != null) {
                if (l1 == null) {
                    cur.next = l2;
                    l2 = l2.next;
                } else if (l2 == null) {
                    cur.next = l1;
                    l1 = l1.next;
                    continue;
                } else if (l1.val < l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            return dummy.next;

        }

        private ListNode reserve(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur =next;
            }
            return pre;
        }


    }

    public static void main(String[] args) {
        Solution solution = new sortOddEvenList2().new Solution();
        // 建立测试用例 1->8->3->6->5->4->7->2->NULL, 输出结果应为 1->2->3->4->5->6->7->8->NULL
        ListNode head = new ListNode(1);
        ListNode p1 = new ListNode(8);
        ListNode p2 = new ListNode(3);
        ListNode p3 = new ListNode(6);
        ListNode p4 = new ListNode(5);
        ListNode p5 = new ListNode(4);
        ListNode p6 = new ListNode(7);
        ListNode p7 = new ListNode(2);
        head.next = p1;
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        p6.next = p7;
        solution.sortOddEvenList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}

