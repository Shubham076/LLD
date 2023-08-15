package BowlingAlley;

import BowlingAlley.Enums.BonusStrategyType;
import BowlingAlley.Models.BowlingLane;
import BowlingAlley.Models.Player;
import BowlingAlley.strategies.SpareStrategy;
import BowlingAlley.strategies.StrikeStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BowlingGame {
    private List<BowlingLane> lanes;

    public BowlingGame() {
        this.lanes = new ArrayList<>();
    }

    public void addLane(int frames) {
        int id = lanes.size() + 1;
        BowlingLane l = new BowlingLane(id, frames);
        l.addBonusStrategies(new SpareStrategy(BonusStrategyType.SPARE));
        l.addBonusStrategies(new StrikeStrategy(BonusStrategyType.STRIKE));
        lanes.add(l);
        System.out.println("Lane: " + id + " added to the game");
    }

    public void addPlayer(int laneId, String player) {
       try {
           BowlingLane lane = this.lanes.stream().filter(l -> l.getId() == laneId).findAny().get();
           lane.addPlayer(new Player(player, lane.getTotalFrames()));
           System.out.println("Player: " + player + " added to lane: " + laneId);
       } catch (NoSuchElementException e) {
           System.out.println("Bowling lane: " + laneId + " not found");
       }
    }

    public void startGame(int laneId) {
        System.out.println("Started game for lane: " + laneId);
        try {
            BowlingLane lane = this.lanes.stream().filter(l -> l.getId() == laneId).findAny().get();
            lane.startGame();
        } catch (NoSuchElementException e) {
            System.out.println("Bowling lane: " + laneId + " not found");
        }
    }

    public void show(int laneId) {
        try {
            BowlingLane lane = this.lanes.stream().filter(l -> l.getId() == laneId).findAny().get();
            lane.show();
        } catch (NoSuchElementException e) {
            System.out.println("Bowling lane: " + laneId + " not found");
        }
    }
}
