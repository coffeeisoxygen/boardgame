package com.coffeeisoxygen.model.interfaces;

import com.coffeeisoxygen.model.classes.Point;

public interface IPoint {
    int getX();

    void setX(int x);

    int getY();

    void setY(int y);

    double distanceTo(Point other);

    int manhattanDistanceTo(Point other);

    IPoint directionTo(Point other);

    void translate(int dx, int dy);

    IPoint copy();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    @Override
    String toString();
}