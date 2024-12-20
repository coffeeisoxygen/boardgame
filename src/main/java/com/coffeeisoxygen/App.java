package com.coffeeisoxygen;

import java.util.Scanner;

import com.coffeeisoxygen.model.board.BoardBuilder;
import com.coffeeisoxygen.model.factory.TileFactory;
import com.coffeeisoxygen.model.interfaces.IBoard;
import com.coffeeisoxygen.model.interfaces.IBoardTemplate;
import com.coffeeisoxygen.model.templates.FirstTemplate;
import com.coffeeisoxygen.model.templates.SecondTemplate;
import com.coffeeisoxygen.model.templates.ThirdTemplate;

public class App {
    public static void main(String[] args) {
        TileFactory factory = TileFactory.getInstance();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Select a template:");
            System.out.println("1. Default Template");
            System.out.println("2. First Template");
            System.out.println("3. Second Template");
            System.out.println("4. Third Template");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            IBoardTemplate selectedTemplate;
            switch (choice) {
                case 2:
                    selectedTemplate = new FirstTemplate();
                    break;
                case 3:
                    selectedTemplate = new SecondTemplate();
                    break;
                case 4:
                    selectedTemplate = new ThirdTemplate();
                    break;
                case 1:
                default:
                    selectedTemplate = null; // Default template will be created by BoardBuilder
                    break;
            }

            IBoard board;
            if (selectedTemplate != null) {
                board = new BoardBuilder()
                        .setTemplate(selectedTemplate, factory)
                        .build(factory);
            } else {
                board = new BoardBuilder()
                        .setSize(5, 15) // Ensure the size is set for the default template
                        .setName("Default Game Board")
                        .build(factory);
            }

            // Access Board
            System.out.println("Board Name: " + board.getName());
            System.out.println("Tile (0,0): " + board.getTile(0, 0).getType().name());

            // Ensure we only access valid tile positions
            int maxX = board.getWidth() - 1;
            int maxY = board.getHeight() - 1;
            System.out.println("Tile (" + maxX + "," + maxY + "): " + board.getTile(maxX, maxY).getType().name());

            // Test print all tiles
            for (int y = 0; y < board.getHeight(); y++) {
                for (int x = 0; x < board.getWidth(); x++) {
                    System.out.print(board.getTile(x, y).getType().name() + " ");
                }
                System.out.println();
            }

            scanner.close();
        }
    }
}