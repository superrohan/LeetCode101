/*
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Example 1:
Input: head = [1,2,3,4]
Output: [2,1,4,3]

Example 2:
Input: head = []
Output: []

Example 3:
Input: head = [1]
Output: [1]

Example 4:
Input: head = [1,2,3]
Output: [2,1,3]
*/

/*
The iterative approach involves using a dummy node to facilitate the swapping process as we walk through the list:

Setup a Dummy Node: This helps manage edge cases and makes node swapping easier.
Traversal and Swapping:
Swap nodes by adjusting pointers.
Use a loop to continue swapping until the end of the list is reached.
*/

class Solution {
    public ListNode swapPairsIterative(ListNode head) {
        // Initial dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        // Traverse and swap pairs while there are at least two nodes remaining
        while (current.next != null && current.next.next != null) {
            // Nodes to be swapped
            ListNode firstNode = current.next;
            ListNode secondNode = current.next.next;

            // Adjusting pointers for swap
            firstNode.next = secondNode.next;
            current.next = secondNode;
            secondNode.next = firstNode;

            // Move the pointer by two nodes for next pair
            current = firstNode;
        }

        // Return new head at dummy's next
        return dummy.next;
    }
}

/*
Time Complexity: O(N) since we traverse each node of the list exactly once.
Space Complexity: O(1) as no additional space is used other than a few pointers.
*/
