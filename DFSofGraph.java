import java.util.ArrayList;

// This code implements Depth First Search (DFS) for a graph represented as an adjacency list.
// The DFS starts from vertex 0 and explores all reachable vertices, storing the result in an ArrayList.
// The method `dfs` initializes the process, while the `helper` method performs the recursive DFS traversal.
// The `visited` array keeps track of which vertices have been visited to avoid cycles and redundant visits.
// The result is a list of vertices in the order they were visited during the DFS traversal.    
// GFG Question: https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1        
// Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges.
// Space Complexity: O(V) for the visited array and the result list.        

public class DFSofGraph {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        final int V = adj.size();
        
        ArrayList<Integer> dfsResult = new ArrayList<>();
        boolean visited[]= new boolean[V];
        helper(0,adj, visited, dfsResult);
        return dfsResult;
    }
    void helper(int node ,ArrayList<ArrayList<Integer>> adj, boolean []visited,ArrayList<Integer> result ){
        //mark the 1st vertex as visited;
        visited[node]= true;
        result.add(node);
        //explore the neighbour(nb)
        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]){
                helper(neighbour,adj, visited, result);
            }
        }
        
    }
}
