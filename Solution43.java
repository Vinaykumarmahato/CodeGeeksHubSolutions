/*
Date:- 29/01/2024

*/





class Solution
{
   public int backtrack(String str, int currsum, int index, int[][]dp){
       
       if(index<0){
           return 1;
       }    
       
       int curr = 0;
       int ans = 0;
       
       if(dp[currsum][index]!=-1){
           return dp[currsum][index];
       }
       
       for(int i=index;i>=0;i--){
           
           curr += str.charAt(i)-'0';
           if(curr<=currsum){
               
               ans += backtrack(str,curr,i-1, dp);
           }
           
       }
       
       
       return dp[currsum][index] = ans;
   }
   
   public int TotalCount(String str)
   {
       int sum = 0;
       
       for(int i=0; i<str.length();i++){
           sum += str.charAt(i) - '0';
       }
       
       int[][]dp =new int[sum+1][str.length()+1];
       for(int[]i : dp){
           Arrays.fill(i,-1);
       }
       
       return backtrack(str, sum, str.length()-1, dp);
   }
}

