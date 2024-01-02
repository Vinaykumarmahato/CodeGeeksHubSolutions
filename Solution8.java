/*
Given an array a of length n and a number k, find the largest sum of the subarray containing at least k numbers. It is guaranteed that the size of array is at-least k.

Example 1:

Input : 
n = 4
a[] = {1, -2, 2, -3}
k = 2
Output : 
1
Explanation :
The sub-array of length at-least 2
that produces greatest sum is {1, -2, 2}
Example 2:
Input :
n = 6 
a[] = {1, 1, 1, 1, 1, 1}
k = 2
Output : 
6
Explanation :
The sub-array of length at-least 2
that produces greatest sum is {1, 1, 1, 1, 1, 1}
Your Task:  
You don't need to read input or print anything. Your task is to complete the function maxSumWithK() which takes the array a[], its size n and an integer k as inputs and returns the value of the largest sum of the subarray containing at least k numbers.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= n <= 105
-105 <= a[i] <= 105
1 <= k <= n


*/


class Solution {
    // Returns maximum sum of a subarray with at least k elements.
    public long maxSumWithK(long[] a, long n, long k) {
        // maxSum[i] is going to store maximum sum till index i.
        long[] maxSum = new long[(int) n];
        maxSum[0] = a[0];

        // Using Kadane's algorithm to fill maxSum[]
        long currMax = a[0];
        for (int i = 1; i < n; i++) {
            currMax = Math.max(a[i], currMax + a[i]);
            maxSum[i] = currMax;
        }

        // Sum of first k elements
        long sum = 0;
        for (int i = 0; i < k; i++) sum += a[i];

        // Using the concept of sliding window
        long result = sum;
        for (int i = (int) k; i < n; i++) {
            // Compute sum of k elements ending with a[i]
            sum = sum + a[i] - a[i - (int) k];

            // Update result if required
            result = Math.max(result, sum);

            // Include maximum sum till [i-k] also if it increases overall max
            result = Math.max(result, sum + maxSum[i - (int) k]);
        }
        return result;
    }
}
