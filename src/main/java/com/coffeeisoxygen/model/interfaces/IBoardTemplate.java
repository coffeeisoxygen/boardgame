package com.coffeeisoxygen.model.interfaces;

import com.coffeeisoxygen.model.factory.ITileFactory;

public interface IBoardTemplate {
    ITile[][] generateTemplate(ITileFactory factory);

    int getWidth();

    int getHeight();

    String getName();
}
