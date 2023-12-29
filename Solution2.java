/**
 * Given an unsorted array A of size N that contains only non-negative integers,
 * find a continuous sub-array that adds to a given number S and return the left and right index (1-based indexing) of that subarray.
 *
 * In case of multiple subarrays, return the subarray indexes which come first on moving from left to right.
 *
 * Note:- You have to return an ArrayList consisting of two elements left and right.
 * In case no such subarray exists, return an array consisting of element -1.
 *
 * Example 1:
 * Input:
 * N = 5, S = 12
 * A[] = {1, 2, 3, 7, 5}
 * Output: [2, 4]
 * Explanation: The sum of elements
 * from the 2nd position to the 4th position
 * is 12.
 *
 * Example 2:
 * Input:
 * N = 10, S = 15
 * A[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
 * Output: [1, 5]
 * Explanation: The sum of elements
 * from the 1st position to the 5th position
 * is 15.
 *
 * Your Task:
 * You don't need to read input or print anything.
 * The task is to complete the function subarraySum()
 * which takes arr, N, and S as input parameters
 * and returns an ArrayList containing the starting and ending positions
 * of the first occurring subarray from the left where the sum equals to S.
 * The two indexes in the array should be according to 1-based indexing.
 * If no such subarray is found, return an array consisting of only one element that is -1.
 *
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(1)
 *
 * Constraints:
 * 1 <= N <= 105
 * 0 <= Ai <= 109
 * 0 <= S <= 109
 */
class Solution2
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        int start = 0;
        int last = 0;
        boolean flag=false;
        int currsum=0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        
         //iterating over the array.
        for(int i=0;i<n;i++)
        {
            //storing sum upto current element.
            currsum+= arr[i];
            
            //checking if current sum is greater than or equal to given number.
            if(currsum>=s)
            {
                last=i;
                //we start from starting index till current index and do the 
                //excluding part while s(given number) < currsum.
                while(s<currsum && start<last)
                {
                    //subtracting the element from left i.e., arr[start]
                    currsum-= arr[start];
                    ++start;
                }
                
                //now if current sum becomes equal to given number, we store 
                //the starting and ending index for the subarray.
                if(currsum==s)
                {
                    res.add(start + 1);
                    res.add(last + 1);
                    
                    //flag is set to true since subarray exists.
                    flag = true;
                    break;
                }
            }
        }
        //if no subarray is found, we store -1 in result else the found indexes.
        if (flag==false) {
            res.add(-1);
        } 
        //returning the result.
        return res;    
    }
}
