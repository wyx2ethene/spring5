package com.wyx.bean;

import java.util.Arrays;
import java.util.List;

public class Score {
    private String name;
    private int[] scores;

    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Score{" +
                "name='" + name + '\'' +
                ", scores=" + Arrays.toString(scores) +
                ", score=" + score +
                '}';
    }
}
