
/*
Given an array arr[] of length n. Find all possible unique permutations of the array in sorted order. A sequence A is greater than sequence B if there is an index i for which Aj = Bj for all j<i and Ai > Bi.

Example 1:

Input: 
n = 3
arr[] = {1, 2, 1}
Output: 
1 1 2
1 2 1
2 1 1
Explanation:
These are the only possible unique permutations
for the given array.
Example 2:

Input: 
n = 2
arr[] = {4, 5}
Output: 
Only possible 2 unique permutations are
4 5
5 4
Your Task:
You don't need to read input or print anything. You only need to complete the function uniquePerms() that takes an integer n, and an array arr of size n as input and returns a sorted list of lists containing all unique permutations of the array.

Expected Time Complexity:  O(n*n!)
Expected Auxilliary Space: O(n*n!)

Constraints:
1 ≤ n ≤ 9
1 ≤ arri ≤ 10

*/


class Solution {
    
    public static void generate(ArrayList<Integer> num, int start, ArrayList<ArrayList<Integer> > result, HashSet<ArrayList<Integer>> h) {
        
        if (start == num.size() - 1) {
            if(h.contains(num))
                return;
            
            ArrayList<Integer> perm = new ArrayList<>(num);
            
            h.add(perm);
            result.add(perm);
            return;
        } 
        
        Integer a, b;
        
        for (int i = start; i < num.size(); i++) {
            a = num.get(start);
            b = num.get(i);
            num.set(start, b);
            num.set(i, a);
            
            generate(num, start + 1, result, h);
            
            num.set(start, a);
            num.set(i, b);
        }
    }
    
    public static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr ,int n) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        
        if (arr.size() == 0)
            return result;
        
        generate(arr, 0, result, new HashSet<>());
        
        Collections.sort(result, (ArrayList<Integer> a, ArrayList<Integer> b) -> {
            int i = 0, l = Math.min(a.size(), b.size());
            
            while(i < l) {
                if(a.get(i).compareTo(b.get(i)) != 0)
                    return a.get(i).compareTo(b.get(i));
                i++;
            }
            
            return a.size() - b.size();
        });
        
        return result;
    }
}
