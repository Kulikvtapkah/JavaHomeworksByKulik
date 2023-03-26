package Homework5;

import java.util.Arrays;
import java.util.Stack;

public class JavaHmw5_3 {
    /*
     * На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. И
     * вывести Доску.
     * Пример вывода доски 8x8
     * 0x000000
     * 0000x000
     * 00x00000
     */
    public static void main(String[] args) {

        Stack<char[][]> boardState = new Stack<char[][]>();
        Stack<Integer> place = new Stack<Integer>();
        boardState.push(clearBoard());

        boolean queenPlaced = true;
        while (place.size() < 8) {
            int pose = getPosition(boardState.peek());

            if (pose == -1) {
                boardState.pop();

                if (queenPlaced) {
                    queenPlaced = false;
                } else {
                    pose = place.pop();
                    boardState.pop();
                    queenPlaced = true;
                }
                boardState.push(removeAQueen(boardState.pop(), place.pop()));
            } else {
                place.push(pose);
                boardState.push(placeAQueen(boardState.peek(), pose));
                queenPlaced = true;
            }
        }
        boardPrint(boardState.peek());
    }

    public static char[][] clearBoard() {
        char[][] board = new char[8][8];
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                board[row][column] = '0';
            }
        }
        return board;
    }

    private static int getPosition(char[][] board) {
        int row = 0;
        int position = -1;
        while (row < 8 && position == -1) {
            int column = 0;
            while (column < 8 && position == -1) {
                if (board[row][column] == '0') {

                    position = row * 10 + column;
                }
                column++;
            }
            row++;
        }
        return position;
    }

    public static char[][] placeAQueen(char[][] board, int position) {

        int queenRow = position / 10;
        int queenColumn = position % 10;
        char[][] newBoard = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                newBoard[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < 8; i++) {
            newBoard[i][queenColumn] = 'X';
            newBoard[queenRow][i] = 'X';
            int diagonal = queenRow - queenColumn + i;
            if (diagonal < 8 && diagonal >= 0) {
                newBoard[diagonal][i] = 'X';
            }
            diagonal = queenColumn + queenRow - i;
            if (diagonal < 8 && diagonal >= 0) {
                newBoard[i][diagonal] = 'X';
            }
        }
        newBoard[queenRow][queenColumn] = 'Q';

        return newBoard;
    }

    public static char[][] removeAQueen(char[][] board, int position) {

        int xRow = position / 10;
        int xColumn = position % 10;
        char[][] newBoard = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        newBoard[xRow][xColumn] = 'X';

        return newBoard;
    }

    public static void boardPrint(char[][] board) {
        System.out.println(Arrays.deepToString(board).replaceAll("\\], ", "\n")
                .replaceAll("\\[|\\]|\\,", ""));
        System.out.println("");

    }
}
