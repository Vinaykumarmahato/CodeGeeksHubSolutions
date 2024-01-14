/*
Given a boolean matrix of size RxC where each cell contains either 0 or 1, find the row numbers (0-based) of row which already exists or are repeated.

Example 1:

Input:
R = 2, C = 2
matrix[][] = {{1, 0},
            {1, 0}}
Output: 
1
Explanation:
Row 1 is duplicate of Row 0.
Example 2:

Input:
R = 4, C = 3
matrix[][] = {{ 1, 0, 0},
            { 1, 0, 0},
            { 0, 0, 0},
            { 0, 0, 0}}
Output: 
1 3 
Explanation:
Row 1 and Row 3 are duplicates of Row 0 and 2 respectively. 
Your Task:
You dont need to read input or print anything. Complete the function repeatedRows() that takes the matrix as input parameter and returns a list of row numbers which are duplicate rows.

Expected Time Complexity: O(R * C)
Expected Auxiliary Space: O(R * C)

Constraints:
1 ≤ R, C ≤ 103
0 ≤ matrix[i][j] ≤ 1
*/


class Solution {
    /* Trie Node */
    static class Trie {
        boolean leaf;
        Trie[] children;

        Trie() {
            children = new Trie[2];
            leaf = false;
        }
    }

    /* Function to insert a row in Trie */
    static boolean insert(Trie head, int[] arr, int N) {
        Trie curr = head;

        for (int i = 0; i < N; i++) {
            /* Creating a new path if it does not exist */
            if (curr.children[arr[i]] == null)
                curr.children[arr[i]] = new Trie();

            curr = curr.children[arr[i]];
        }

        /* If the row already exists, return false */
        if (curr.leaf)
            return false;

        /* Making the leaf node true and returning true */
        return (curr.leaf = true);
    }

    public static ArrayList<Integer> repeatedRows(int[][] matrix, int m, int n) {
        Trie head = new Trie();
        ArrayList<Integer> ans = new ArrayList<>();

        /* Inserting into Trie and checking for duplicates */
        for (int i = 0; i < m; i++)

            // If already exists
            if (!insert(head, matrix[i], n))
                ans.add(i);

        return ans;
    }
}
