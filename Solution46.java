class Solution
{
    //Function to check if a string is Pangram or not.
    public static boolean checkPangram  (String s) {
        // your code here
        int alpha[]=new int[26];
        String s1=s.toLowerCase();
        for(int i=0;i<s.length();i++){
            int ch=s1.charAt(i)-'a';
            if(ch>=0 && ch<=25){
                alpha[ch]++;
            }
        }
        for(int i=0;i<26;i++){
            if(alpha[i]==0)return false;
        }
        return true;
    }
}
