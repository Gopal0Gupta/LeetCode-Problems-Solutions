import java.lang.reflect.Array;
import java.util.Arrays;

public class Solutions {
    public static boolean isSafe(String[][] board, int row, int col, int number) {
        //row and column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col].equals(String.valueOf(number))) {
                return false;
            }
        }
        for (int j=0;j<board.length;j++){
            if (board[row][j].equals(String.valueOf(number))) {
                return false;
            }
        }
        //grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j].equals(String.valueOf(number))) {
                    return false;
                }
            }
        }
    return true;
    }
    public static boolean helper(String[][] board,int row,int col){
        if (row== board.length){
            return true;
        }
        int nrow,ncol;
        if(col!= board.length-1){
            nrow = row;
            ncol = col+1;
        }else {
            ncol = 0;
            nrow = row+1;
        }
        if (board[row][col]!="."){
            if(helper(board,nrow,ncol)){
                return true;
            }
        }else {
            for(int i = 1 ;i<=9;i++){
                if(isSafe(board,row,col,i)){
                    board[row][col]=(String) (i+"");
                    if(helper(board,nrow,ncol)){
                        return true;
                    }
                    else {
                        board[row][col]=".";
                    }
                }
            }
        }
        return false;
    }
    public static void solveSuduko(String[][] board){
        helper(board,0,0);
    }
    public static void main(String[] args){
        String[][] board = {{"5","3",".",".","7",".",".",".","."},{"6",".",".","1","9","5",".",".","."},{".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},{"4",".",".","8",".","3",".",".","1"},{"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},{".",".",".","4","1","9",".",".","5"},{".",".",".",".","8",".",".","7","9"}};
        solveSuduko(board);
        // Print the solved Sudoku board
        for (String[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
