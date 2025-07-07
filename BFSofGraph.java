import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// This code implements Breadth First Search (BFS) for a graph represented as an adjacency list.
// The BFS starts from vertex 0 and explores all reachable vertices, storing the result in an   
// ArrayList.
// The method `bfs` initializes the process, using a queue to manage the vertices to be visited.
// The `isVisited` array keeps track of which vertices have been visited to avoid cycles
// The result is a list of vertices in the order they were visited during the BFS traversal.
// GFG Question: https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
// Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges.
// Space Complexity: O(V) for the visited array and the result list.

public class BFSofGraph {
     public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        final int V = adj.size();
        boolean isVisited[] = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        isVisited[0]= true;
        while(!queue.isEmpty()){
            int current = queue.poll();
            result.add(current);
            for(int neighbour: adj.get(current)){
                if(!isVisited[neighbour]){
                    queue.add(neighbour);
                    isVisited[neighbour]=true;
                }
            }
        }
        return result;
    }
}
