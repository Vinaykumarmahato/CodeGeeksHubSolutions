/* 

GeeksforGeeks has introduced a special offer where you can enroll in any course, and if you manage to complete 90% of the course within 90 days, you will receive a refund of 90%.

Geek was fascinated by this offer. This offer was valid for only n days, and each day a new course was available for purchase. Geek decided that if he bought a course on some day, he will complete that course on the same day itself and redeem floor[90% of cost of the course] amount back. Find the maximum number of courses that Geek can complete in those n days if he had total amount initially.

Note: On any day, Geek can only buy the new course that was made available for purchase that day.

Example 1:

Input:
n = 2
total = 10
cost = [10, 9]
Output: 2
Explanation: 
Geek can buy the first course for 10 amount, 
complete it on the same date and redeem 9 back. 
Next, he can buy and complete the 2nd course too.
Example 2:

Input:
n = 11
total = 10
cost = [10, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
Output: 10
Explanation: 
Geek can buy and complete all the courses that cost 1.
Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function max_courses() that takes N the number of days, the total amount, and the cost array as input argument and return the maximum amount of courses that could be purchased.

Expected Time Complexity: O(n*total)
Expected Auxiliary Space: O(n*total)

Constraints:
1 <= n <= 1000
0 <= total <= 1000
1 <= cost[i] <= 1000

*/



class Solution {
    private int dpf(int i, int j, int[][] dp, int[] cost) {
        if (i == dp.length) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        dp[i][j] = dpf(i + 1, j, dp, cost);
        if (j >= cost[i]) {
            dp[i][j] = Math.max(dp[i][j], 1 + dpf(i + 1, j - cost[i] + ((9 * cost[i]) / 10), dp, cost));
        }
        return dp[i][j];
    }

    public int max_courses(int n, int total, int[] cost) {
        int[][] dp = new int[n][total + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dpf(0, total, dp, cost);
    }
}
