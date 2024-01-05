
/*
There is a road passing through a city with N plots on both sides of the road. Plots are arranged in a straight line on either side of the road. Determine the total number of ways to construct buildings in these plots, ensuring that no two buildings are adjacent to each other. Specifically, buildings on opposite sides of the road cannot be adjacent.

Using * to represent a plot and || for the road, the arrangement for N = 3 can be visualized as follows: * * * || * * *.

Note: As the answer can be very large, print it mod 109+7.

Example 1:

Input: N = 1
Output: 4
Explanation: 
Possible ways for the arrangement are B||*, *||B, B||B, *||*
where B represents a building.
Example 2:

Input: N = 3
Output: 25
Explanation: 
Possible ways for one side are BSS, BSB, SSS, SBS,
SSB where B represents a building and S
represents an empty space. Pairing up with 
possibilities on the other side of the road,
total possible ways are 25.
Your Task:
You don't need to read or print anything. Your task is to complete the function TotalWays() which takes N as input parameter and returns the total possible ways modulo 109 + 7.
 

Expected Time Complexity: O(N)
Expected Space Complexity: O(N)
 

Constraints:
1 <= N <= 100000

*/


class Solution{
    public int TotalWays(int N)
    {
        long mod = 1000000007;
		long [] f = new long[N+1];
		f[0] = f[1] = 1;
		for(int i = 2; i <= N; i++)
			f[i]  = (f[i-1]%mod + f[i-2]%mod)%mod; // calculating Fibonacci numbers using dynamic programming
		long x = (f[N] + f[N-1])%mod; // calculating the sum of the last two Fibonacci numbers
		x = x * x; // squaring the sum
		x %= mod; // taking modulo
		return (int)x; // returning the result as an integer
    }
}
