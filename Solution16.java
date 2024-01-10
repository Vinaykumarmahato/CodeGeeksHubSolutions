
/*

Given an array arr containing N integers and a positive integer K, find the length of the longest sub array with sum of the elements divisible by the given value K.

Example 1:

Input:
N = 6, K = 3
arr[] = {2, 7, 6, 1, 4, 5}
Output: 
4
Explanation:
The subarray is {7, 6, 1, 4} with sum 18, which is divisible by 3.
Example 2:

Input:
N = 7, K = 3
arr[] = {-2, 2, -5, 12, -11, -1, 7}
Output: 
5
Explanation:
The subarray is {2,-5,12,-11,-1} with sum -3, which is divisible by 3.
Your Task:
The input is already taken care of by the driver code. You only need to complete the function longSubarrWthSumDivByK() that takes an array arr, sizeOfArray n and a  positive integer K, and returns the length of the longest subarray which has sum divisible by K. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 105
1 <= K <= 109
-109 <= A[i] <= 109 



*/

import java.util.HashMap;

class Solution {

    // function to find the length of the
    // longest subarray with sum divisible by K
    static int longSubarrWthSumDivByK(int arr[], int n, int k) {
        // unordered map 'um' implemented as
        // a hash table
        HashMap<Integer, Integer> um = new HashMap<Integer, Integer>();

        // 'mod_arr[i]' stores (sum[0..i] % k)
        int mod_arr[] = new int[n];
        int max_len = 0;
        int curr_sum = 0;

        // traverse arr[] and build up the
        // array 'mod_arr[]'
        for (int i = 0; i < n; i++) {
            curr_sum += arr[i];

            // as the sum can be negative,
            // taking modulo twice
            mod_arr[i] = ((curr_sum % k) + k) % k;

            // if true then sum(0..i) is
            // divisible by k
            if (mod_arr[i] == 0)
                // update 'max'
                max_len = i + 1;

            // if value 'mod_arr[i]' not present in 'um'
            // then store it in 'um' with the index of its
            // first occurrence
            else if (!um.containsKey(mod_arr[i]))
                um.put(mod_arr[i], i);

            else
                // if true, then update 'max'
                if (max_len < (i - um.get(mod_arr[i])))
                    max_len = i - um.get(mod_arr[i]);
        }

        // return the required length of the longest subarray
        // with sum divisible by 'k'
        return max_len;
    }

    public static void main(String[] args) {
        int arr1[] = {2, 7, 6, 1, 4, 5};
        int n1 = arr1.length;
        int k1 = 3;

        System.out.println("Length = " +
                longSubarrWthSumDivByK(arr1, n1, k1));

        int arr2[] = {-2, 2, -5, 12, -11, -1, 7};
        int n2 = arr2.length;
        int k2 = 3;

        System.out.println("Length = " +
                longSubarrWthSumDivByK(arr2, n2, k2));
    }
}
