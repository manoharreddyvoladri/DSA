class Solution {
    public char[][] b;
    public boolean[][] visitedRow=new boolean[9][10];
    public boolean[][] visitedCol=new boolean[9][10];
    public boolean[][][] visitedBlock=new boolean[3][3][10];

    public boolean backtracking(int step)
    {
        if (step==81) return true;
        int R=step/9;
        int C=step%9;
        if (b[R][C]!='.') return backtracking(step+1);
        for (int i=1;i<=9;i++)
        {
            if (visitedRow[R][i]==false && visitedCol[C][i]==false && visitedBlock[R/3][C/3][i]==false)
            {
                visitedRow[R][i]=true;
                visitedCol[C][i]=true;
                visitedBlock[R/3][C/3][i]=true;
                b[R][C]=(char)(i+'0');
                boolean res=backtracking(step+1);
                if (res) return true;
                visitedRow[R][i]=false;
                visitedCol[C][i]=false;
                visitedBlock[R/3][C/3][i]=false;
                b[R][C]='.';
            }
        }
        return false;

    }

    public void solveSudoku(char[][] board) 
    {
        b=board;
        boolean[][] vR=visitedRow;
        boolean[][] vC=visitedCol;
        boolean[][][] vB=visitedBlock;
        for (int r=0;r<9;r++)
        {
            for (int c=0;c<9;c++)
            {
                if (b[r][c]!='.')
                {
                    int t=b[r][c]-'0';
                    visitedRow[r][t]=true;
                    visitedCol[c][t]=true;
                    visitedBlock[r/3][c/3][t]=true;
                }
            }
        }
        boolean res=backtracking(0);  
        return;  
    }
}