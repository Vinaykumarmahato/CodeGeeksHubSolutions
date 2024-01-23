/*
There are a total of n tasks you have to pick, labelled from 0 to n-1. Some tasks may have prerequisite tasks, for example to pick task 0 you have to first finish tasks 1, which is expressed as a pair: [0, 1]
Given the total number of n tasks and a list of prerequisite pairs of size m. Find a ordering of tasks you should pick to finish all tasks.
Note: There may be multiple correct orders, you just need to return any one of them. If it is impossible to finish all tasks, return an empty array. Driver code will print "No Ordering Possible", on returning an empty array. Returning any correct order will give the output as 1, whereas any invalid order will give the output 0. 

Example 1:

Input:
n = 2, m = 1
prerequisites = {{1, 0}}
Output:
1
Explanation:
The output 1 denotes that the order is valid. So, if you have, implemented your function correctly, then output would be 1 for all test cases. One possible order is [0, 1].
Example 2:

Input:
n = 4, m = 4
prerequisites = {{1, 0},
               {2, 0},
               {3, 1},
               {3, 2}}
Output:
1
Explanation:
There are a total of 4 tasks to pick. To pick task 3 you should have finished both tasks 1 and 2. Both tasks 1 and 2 should be pick after you finished task 0. So one correct task order is [0, 1, 2, 3]. Another correct ordering is [0, 2, 1, 3]. Returning any of these order will result in an output of 1.
Your Task:
The task is to complete the function findOrder() which takes two integers n, and m and a list of lists of size m*2 denoting the prerequisite pairs as input and returns any correct order to finish all the tasks. Return an empty array if it's impossible to finish all tasks.

Expected Time Complexity: O(n+m).
Expected Auxiliary Space: O(n+m).
 
Constraints:
1 ≤ n ≤ 105
0 ≤ m ≤ min(n*(n-1),105)
0 ≤ prerequisites[i][0], prerequisites[i][1] < n
All prerequisite pairs are unique
prerequisites[i][0] ≠ prerequisites[i][1]

*/




class Solution
{
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        //create Graph 
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            map.get(prerequisites.get(i).get(0)).add(prerequisites.get(i).get(1));
        }
        
        int indeg[] = new int[n];
        for(int i=0;i<map.size();i++){
            for(Integer it : map.get(i)){
                indeg[it]++;
            }
        }
        
        //BFS start
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indeg.length;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        int ans[] = new int[n];
        int count=0;
        int cycle = 0;
        while(!q.isEmpty() && cycle<n){
            cycle++;
            int val = q.poll();
            ans[count++] = val;
            for(Integer it : map.get(val)){
                indeg[it]--;
                if(indeg[it]==0){
                    q.add(it);
                }
            }
        }
        //checking graph contain cycle or not.
        if(cycle<n){//if cycle contain then {ordering not possible}
            int pos[] = {};
            return pos;
        }
        
        //return out according to the question.
        for(int i=0;i<n/2;i++){
            int temp = ans[i];
            ans[i] = ans[n-i-1];
            ans[n-i-1] = temp;
        }

        return ans;
    }
}
