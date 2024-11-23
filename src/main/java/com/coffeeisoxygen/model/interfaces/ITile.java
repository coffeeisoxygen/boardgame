package com.coffeeisoxygen.model.interfaces;

import java.awt.Color;

import com.coffeeisoxygen.model.enumerate.TileType;

public interface ITile {

    String getName();

    TileType getType();

    IPoint getPosition();

    Color getColor();

    void setName(String name);

    void setType(TileType type);

    void setPosition(IPoint position);

    void setColor(Color color);

}