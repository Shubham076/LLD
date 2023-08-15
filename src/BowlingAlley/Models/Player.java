package BowlingAlley.Models;

import java.util.List;

public class Player{
    private String name;
    private Frame[] frames;

    public Player(String name, int frameCount) {
        this.name = name;
        this.frames = new Frame[frameCount];
        initalizeFrames();
    }

    private void initalizeFrames() {
        for (int i = 0; i < 10; i++) {
            frames[i] = new Frame();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Frame[] getFrames() {
        return frames;
    }

    public void setFrames(Frame[] frames) {
        this.frames = frames;
    }
}
