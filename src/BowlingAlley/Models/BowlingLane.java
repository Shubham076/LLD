package BowlingAlley.Models;

import BowlingAlley.AbstractClasses.BonusStrategy;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class BowlingLane {

    private int id;
    private List<Player> players;
    private ScoreBoard scoreBoard;
    private List<BonusStrategy> strategies;
    private int totalFrames;

    public int getTotalFrames() {
        return totalFrames;
    }

    public void setTotalFrames(int totalFrames) {
        this.totalFrames = totalFrames;
    }

    public BowlingLane(int id, int totalFrames) {
        this.id = id;
        this.scoreBoard = new ScoreBoard();
        this.players = new ArrayList<>();
        this.strategies = new ArrayList<>();
        this.totalFrames = totalFrames;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void addBonusStrategies(BonusStrategy strategy) {
        this.strategies.add(strategy);
    }

    private void playFrame(int currentFrame) {
        Random rand = new Random();

        for (Player player : players) {
            Frame frame = player.getFrames()[currentFrame];
            int throw1 = rand.nextInt(11);
            int throw2 = (10 - throw1) >= 0 ? rand.nextInt(11 - throw1) : 0;

            frame.addThrow(throw1);
            if (throw1 != 10) {
                frame.addThrow(throw2);
            }


            for (BonusStrategy strategy : strategies) {
                if (strategy.applies(frame)) {
                    System.out.println("Player: " + player.getName() + " scored: " + strategy.getBonusType());
                    frame.calculateBonus(strategy);
                    break;
                }
            }

            if (currentFrame == (totalFrames - 1) && (throw1 == 10 || throw1 + throw2 == 10)) {
                System.out.println("PLayer: " + player.getName() + " got extra throw for frame: " + currentFrame);
                int extraThrow = rand.nextInt(11);
                frame.addThrow(extraThrow);
            }

            scoreBoard.updateScore(player.getName(), frame.getScore());
            scoreBoard.show(player.getName());
        }
    }

    public void startGame() {
        for (int i = 0; i < totalFrames; i++) {
            this.playFrame(i);
            System.out.println("---------------------");
        }
        System.out.println("Game finished");
    }

    public void show() {
        scoreBoard.show();
    }
}
