class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int: 

        q  = deque() 

        for i in range(len(grid)):
            for j in range(len(grid[0])): 
                if grid[i][j]==2:
                    q.append((i,j)) 

        vis , res = set() , 0 

        while q:

            for _ in range(len(q)):

                x , y = q.popleft()
                vis.add((x,y))
                if x>0 and grid[x-1][y]==1 and (x-1,y) not in vis: 
                    grid[x-1][y] = 2
                    vis.add((x-1,y)) 
                    q.append((x-1,y)) 

                if y>0 and grid[x][y-1] == 1 and (x,y-1) not in vis: 
                    grid[x][y-1] = 2
                    vis.add((x,y-1)) 
                    q.append((x,y-1)) 

                if x<len(grid)-1 and grid[x+1][y]==1 and (x+1,y) not in vis: 
                    grid[x+1][y] = 2
                    vis.add((x+1,y)) 
                    q.append((x+1,y))

                if y<len(grid[0])-1 and grid[x][y+1]==1 and (x,y+1) not in vis:
                    grid[x][y+1] = 2
                    vis.add((x,y+1)) 
                    q.append((x,y+1))  

            res+=1 
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==1:
                    return -1 

        return res-1 if res!=0 else 0