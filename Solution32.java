
/*
Vertex cover of an undirected graph is a list of vertices such that every vertex not in the vertex cover shares their every edge with the vertices in the vertex cover. In other words, for every edge in the graph, atleast one of the endpoints of the graph should belong to the vertex cover. You will be given an undirected graph G, and your task is to determine the smallest possible size of a vertex cover.

Example 1:

Input:
N=5
M=6
edges[][]={{1,2}
           {4, 1},
           {2, 4},
           {3, 4},
           {5, 2},
           {1, 3}}
Output:
3
Explanation:
{2, 3, 4} forms a vertex cover
with the smallest size.
Example 2:

Input:
N=2
M=1
edges[][]={{1,2}} 
Output: 
1 
Explanation: 
Include either node 1 or node 2
in the vertex cover.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function vertexCover() which takes the edge list and an integer n for the number of nodes of the graph as input parameters and returns the size of the smallest possible vertex cover.

Expected Time Complexity: O(M*N2log(N))
Expected Auxiliary Space: O(N2)

 Constraints:
1 <= N <= 16
1 <= M <= N*(N-1)/2
1 <= edges[i][0], edges[i][1] <= N

*/


class Solution {
    public static int vertexCover(int n, int m, int[][] edges) 
    {
        int g[][]= new int[n][n];
        for(int i= 0; i<m; i++){
            g[edges[i][0]-1][edges[i][1]-1]= 1;
            g[edges[i][1]-1][edges[i][0]-1]= 1;
        }
        
        return findCover(n, m, g);
    }
    
    public static int findCover(int n, int m, int[][] g){
        int l= 1;
        int h= n;
        while(l<h){
            int mid= (l+h)/2;
            if(checkEdges(n, mid, m, g)==false){
                l= mid+1;
            }
            else{
                h= mid;
            }
        }
        
        return l;
    }
    
    public static boolean checkEdges(int n, int k, int m, int[][] g){
        int set= (1<<k)-1;
        int limit= 1<<n;
        
        while(set<limit){
            
            boolean visited[][]= new boolean[n][n];
            int count= 0;
            
            for(int i= 1, j= 1; i<limit; i= i<<1, j++ ){
                if((set&i)!=0){
                    for(int v= 0; v<n; v++){
                        if(g[j-1][v]==1 && !visited[j-1][v]){
                            visited[j-1][v]= true;
                            visited[v][j-1]= true;
                            count++;
                        }
                    }
                }
            }
            
            if(count==m){
                return true;
            }
            
            int co= set & -set;
            int ro= set + co;
            set= (((ro^set)>>2)/co)|ro;
        }
        
        return false;
    }
}     
