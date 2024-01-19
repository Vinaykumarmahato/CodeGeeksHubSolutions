
''' Given N numbers in an array, your task is to keep at most the top K numbers with respect to their frequency.

In other words, you have to iterate over the array, and after each index, determine the top K most frequent numbers until that iteration and store them in an array in decreasing order of frequency. An array will be formed for each iteration and stored in an array of arrays. If the total number of distinct elements is less than K, then keep all the distinct numbers in the array. If two numbers have equal frequency, place the smaller number first in the array.

Example 1:

Input:
N=5, K=4
arr[] = {5, 2, 1, 3, 2} 
Output: 
5 
2 5 
1 2 5 
1 2 3 5 
2 1 3 5 
Explanation:
Firstly there was 5 whose frequency
is max till now. So resulting sequence is {5}.
Then came 2, which is smaller than 5 but
their frequencies are same so resulting sequence is {2, 5}.
Then came 1, which is the smallest among all the
numbers arrived, so resulting sequence is {1, 2, 5}.
Then came 3 , so resulting sequence is {1, 2, 3, 5}
Then again 2, which has the highest
frequency among all numbers, 
so resulting sequence {2, 1, 3, 5}.
Example 2:

Input:
N=6, K=3
arr[] = {2, 1, 2, 1, 2, 1} 
Output: 
2 
1 2 
2 1 
1 2 
2 1
1 2
Explanation:
As total number of distinct values never
exceeds 2, you have to return only those two
values. In the case where frequency of 1 gets
equal with the frequency of 2, you have to 
keep 1 before 2 in the array.
Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function kTop() that takes array a, integer n and integer k as parameters and returns the array of arrays.

Expected Time Complexity: O(N*K).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N ≤ 104
1 ≤ K ≤ 102
1 ≤ a[i] ≤ 102 


'''


class Solution:
    def kTop(self, arr, N, K):
        final_ans=[]
      
        # list of size k + 1 to store elements 
        top = [0 for i in range(K + 1)] 
       
        # dictionary to keep track of frequency 
        freq = {i:0 for i in range(K + 1)} 
      
        # iterate till the end of stream 
        for m in range(N): 
      
            # increase the frequency 
            if a[m] in freq.keys(): 
                freq[a[m]] += 1
            else: 
                freq[a[m]] = 1
      
            # store that element in top vector 
            top[k] = a[m] 
       
            i = top.index(a[m]) 
            i -= 1
              
            while i >= 0: 
      
                # compare the frequency and swap if higher 
                # frequency element is stored next to it 
                if (freq[top[i]] < freq[top[i + 1]]): 
                    t = top[i] 
                    top[i] = top[i + 1] 
                    top[i + 1] = t 
                  
                # if frequency is same compare the elements 
                # and swap if next element is high 
                elif ((freq[top[i]] == freq[top[i + 1]]) and (top[i] > top[i + 1])): 
                    t = top[i] 
                    top[i] = top[i + 1] 
                    top[i + 1] = t 
                else: 
                    break
                i -= 1
              
            # print top k elements 
            i = 0
            ans = []
            while i < K and top[i] != 0: 
                ans.append(top[i]) 
                i += 1
            
            final_ans += [ans]
        return final_ans

