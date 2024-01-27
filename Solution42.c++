



class Solution {
public:
    string matrixChainOrder(int p[], int n) {
        // Create a 2D table to store minimum multiplications
        int dp[n][n];
        
        // Parenthesis order to store the optimal order
        char order[n][26];  // Fix the size of the array
        
        // Initialize the dp table
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }
        
        // Fill the table using bottom-up approach
        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = INT_MAX;
                
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        order[i][j] = 'A' + k - 1; // Store the optimal split point
                    }
                }
            }
        }
        
        // Reconstruct the optimal order
        string result = "";
        printOrder(order, 1, n - 1, result);
        //cout<<result<<endl;
        return result;
    }

private:
    void printOrder(char order[][26], int i, int j, string &result) {
        if (i == j) {
            result += ('A' + i - 1);
            return;
        }
        
        result += '(';
        printOrder(order, i, order[i][j] - 'A' + 1, result);
        printOrder(order, order[i][j] - 'A' + 2, j, result);
        result += ')';
    }
};





