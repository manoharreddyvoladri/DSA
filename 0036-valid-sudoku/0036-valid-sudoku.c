bool check(int *arr){
    for(int i = 49; i < 58; i++)
        if(arr[i] > 1)
            return false;
    return true;
}
bool isValidSudoku(char** board, int bSize, int* colSize){
    for(char row = 0; row < bSize; row++){
        int chs[58] = {0};
        for(char col = 0; col < colSize[row]; col++)
            chs[board[row][col]]++;
        if(!check(chs))
            return false;
    }
    for(char col = 0; col < 9; col++){
        int chs[58] = {0};
        for(char row = 0; row < bSize; row++)
            chs[board[row][col]]++;
        if(!check(chs))
            return false;
    }
    for(int sqRow = 0; sqRow < 3; sqRow++){
        for(int sqCol = 0; sqCol < 3; sqCol++){
            int chs[58] = {0};
            for(char row = sqRow * 3; row < 3 + sqRow * 3; row++){
                for(char col = sqCol * 3; col < 3 + sqCol * 3; col++)
                    chs[board[row][col]]++;
            }
            if(!check(chs))
                return false;
        }
    }
    return true;
}