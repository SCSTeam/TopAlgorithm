/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    if (grid === null || grid.length === 0 || grid[0].length === 0) {
        return 0;
    }
    
    let visited = [];
    for (let i = 0; i < grid.length; i++) visited[i] = [];
    
    let count = 0;
    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[0].length; j++) {
            if (grid[i][j] === '1' && !visited[i][j]) {
                count += 1;
                bfs(grid, visited, i, j);
            }
        }
    }
    
    return count;
};

var bfs = (grid, visited, rowIdx, colIdx) => {
    let q = [];
    q.push([rowIdx, colIdx]);
    while (q.length > 0) {
        let cur = q.shift();
        let i = cur[0], j = cur[1];
        visited[i][j] = true;
        
        // up
        if (i > 0 && grid[i - 1][j] === '1' && !visited[i - 1][j]) {
            q.push([i - 1, j]);
        }
        // down
        if (i < grid.length - 1 && grid[i + 1][j] === '1' && !visited[i + 1][j]) {
            q.push([i + 1, j]);
        }
        // left
        if (j > 0 && grid[i][j - 1] === '1' && !visited[i][j - 1]) {
            q.push([i, j - 1]);
        }
        // right
        if (j < grid.length - 1 && grid[i][j + 1] === '1' && !visited[i][j + 1]) {
            q.push([i, j + 1]);
        }
    }
};

(() => {
    let grid = [["1","1","0","0","0"],
                ["1","1","0","0","0"],
                ["0","0","1","0","0"],
                ["0","0","0","1","1"]];
    let num = numIslands(grid);
    debugger;
})();