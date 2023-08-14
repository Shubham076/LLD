package SnakesNLadders;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SnakesAndLadders {
    Board board;
    int size;
    Dice dice;
    ArrayDeque<Player> playersList;
    Player winner;

    SnakesAndLadders(int size, int snakes, int ladders, int noOfDice, List<String> Players) {
        this.size = size;
        board = new Board(size,snakes, ladders);
        dice = new Dice(noOfDice);
        playersList = new ArrayDeque<>();
        initializePlayers(playersList, Players);
    }

    void initializePlayers(ArrayDeque<Player> players, List<String> names) {
        for(String name: names){
            players.add(new Player(name));
        }
    }

    private Player findPlayerTurn() {
        Player player = playersList.removeFirst();
        playersList.addLast(player);
        return player;
    }

    private void updatePosition(Player p, int move) {
        int newPosition = p.currentPosition + move;
        if(newPosition > (size * size) - 1) {
            return;
        }
        Cell c = board.getCell(newPosition);
        if(c.jump > 0) {
            System.out.println("Player: " + p.name + " got a stair with jump:  " + c.jump);
        }
        else if(c.jump < 0) {
            System.out.println("Player: " + p.name + " got bitten by snake");
        }
        p.currentPosition = newPosition + c.jump;
        System.out.println("Player: " + p.name + " reached " + p.currentPosition);
    }

    public void startGame() {
        while(winner == null)  {
            Player p = findPlayerTurn();
            int move = dice.rollDice();
            System.out.println(p.name + " turn, current position is: " + p.currentPosition + " got " + move);
            int nextPos = p.currentPosition + move;

            //check for winning condition
            if(nextPos == (board.size * board.size) - 1) {
                winner = p;
                System.out.println(p.name + " won the game");
            }
            else {
                updatePosition(p, move);
            }
        }
    }

    public static void main(String[] args) {
        List<String> players = new ArrayList<>(Arrays.asList("Shubham", "Akshat", "Anubhav"));
        int size = 10;
        int snakes = 10;
        int ladder = 5;
        SnakesAndLadders game = new SnakesAndLadders(size, snakes, ladder, 1, players);
        game.startGame();
    }
}
