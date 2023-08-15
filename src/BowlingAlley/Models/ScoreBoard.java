package BowlingAlley.Models;

import java.util.HashMap;
import java.util.Map;

public class ScoreBoard {
    Map<String, Double> scoreMap;

    public ScoreBoard() {
        scoreMap = new HashMap<>();
    }

    public void addPlayer(String player) {
        scoreMap.put(player, 0.0);
    }

    public void updateScore(String player, double score) {
        scoreMap.put(player, scoreMap.getOrDefault(player, 0.0) + score);
    }


    public void show() {
        for (String player: scoreMap.keySet()) {
            show(player);
        }
    }

    public void show(String player) {
        double score = scoreMap.get(player);
        System.out.println("Player: " + player + " Total score: " + score);
    }
}