import java.util.*;
public class graph{
    public static void main(String[] args) {
        
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(1).add(0);      
        adj.get(1).add(4);
        adj.get(2).add(1);
        adj.get(3).add(4);
        adj.get(4).add(0);
        
        for (int i = 0; i < V; i++) {
           System.out.print("DFS starting from vertex " + i + ": ");
           for(int j=0; j < adj.get(i).size(); j++) {
              System.out.print(adj.get(i).get(j) + " ");
           }
           System.out.println();
        }
    }
}