
/*
Given an integer K and a queue of integers, we need to reverse the order of the first K elements of the queue, leaving the other elements in the same relative order.

Only following standard operations are allowed on queue.

enqueue(x) : Add an item x to rear of queue
dequeue() : Remove an item from front of queue
size() : Returns number of elements in queue.
front() : Finds front item.
Note: The above operations represent the general processings. In-built functions of the respective languages can be used to solve the problem.

Example 1:

Input:
5 3
1 2 3 4 5
Output: 
3 2 1 4 5
Explanation: 
After reversing the given
input from the 3rd position the resultant
output will be 3 2 1 4 5.
Example 2:

Input:
4 4
4 3 2 1
Output: 
1 2 3 4
Explanation: 
After reversing the given
input from the 4th position the resultant
output will be 1 2 3 4.
Your Task:
Complete the provided function modifyQueue() that takes queue and K as parameters and returns a modified queue. The printing is done automatically by the driver code.

Expected Time Complexity : O(N)
Expected Auxiliary Space : O(K)

Constraints:
1 <= K <= N <= 105
*/



class GfG {
    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // using a stack and another queue to reverse first k elements.
        Stack<Integer> s = new Stack<>();
        Queue<Integer> qq = new LinkedList<>();

        // we pop first k elements from queue and push it in the stack.
        while (k-- > 0) {
            int a = q.peek();
            q.poll();
            s.push(a);
        }
        // while stack is not empty, we push the elements into the new queue.
        while (!s.isEmpty()) {
            int a = s.peek();
            s.pop();
            qq.add(a);
        }
        // then we add rest of the elements of original queue to the new queue.
        while (!q.isEmpty()) {
            int a = q.peek();
            q.poll();
            qq.add(a);
        }
        // returning the new queue.
        return qq;
    }
}
