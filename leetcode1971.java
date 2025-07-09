import java.util.ArrayList;
import java.util.List;

// Leetcode 1971: Find if Path Exists in Graph
// https://leetcode.com/problems/find-if-path-exists-in-graph/

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        //get the edges
        for(int[]edge:edges){
            int u=edge[0];
            int v=edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean visited[] = new boolean[n];
        return dfs(source, destination, graph, visited);
    }
    boolean dfs(int currentNode, int dest, List<List<Integer>> graph, boolean visited[]){
        if(currentNode ==dest){
            return true;
        }
        visited[currentNode] = true;
        for(int nei:graph.get(currentNode)){
            if(!visited[nei]){
                if(dfs(nei, dest, graph, visited)){
                    return true;
                }
            }
        }
        return false;
    }
}