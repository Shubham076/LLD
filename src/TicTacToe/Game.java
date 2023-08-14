package TicTacToe;

import TicTacToe.Enums.GameState;
import TicTacToe.Enums.Piece;
import TicTacToe.Models.Board;
import TicTacToe.Models.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Game {
    private Deque<Player> players;
    private Board board;

    public Game() {}

    private GameState state;


    public void initialize(int size) {
        this.state = GameState.PROGRESS;
        this.players = new ArrayDeque<>();
        board = new Board(size);
        board.printBoard();
    }
    public void addPlayer(String name, String piece) {
        players.add(new Player(name, Piece.valueOf(piece)));
        System.out.println("PLayer: " + name + " with move : " + piece + " added");
    }

    private boolean isMoveValid(int row, int col, Player player) {
        if (row < 0 || row >= board.getSize() || col < 0 || col >= board.getSize() || board.getBoard()[row][col] != null) {
            System.out.println("INVALID MOVE");
            return false;
        }
        System.out.println("VALID MOVE");
        board.addPiece(row, col, player.getPiece());
        return true;
    }

    public void startGame(BufferedReader br) throws IOException {
        String line;
        while (true) {
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int r = Integer.parseInt(parts[0]) - 1;
                int c = Integer.parseInt(parts[1]) - 1;


                //take out the player whose turn is and also put the player in the list back
                Player player = players.getFirst();
                boolean isValid = isMoveValid(r, c, player);
                board.printBoard();
                if (isValid) {
                    players.addLast(players.removeFirst());
                }

                boolean winner = isThereWinner(r, c, player.getPiece());
                if(winner) {
                    state = GameState.COMPLETED;
                    System.out.println("PLayer: " + player.getName() + " won the game");
                    break;
                }

                //check if free cells are available or not
                boolean isCellsAvailable = board.isFreeCellsAvailable();
                if (!isCellsAvailable) {
                    state = GameState.DRAW;
                    System.out.println("Game draw");
                    break;
                }
            }
            if(state == GameState.COMPLETED || state == GameState.DRAW) {
                break;
            }
        }
        System.out.println("Game finished");
    }
    public boolean isThereWinner(int row, int column, Piece piece) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for (int i = 0; i < board.getSize(); i++) {
            if(board.getBoard()[row][i] == null || board.getBoard()[row][i] != piece) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i = 0; i < board.getSize(); i++) {
            if(board.getBoard()[i][column] == null || board.getBoard()[i][column] != piece) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i = 0, j = 0; i <board.getSize(); i++,j++) {
            if (board.getBoard()[i][j] == null || board.getBoard()[i][j] != piece) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i = 0, j = board.getSize() - 1; i < board.getSize(); i++,j--) {
            if (board.getBoard()[i][j] == null || board.getBoard()[i][j] != piece) {
                antiDiagonalMatch = false;
            }
        }
        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}
