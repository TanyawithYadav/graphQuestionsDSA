import java.util.ArrayList;
import java.util.Stack;

//https://www.geeksforgeeks.org/problems/topological-sort/1
// Topological Sort using DFS
// This code performs a topological sort on a directed acyclic graph (DAG) using depth-first search (DFS).
// It converts the edge list representation of the graph into an adjacency list, performs DFS to visit

public class topologicalSort {
     public  ArrayList<Integer> topoSort(int V, int[][] edges) {
        
        ArrayList<Integer> result = new ArrayList<>();
        
        // step 1: convert matrix to adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i= 0;i<V; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u= edge[0];
            int v= edge[1];
            graph.get(u).add(v);
        }
        
        // step 2: visited array
        boolean[] visited = new boolean[V];
        
        // step 3: stack
        Stack<Integer> stack = new Stack<>();
        
        // step 4: DFS of all node & pop and store in arrayList for output
        for(int i =0; i<V; i++){
            if(!visited[i]){
                dfs(i, visited, graph, stack);
            }
        }
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
        
    }
    void dfs(int currentNode, boolean[] visited, ArrayList<ArrayList<Integer>> graph, Stack<Integer> stack){
        visited[currentNode] = true;
        for(int neighbour: graph.get(currentNode)){
            if(!visited[neighbour]){
                dfs(neighbour, visited, graph, stack);
            }
        }
        stack.push(currentNode);
    }
}
