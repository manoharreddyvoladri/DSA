class Solution(object):
    def dfs(self,grid,i,j):
            if grid[i][j] != 1:
                return 0
            area = 1
            grid[i][j] = 0
            if i-1 >= 0 and grid[i-1][j] == 1:
                area += self.dfs(grid,i-1,j)
            if i+1 < len(grid) and grid[i+1][j] == 1:
                area += self.dfs(grid,i+1,j)
            if j-1 >= 0  and grid[i][j-1] == 1:
                area += self.dfs(grid,i,j-1)
            if j+1 < len(grid[0]) and grid[i][j+1] == 1:
                area += self.dfs(grid,i,j+1)
            return area
    def maxAreaOfIsland(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        max_area = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    area = self.dfs(grid,i,j)
                    max_area = max([area,max_area])
        return max_area