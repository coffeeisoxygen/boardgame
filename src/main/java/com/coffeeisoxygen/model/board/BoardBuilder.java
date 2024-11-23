package com.coffeeisoxygen.model.board;

import com.coffeeisoxygen.model.factory.ITileFactory;
import com.coffeeisoxygen.model.interfaces.IBoard;
import com.coffeeisoxygen.model.interfaces.IBoardTemplate;
import com.coffeeisoxygen.model.interfaces.ITile;
import com.coffeeisoxygen.model.templates.DefaultTemplate;

public class BoardBuilder {
    int width;
    int height;
    ITile[][] tiles;
    String name;

    public BoardBuilder setSize(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }

    public BoardBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public BoardBuilder setTemplate(IBoardTemplate template, ITileFactory factory) {
        this.width = template.getWidth();
        this.height = template.getHeight();
        this.tiles = template.generateTemplate(factory);
        this.name = template.getName();
        return this;
    }

    public BoardBuilder createDefaultTemplate(ITileFactory factory) {
        IBoardTemplate defaultTemplate = new DefaultTemplate(width, height, name);
        return setTemplate(defaultTemplate, factory);
    }

    public IBoard build(ITileFactory factory) {
        if (tiles == null) {
            createDefaultTemplate(factory);
        }
        return new Board(this);
    }
}
