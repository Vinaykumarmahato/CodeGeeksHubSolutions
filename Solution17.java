/*

Given a non-negative integer S represented as a string, remove K digits from the number so that the new number is the smallest possible.
Note : The given num does not contain any leading zero.

Example 1:

Input:
S = "149811", K = 3
Output: 
111
Explanation: 
Remove the three digits 
4, 9, and 8 to form the new number 111
which is smallest.
Example 2:

Input:
S = "1002991", K = 3
Output: 
21
Explanation: 
Remove the three digits 1(leading
one), 9, and 9 to form the new number 21(Note
that the output must not contain leading
zeroes) which is the smallest.
Your Task:
You don't need to read input or print anything. Your task is to complete the function removeKdigits() which takes the string S and an integer K as input and returns the new number which is the smallest possible.

Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(|S|).

Constraints:
1<= K <= |S|<=106



*/

class Solution {
    public String removeKdigits(String S, int K) {
        // treat ans as a stack in below for loop
        ArrayList<Character> ans = new ArrayList<Character>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            while (ans.size() > 0 && ans.get(ans.size() - 1) > c && K > 0) {
                ans.remove(ans.size() -
                           1); // make sure digits in ans are in ascending order
                K--;           // remove one char
            }

            if (ans.size() > 0 || c != '0') {
                ans.add(c);
            } // can't have leading '0'
        }

        while (ans.size() > 0 && K-- > 0) {
            ans.remove(ans.size() - 1);
        } // make sure remove k digits in total

        if (ans.size() == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        // Appends characters one by one
        for (Character ch : ans) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
