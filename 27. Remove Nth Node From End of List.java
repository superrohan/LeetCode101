/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]
*/

/*
by using two pointers with a gap of n nodes between them. By moving both pointers simultaneously until the fast one reaches the end, the slow pointer will be just before the node we want to remove.

Steps:
Initialize two pointers: fast and slow both pointing to a dummy node ahead of head.
Move fast pointer n+1 steps forward to maintain a gap of n between slow and fast.
Move both fast and slow pointers until fast pointer reaches the end.
The slow pointer will be at the node just before the target node. Adjust its next pointer to skip the nth node from the end.
Return the head of the modified list.
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Initialize a dummy node which helps in handling edge cases like removing the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Initialize two pointers both at the dummy node
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        // Move fast ahead by n+1 steps to create the required gap
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // Move both pointers till fast reaches the end of the list
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // Adjust the pointers to skip the nth node
        slow.next = slow.next.next;
        
        // Return the updated list starting from the node next to dummy
        return dummy.next;
    }
}

/*
Time Complexity: O(L) since We make a single traversal of the list.
Space Complexity: O(1) since only a constant amount of extra space is used.
*/
