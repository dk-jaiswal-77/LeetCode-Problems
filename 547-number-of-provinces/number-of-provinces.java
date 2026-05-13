class Solution {
    private void dfs(int node, int[] visitedArr, ArrayList<Integer>[] adjList) {
        visitedArr[node] = 1;
        for (Integer adjNode : adjList[node]) {
            if (visitedArr[adjNode] == 0) dfs(adjNode, visitedArr, adjList);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        // 0 based indexing graph
        // convert adjacency matrix to adjacency list
        int n = isConnected.length;
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    adjList[i].add(j);
                }
            }
        }

        // main logic
        int[] visitedArr = new int[n];
        int count = 0;
        for (int node = 0; node < n; node++) {
            if (visitedArr[node] == 0) {
                count++;
                dfs(node, visitedArr, adjList);
            }
        }
        return count;
    }
}