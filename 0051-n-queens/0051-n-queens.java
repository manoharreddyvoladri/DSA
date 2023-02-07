class Solution {
    List<List<String>> res= new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        //initialize an empty chessboard
        char[][] board = new char[n][n];
        for(char[] row: board){
            Arrays.fill(row,'.');
        }
        backtrack(board,0);
        return res;
    }
    void backtrack(char[][]board, int row){
        if(row==board.length){
            res.add(construct(board));
            return;
        }
        int col=board[row].length;
        for(int i=0;i<col;i++){
            if(!isValid(board,row,i)){
                continue;
            }
            board[row][i]='Q';
            backtrack(board, row+1);
            board[row][i]='.';
        }
    }
    boolean isValid(char[][]board,int row, int col){
        int n=board.length;
        //above
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //upper right diagonal
        for(int i=row-1, j=col+1; i>=0 && j<n; i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //upper left diagonal
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    List<String> construct (char[][] mat){
        List<String> board=new LinkedList<>();
        for(int i=0; i<mat.length;i++){
            String r=new String(mat[i]);
            board.add(r);
        }
        return board;
    }
}