/*

Solving the Kth Smallest Element Problem in Java
Problem Overview
Given an array arr[] of distinct elements and an integer K, where K is smaller than the size of the array, the task is to find the Kth smallest element in the given array. The array elements are distinct, and the function kthSmallest takes the array, starting and ending indices l and r, and the integer K as input, returning the Kth smallest element.

Approach in Java
Initialize a Max Heap
Utilize Java's PriorityQueue to create a max heap.
Define a custom comparator to ensure the heap behaves as a max heap.
Iterate through the Array
Use a loop to iterate through the array arr[] from the starting index l to the ending index r.
Add each element to the maxHeap.
Maintain Heap Size
Check if the size of the maxHeap is greater than K and, if so, remove the maximum element from the heap.
Result
After iterating through the array, the maxHeap will contain the K smallest elements.
Retrieve the Kth smallest element from the top of the maxHeap.
Time and Space Complexity
Expected Time Complexity: O(n*log(n))
Expected Auxiliary Space: O(log(n))
Java Implementation 
  */

class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a, b) -> b - a);  
        for(int i=0;i<arr.length;i++){
            maxHeap.add(arr[i]);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }  
        return maxHeap.peek();
    } 
}
