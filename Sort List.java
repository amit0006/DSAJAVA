Given the head of a linked list, return the list after sorting it in ascending order.
Input: head = [4,2,1,3]
Output: [1,2,3,4]
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        // ListNode first = head;
        // while(head!=null){
        //     ListNode cur = head.next;
        //     int flag = 0;
        //     while(cur!=null){
        //         if(head.val>cur.val){
        //             int temp = cur.val;
        //             cur.val = head.val;
        //             head.val = temp;
        //             flag = 1;
        //         }
        //         cur = cur.next;
        //     }
        //     if(flag == 1){
        //         head = first;
        //     } else {
        //         head = head.next;
        //     }
        // }
        // return first;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);

    }
    ListNode getMid(ListNode node){
        ListNode fast = node, slow = node, prev = null;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }
    ListNode merge(ListNode node1, ListNode node2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(node1 != null && node2 != null){
            if(node1.val<node2.val){
                tail.next = node1;
                node1 = node1.next;
            } else {
                tail.next = node2;
                node2 = node2.next;
            }
            tail = tail.next;
        }
        tail.next = (node1!=null)?node1:node2;
        return dummy.next;
    }
}