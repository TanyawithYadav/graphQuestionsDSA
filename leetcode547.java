public class leetcode547 {

    // Leetcode 547: Number of Provinces
    // https://leetcode.com/problems/number-of-provinces/


     public int findCircleNum(int[][] isConnected) {
        //isConnected[i][j]=1;
        //isConnected[i][j]=0;

        int numberOfCities = isConnected.length;
        boolean []visited=new boolean[numberOfCities];
        int count =0;
        for(int i=0;i<numberOfCities;i++){
            if(!visited[i]){
                dfs(i, isConnected, visited );
                //backtrack
                count++;
            }
        }
        return count;
    }
    void dfs(int currentCity, int[][] isConnected, boolean[] visited){
        visited[currentCity]=true;
        for(int neighbour=0; neighbour < isConnected.length; neighbour++){
            if(isConnected[currentCity][neighbour]==1 && !visited[neighbour]){
                dfs(neighbour, isConnected, visited);
            }
        }
    }
}
