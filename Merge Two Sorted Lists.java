// You are given the heads of two sorted linked lists list1 and list2.

// Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

// Return the head of the merged linked list.

 

// Example 1:


// Input: list1 = [1,2,4], list2 = [1,3,4]
// Output: [1,1,2,3,4,4]
// Example 2:

// Input: list1 = [], list2 = []
// Output: []
// Example 3:

// Input: list1 = [], list2 = [0]
// Output: [0]
 


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
// class Solution {
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//         if(list1 == null && list2 == null){
//             return list1;
//         } else if(list1 == null){
//             return list2;
//         } else if(list2 == null){
//             return list1;
//         }
//         ListNode dummy = new ListNode();
//         ListNode cur = dummy;
//         ListNode pre = null;
//         dummy.next = null;
//         ListNode head1 = list1;
//         ListNode head2 = list2;
//         while(head1!=null && head2!=null){
//             int min = 0, flag = 0;
//             if(head1.val<head2.val){
//                 min = head1.val;
//                 head1 = head1.next;
//             } else if(head1.val>head2.val){
//                 min = head2.val;
//                 head2 = head2.next;
//             } else {
//                 min = head1.val;
//                 flag = 1;
//                 head1 = head1.next;
//                 head2 = head2.next;
//             }
//             if(cur==null){
//                 cur = new ListNode();
//                 cur.next = null;
//                 pre.next = cur;
//             }
//             cur.val = min;
//             pre = cur;
//             cur = cur.next;
//             if(flag == 1){
//                 cur = new ListNode();
//                 cur.next = null;
//                 pre.next = cur;
//                 cur.val = min;
//                 pre = cur;
//                 cur = cur.next;
//                 flag = 0;
//             }
//         }
//         if(head1!=null){
//             pre.next = head1;
//         } else if(head2!=null){
//             pre.next = head2;
//         }
//         return dummy;
        
//     }
// }

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;
    }
}