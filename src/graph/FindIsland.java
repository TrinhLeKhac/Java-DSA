package graph;


// Given an mxn 2D binary grid, which represents a map of 1's (land) and 0's (water)
// Return the number of islands

// An island is surrounded by water and is formed by connecting adjacent lands (horizontally or vertically)
// You may assume all four edges of the grid are all surrounded by water

public class FindIsland {

    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int numberIslands = 0;  // number of ConnectedComponent
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {  // only interested in vertex equals '1' and not yet visited
                    dfs(grid, i, j, visited);
                    numberIslands++;  // increase connected-component count after find all vertex connected
                }
            }
        }
        return numberIslands;
    }

    public static void dfs (char[][] grid, int row, int col, boolean[][] visited) {
        if (
                row < 0 ||  // boundary condition ==> skip
                col < 0 ||  // boundary condition ==> skip
                row >= grid.length ||  // boundary condition ==> skip
                col >= grid[0].length ||  // boundary condition ==> skip
                grid[row][col] == '0' ||   // vertex '0' ==> skip
                visited[row][col]  // vertex already visited ==> skip
        ) {
            return;
        }
        visited[row][col] = true;  // mark true for vertex equals '1', not yet visited and within boundary condition
        dfs(grid, row, col - 1, visited); // go left
        dfs(grid, row - 1, col, visited); // go up
        dfs(grid, row, col + 1, visited); // go right
        dfs(grid, row + 1, col, visited); // go down
        // visited only updated by vertex equals '1'
    }
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0'},
                {'1', '0', '0', '0'},
                {'0', '0', '1', '0'},
                {'0', '0', '0', '1'},
        };
        System.out.println("----------------Find number of islands-----------------------");
        int numberIslands = numIslands(grid);
        System.out.println("Number of islands in grid is " + numberIslands);
    }
}
