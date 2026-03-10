Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n==0){return head;}
        ListNode cur = head;
        int count = 0;
        while(cur!=null){
            count++;
            cur = cur.next;
        }
        if(n==1 && count == 1){return null;}
        int del = count - n + 1;
        if(del == 1){
            cur = head;
            head = head.next;
            cur.next = null;
            return head;
        }
        cur = head;
        ListNode pre = cur;
        for(int i = 1;i < del; i++){
            pre = cur;
            cur = cur.next;
        }
        if(cur.next!=null){
            pre.next = cur.next;
        } else {
            pre.next = null;
        }
        cur.next = null;
        return head;
        
    }
}