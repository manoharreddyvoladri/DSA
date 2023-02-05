class Solution(object):
    global n
    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        rows = [[True for v in range(9)] for x in range(9)]
        cols = [[True for v in range(9)] for y in range(9)]
        boxes = [[True for v in range(9)] for y in range(9)]
        boxInd = { (0,0) : 0, (0,1) : 1, (0,2) : 2, (1,0) : 3, (1,1) : 4, (1,2) : 5, (2,0) : 6, (2,1) : 7, (2,2) : 8 }
        unfilled = []
        for x in range(9):
            for y in range(9):
                if board[x][y] == ".":
                    unfilled.append((x, y, boxInd[(x/3,y/3)]))
                else:
                    v = int(board[x][y])-1
                    rows[x][v] = False
                    cols[y][v] = False
                    boxes[boxInd[(x/3,y/3)]][v] = False
        
        self.n = len(unfilled)
        self.solve(board, rows, cols, boxes, unfilled, 0)
        return board
    
    def solve(self, board, rows, cols, boxes, unfilled, ui):
        """
        :type board: List[List[str]]
        :type rows: List[List[bool]]
        :type cols: List[List[bool]]
        :type boxes: List[List[bool]]
        :type unfilled: List[(int, int, int)]
        :type ui: int
        :rtype: bool
        """
        if self.n <= ui:
            return True
        
        x = unfilled[ui][0]
        y = unfilled[ui][1]
        z = unfilled[ui][2]
        for v in range(9):
            if not rows[x][v] or not cols[y][v] or not boxes[z][v]:
                continue
        
            self.setBoard(board, rows, cols, boxes, x, y, z, v, False)
            if self.solve(board, rows, cols, boxes, unfilled, ui+1):
                return True

            self.setBoard(board, rows, cols, boxes, x, y, z, v, True)
        
        return False

    def setBoard(self, board, rows, cols, boxes, x, y, z, v, reset):
        """
        :type board: List[List[str]]
        :type rows: List[List[bool]]
        :type cols: List[List[bool]]
        :type boxes: List[List[bool]]
        :type x: int
        :type y: int
        :type z: int
        :type v: int
        :type reset: bool
        :rtype: bool
        """
        rows[x][v] = reset
        cols[y][v] = reset
        boxes[z][v] = reset
        board[x][y] = "." if reset else str(v+1)