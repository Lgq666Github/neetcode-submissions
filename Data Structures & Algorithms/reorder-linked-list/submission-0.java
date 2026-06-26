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
    public void reorderList(ListNode head) {
        if (head == null) return;
        // 使用快慢指针，slow每次一步，fast每次两步，当fast走到链表末尾，slow正好在链表中间
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 反转后半部分链表
        ListNode prev = null, curr = slow, tmp;
        while (curr != null) {
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        // 交错合并前后两个部分
        ListNode first = head, second = prev;
        while (second.next != null) {
            tmp = first.next; // 暂存 first 的下一个节点
            first.next = second; // 将 first 指向 second
            first = tmp; // 移动 first 到下一个节点

            tmp = second.next; // 暂存 second 的下一个节点
            second.next = first; // 将 second 指向 first（完成一次交错）
            second = tmp; // 继续移动 second
        }
    }
}