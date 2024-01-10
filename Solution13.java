/*
Given an array arr[] of N elements and a number K., split the given array into K subarrays such that the maximum subarray sum achievable out of K subarrays formed is minimum possible. Find that possible subarray sum.

Example 1:

Input:
N = 4, K = 3
arr[] = {1, 2, 3, 4}
Output: 4
Explanation:
Optimal Split is {1, 2}, {3}, {4}.
Maximum sum of all subarrays is 4,
which is minimum possible for 3 splits. 
Example 2:

Input:
N = 3, K = 2
A[] = {1, 1, 2}
Output:
2
Explanation:
Splitting the array as {1,1} and {2} is optimal.
This results in a maximum sum subarray of 2.
Your Task:
You do not have to take any input or print anything. The task is to complete the function splitArray() which returns the maximum sum subarray after splitting the array into K subarrays such that maximum sum subarray is minimum possible.

Expected Time Complexity: O(N*log(sum(arr))).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 105
1 ≤ K ≤ N
1 ≤ arr[i] ≤ 104
*/

class Solution {
  
    static boolean check(int mid, int array[], int n, int K)
    {
 
        int count = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
 
            if (array[i] > mid)
                return false;
 
            sum += array[i];
 
            if (sum > mid) {
                count++;
                sum = array[i];
            }
        }
        count++;
 
        if (count <= K)
            return true;
        return false;
    }
    
    static int splitArray(int[] arr , int N, int K) {
        
        int start = 1;
        for (int i = 0; i < N; ++i) {
            if (arr[i] > start)
                start = arr[i];
        }
        int end = 0;
 
        for (int i = 0; i < N; i++) {
            end += arr[i];
        }
 
        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (check(mid, arr, N, K)) {
                answer = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
 
        return answer;
    }
};