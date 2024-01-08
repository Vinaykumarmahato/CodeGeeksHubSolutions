/*
Given two linked lists of size N and M, which are sorted in non-decreasing order. The task is to merge them in such a way that the resulting list is in non-increasing order.

Example 1:

Input:
N = 2, M = 2
list1 = 1->3
list2 = 2->4
Output:
4->3->2->1
Explanation:
After merging the two lists in non-increasing order, we have new lists as 4->3->2->1.
Example 2:

Input:
N = 4, M = 3
list1 = 5->10->15->40 
list2 = 2->3->20
Output:
40->20->15->10->5->3->2
Explanation:
After merging the two lists in non-increasing order, we have new lists as 40->20->15->10->5->3->2.
Your Task:
The task is to complete the function mergeResult() which takes reference to the heads of both linked list and returns the pointer to the merged linked list.

Expected Time Complexity : O(N+M)
Expected Auxiliary Space : O(1)

Constraints:
0 <= N, M <= 104

*/


class GfG
{
    Node reverse(Node head){
        Node curr=head;
        Node prev=null;
        while(curr!=null){
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    
    Node mergeResult(Node head1, Node head2)
    {
        Node dummyNode = new Node(0); 
        Node tail = dummyNode; 
        while(true)  
        { 
            if(head1 == null) 
            { 
                tail.next = head2; 
                break; 
            } 
            if(head2 == null) 
            { 
                tail.next = head1; 
                break; 
            } 
            if(head1.data <= head2.data) 
            { 
                tail.next = head1;
                head1 = head1.next; 
            }  
            else
            { 
                tail.next = head2; 
                head2 = head2.next; 
            } 
            tail = tail.next; 
        } 
        return reverse(dummyNode.next);
    }
}
