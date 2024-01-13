/*

Given a singly linked list, sort the list (in ascending order) using insertion sort algorithm.

Example 1:

Input:
N = 10
Linked List = 30->23->28->30->11->14->
              19->16->21->25 
Output : 
11 14 16 19 21 23 25 28 30 30 
Explanation :
The resultant linked list is sorted.
Example 2:

Input : 
N = 7
Linked List=19->20->16->24->12->29->30 
Output : 
12 16 19 20 24 29 30 
Explanation : 
The resultant linked list is sorted.

*/

class Solution
{
    public static Node insertionSort(Node head)
    {
        if(head == null || head.next == null) return head;
        
        Node sortedHead = new Node(-1);
        Node currentHead = head;
        
        while(currentHead != null) {
            Node nextNode = currentHead.next;
            Node dummyNode = sortedHead;
           
            while(dummyNode.next != null && dummyNode.next.data <= currentHead.data) {
                dummyNode = dummyNode.next;
            }
            
            currentHead.next = dummyNode.next;
            dummyNode.next = currentHead;
            currentHead = nextNode;
        }
        return sortedHead.next;
    }
}

  
