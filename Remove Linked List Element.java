// Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

 

// Example 1:


// Input: head = [1,2,6,3,4,5,6], val = 6
// Output: [1,2,3,4,5]
// Example 2:

// Input: head = [], val = 1
// Output: []
// Example 3:

// Input: head = [7,7,7,7], val = 7
// Output: []


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
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur, pre, previous;
        if(head==null){
            return head;
        }
        cur = head;
        pre = null;
        while(cur!=null){
            if(cur.val == val){
                if(pre != null){
                    pre.next = cur.next;
                    cur = pre.next;
                } else {
                    pre = cur;
                    cur = cur.next;
                    pre.next = null;
                    head = cur;
                    pre = null;
                }
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}