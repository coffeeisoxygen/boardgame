package com.coffeeisoxygen.model.interfaces;

public interface IPlayer {

    String getName();

    void setName(String name);

    int getEnergy();

    void setEnergy(int energy);

    int getScore();

    void setScore(int score);

    boolean isiAlive();

    void setiAlive(boolean iAlive);

    IPoint getPosition();

    void setPosition(IPoint position);

}