class Solution {
    public int findCircleNum(int[][] graph) {
        int n = graph.length;

        boolean[] visited = new boolean[n];
        int answer = 0;

        for(int currentCity=0; currentCity < n; currentCity++){
            if(visited[currentCity] == false){
                bfs(graph, currentCity, n, visited);
                answer += 1;
            }
        }
        return answer;
    }
    private void bfs(int[][] graph, int currentCity, int n, boolean[] visited){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(currentCity);

        while(!queue.isEmpty()){
            int currentIndex  = queue.remove();
            if(visited[currentIndex])
              continue;

            visited[currentIndex] = true;
            int[] neighbors = graph[currentIndex];

            for(int i=0; i<n; i++){
                if(neighbors[i] == 1)
                 queue.add(i);
            }  
        }
        
    }
}
