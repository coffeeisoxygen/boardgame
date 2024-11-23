package com.coffeeisoxygen;

import com.coffeeisoxygen.factory.TileFactory;
import com.coffeeisoxygen.model.board.Board;
import com.coffeeisoxygen.model.board.BoardBuilder;

public class App {
    public static void main(String[] args) {
        TileFactory factory = TileFactory.getInstance();

        // Bikin Board Default
        Board defaultBoard = new BoardBuilder()
                .setSize(15, 15)
                .setName("My Game Board")
                .build(factory);

        // Akses Board
        System.out.println("Board Name: " + defaultBoard.getName());
        System.out.println("Tile (0,0): " + defaultBoard.getTile(0, 0).getName());
        System.out.println("Tile (14,14): " + defaultBoard.getTile(14, 14).getName());
        // test print all tiles
        for (int y = 0; y < defaultBoard.getHeight(); y++) {
            for (int x = 0; x < defaultBoard.getWidth(); x++) {
                System.out.print(defaultBoard.getTile(x, y).getName() + " ");
            }
            System.out.println();
        }
    }
}

