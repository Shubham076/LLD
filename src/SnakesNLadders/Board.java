package SnakesNLadders;
import java.util.Random;

public class Board {
    int size;
    int snakes;
    int ladders;
    Cell[][] board;

    Board(int size, int snakes, int ladders) {
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
        createBoard();
        addSnakesAndLadders();
    }

    void createBoard() {
        board = new Cell[size][size];
        int cnt = 0;
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                board[i][j] = new Cell(i, j, (cnt++));
            }
        }
    }

    Cell getCell(int idx) {
        return board[idx / size][idx % size];
    }
    void addSnakesAndLadders() {
        Random r = new Random();
        while(snakes-- > 0) {
            int x = r.nextInt((size * size) - 1);
            int y = r.nextInt((size * size) - 1);
            int snakeStart = Math.max(x, y);
            int snakeEnd = Math.min(x, y);
            System.out.println("Created snake SnakeStart: " + snakeStart + ", SnakeEnd: "  + snakeEnd);
            Cell c = getCell(snakeStart);
            c.jump = -1 * (snakeStart - snakeEnd);
        }

        while(ladders-- > 0) {
            int x = r.nextInt((size * size) - 1);
            int y = r.nextInt((size * size) - 1);
            int ladderStart = Math.min(x, y);
            int ladderEnd = Math.max(x, y);
            System.out.println("Created Ladder ladderStart: " + ladderStart + ", LadderEnd: "  + ladderEnd);
            Cell c = getCell(ladderStart);
            c.jump = -1 * (ladderStart - ladderEnd);
        }
    }

    void printBoard() {
        System.out.println("-------Board---------");
        int ladder = 1;
        int snake = 1;
        boolean rev = false;
        for(int i = size - 1; i >= 0; i--) {

            if(rev) {
                for(int j = 0; j < size; j++) {
                    System.out.print(board[i][j].n + " ");
                }
            }
            else {
                for(int j = size - 1; j >= 0; j--) {
                    System.out.print(board[i][j].n-- + " ");
                }
            }
            rev = !rev;
            System.out.println();
        }
    }
}
