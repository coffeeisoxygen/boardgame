package com.coffeeisoxygen.model.interfaces;

public interface IBoard {

    int getWidth();

    int getHeight();

    ITile getTile(int x, int y);

    String getName();

    ITile[][] getAllTiles();

}