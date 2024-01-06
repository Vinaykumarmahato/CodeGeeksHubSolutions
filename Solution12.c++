# C++
# A Techfest is ongoing, and participants have unique ticket numbers.
# Organizers award prize points based on the sum of powers of prime factors of the ticket numbers.
# The points for a ticket number 'x' are the sum of powers in its prime factorization.

# For example, if a participant has ticket number 12, with prime factorization (2^2) * (3^1),
# the points awarded will be 2 + 1 = 3.

# Given a range of ticket numbers from 'a' to 'b' (inclusive),
# the task is to determine the sum of points awarded to participants within this range.

# Example 1:
# Input: a = 9, b = 12
# Output: 8
# Explanation:
# For 9: Prime factorization is 3^2, so the sum of powers is 2.
# For 10: Prime factorization is 2^1 * 5^1, so the sum of powers is 1 + 1 = 2.
# For 11: Prime factorization is 11^1, so the sum of powers is 1.
# For 12: Prime factorization is 2^2 * 3^1, so the sum of powers is 2 + 1 = 3.
# Total sum = 2 + 2 + 1 + 3 = 8.

# Example 2:
# Input: a = 24, b = 27
# Output: 11
# Explanation:
# For 24: Prime factorization is 2^3 * 3^1, so the sum of powers is 3 + 1 = 4.
# For 25: Prime factorization is 5^2, so the sum of powers is 2.
# For 26: Prime factorization is 13^1 * 2^1, so the sum of powers is 1 + 1 = 2.
# For 27: Prime factorization is 3^3, so the sum of powers is 3.
# Total sum = 4 + 2 + 2 + 3 = 11.

# Task:
# Implement the function sumOfPowers(a, b) which takes 'a' and 'b' as input parameters,
# and returns the sum of the power of primes that occur in the prime factorization
# of the numbers between 'a' to 'b' (inclusive).

# Expected Time Complexity: O(b * log(b))
# Expected Space Complexity: O(b * log(b))

# Constraints:
# 1 <= a <= b <= 2x10^5
# 1 <= b - a <= 10^5





class Solution {
public:
    int givecount(int x,vector<int> &v){
        int ans =0;
        for(int i=2;i<=x;i++){
            if(v[i]==0){
            int z =i;
            while(z<=x){
                ans+=x/z;
                z*=i;
                
            }
            }
        }
        return ans;
    }
    int sumOfPowers(int a, int b){
        vector<int>v(b+1,0);
        v[0] =1;
        v[1] =1;
        for(int i=2;i<=b;i++){
            if(v[i]==0){
            for(int j = i+i;j<=b;j+=i){
                v[j] = 1;
            }
            }
        }
        return givecount(b,v) - givecount(a-1,v);
    }
};
