package TicTacToe.Models;

import TicTacToe.Enums.Piece;

public class Board {
    private int size;
    private Piece[][] board;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }

    public Board(int size) {
        this.size = size;
        board = new Piece[size][size];
    }

    public void addPiece(int r, int c, Piece piece) {
        board[r][c] = piece;
    }

    public boolean isFreeCellsAvailable() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j] + " ");
                } else {
                    System.out.print("- ");
                }
            }
            // Remove the trailing space from the last column.
            System.out.println();
        }
    }
}
