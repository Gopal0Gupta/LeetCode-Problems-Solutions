import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static Boolean isSafe(int row,int col,char[][] board) {
        //verticle
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        //horizontal
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }
        //upper left
        int r = row;
        for (int c = col; c >= 0 && r >= 0; c--, r--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        //upper right
        r = row;
        for (int c = col; c < board.length && r >= 0; r--, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        //lower left
        r = row;
        for (int c = col; c >= 0 && r < board.length; r++, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        //lower right
        for (int c = col; c < board.length && r < board.length; c++, r++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        return true;
    }
    public static void saveBoard(char[][] board, List<List<String>> allBoards) {
        String row = "";
        List<String> newBoard = new ArrayList<>();
        for(int i=0; i<board.length; i++) {
            row = "";
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == 'Q')
                    row += 'Q';
                else
                    row += '.';
            }
            newBoard.add(row);
        }
        allBoards.add(newBoard);
    }
    public static void helper(char[][] board,List<List<String>> allBoards,int col){
        for(int row=0;row<board.length;row++) {
            if(col==board.length){
                saveBoard(board,allBoards);
                return;
            }
            if (isSafe(row, col, board)){
                board[row][col]='Q';
                helper(board,allBoards,col+1);
                board[row][col]='.';
            }
        }
    }
    public static List<List<String>> solveNQueens(int n) {
    List<List<String>> allBoards = new ArrayList<>();
    char[][] board = new char[n][n];

    helper(board,allBoards,0);
    System.out.println(allBoards);
    return allBoards;
    }
    public static void main(String[] args){
        System.out.println("Enter Size Of Chess Board :-> ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solveNQueens(n);
    }
}