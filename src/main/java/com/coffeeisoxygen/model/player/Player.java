package com.coffeeisoxygen.model.player;

import com.coffeeisoxygen.model.interfaces.IPlayer;
import com.coffeeisoxygen.model.interfaces.IPoint;

public class Player implements IPlayer {
    private String name;
    private int energy;
    private int score;
    private boolean iAlive;
    private IPoint position;

    public Player(String name, int energy) {
        this.name = name;
        this.energy = energy;
        this.score = 0;
        this.iAlive = true;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean isiAlive() {
        return iAlive;
    }

    @Override
    public void setiAlive(boolean iAlive) {
        this.iAlive = iAlive;
    }

    @Override
    public IPoint getPosition() {
        return position;
    }

    @Override
    public void setPosition(IPoint position) {
        this.position = position;
    }

}
