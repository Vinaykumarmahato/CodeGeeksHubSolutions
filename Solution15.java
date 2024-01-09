
/*
Given two strings, one is a text string, txt and other is a pattern string, pat. The task is to print the indexes of all the occurences of pattern string in the text string. Use one-based indexing while returing the indices. 
Note: Return an empty list incase of no occurences of pattern. Driver will print -1 in this case.

Example 1:

Input:
txt = "geeksforgeeks"
pat = "geek"
Output: 
1 9
Explanation: 
The string "geek" occurs twice in txt, one starts are index 1 and the other at index 9. 
Example 2:

Input: 
txt = "abesdu"
pat = "edu"
Output: 
-1
Explanation: 
There's not substring "edu" present in txt.
Your Task:
You don't need to read input or print anything. Your task is to complete the function search() which takes the string txt and the string pat as inputs and returns an array denoting the start indices (1-based) of substring pat in the string txt. 

Expected Time Complexity: O(|txt|).
Expected Auxiliary Space: O(|txt|).

Constraints:
1 ≤ |txt| ≤ 105
1 ≤ |pat| < |S|
Both the strings consists of lowercase English alphabets.

*/

class Solution {
    // Function to compute the Longest Proper Prefix which is also Suffix (LPS) array
    void computeLPSArray(String pat, int M, int[] lps) {
        int len = 0; // length of the previous longest prefix suffix 
        int i;

        lps[0] = 0; // lps[0] is always 0
        i = 1; // start from the second character

        // Loop to compute the LPS array
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    // Function to search for the pattern in the given text
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int M = pat.length();
        int N = txt.length();

        int[] lps = new int[M + 1]; // lps array to store Longest Proper Prefix which is also Suffix

        int j = 0; // index for pattern

        computeLPSArray(pat, M, lps); // compute the LPS array

        int f = 0; // flag to track if the pattern was found
        int i = 0; // index for text

        // Loop to search for the pattern in the text
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }

            if (j == M) {
                f++; // increment the flag
                res.add(i - j + 1); // add the index where the pattern is found to the result list
                j = lps[j - 1]; // update j to continue searching for more occurrences of the pattern
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1]; // update j based on lps array
                else
                    i = i + 1; // increment i if j is 0
            }
        }

        if (f == 0)
            res.add(-1); // add -1 to the result list if the pattern was not found

        return res; // return the result list
    }
}
