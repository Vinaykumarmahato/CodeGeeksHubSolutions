/**
 * Given a string s, check if it is possible to convert it into a string that is the repetition of a substring of length k.
 * To convert, we will select two substrings, of length k starting at index i and j (zero-based indexing)
 * such that i and j are divisible by k, and we will replace one substring with the other.
 * 
 * Example 1:
 * Input:
 * N = 4
 * K = 2
 * S = "bdac"
 * Output: 1
 * Explanation: We can replace either "bd" with "ac" or "ac" with "bd".
 * 
 * Example 2:
 * Input: 
 * N = 5
 * K = 2
 * S = "abcde"
 * Output: 0
 * Explanation: Since n % k != 0, it's not possible to convert s into a string which is a concatenation of a substring with length k.
 * 
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function kSubstrConcat()
 * which takes a string s, its length n, and an integer k as inputs and return 1 if conversion of the given string is possible, else 0.
 * 
 * Expected Time Complexity: O(n).
 * Expected Auxiliary Space: O(n).
 * 
 * Constraints:
 * 2 <= k < n <= 105
 */
class Solution1
{
    int kSubstrConcat(int n, String s, int k)
    {
        // check if n is equal to k, then return 1
        if (n == k) return 1;
        
        // check if n is not divisible by k, then return 0
		if (n % k != 0) return 0;
		
		// create a HashMap to store substrings and their frequencies
		HashMap <String, Integer> m=new HashMap<>();
		
		// iterate over the string in increments of k
		for (int i = 0; i < n; i += k)
		{
			// store substring from i to i+k in HashMap with its frequency
			m.put(s.substring (i, i+k),m.getOrDefault(s.substring(i,i+k),0)+1);
		}

		// check if there is only one unique substring, then return 1
		if (m.size () == 1) return 1;
		
		// check if there are not exactly two unique substrings, then return 0
		if (m.size () != 2) return 0;

        int val=0;
        // get the frequency value of one substring
        for(int i:m.values()){
            val=i;
            break;
        }
        
		// check if the frequency value is equal to (n/k - 1) or 1, then return 1
		if ((val == (n / k - 1)) || (val == 1))
			return 1;
		
		// return 0 if none of the above conditions are satisfied
		return 0;
    }
}