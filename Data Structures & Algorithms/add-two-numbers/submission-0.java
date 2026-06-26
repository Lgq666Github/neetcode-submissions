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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;

            int val = v1 + v2 + carry; // 计算当前位的总和
            carry = val / 10; // 计算新的进位值
            val = val % 10; // 取个位数作为当前节点的值

            cur.next = new ListNode(val); // 创建新节点存储计算结果，并链接到结果链表
            cur = cur.next; // 移动 cur 指针

            l1 = (l1 != null) ? l1.next : null; // 移动 l1 指针
            l2 = (l2 != null) ? l2.next : null; // 移动 l2 指针
        }
        return dummy.next;
    }
}