package de.hsa.games.fastsquirrel.console;

import de.hsa.games.fastsquirrel.MoveCommand;
import de.hsa.games.fastsquirrel.UI;
import de.hsa.games.fastsquirrel.core.BoardView;

import java.util.Scanner;

public class ConsoleUI implements UI {
    public MoveCommand getCommand() {
        Scanner scanner = new Scanner(System.in);
        char c = scanner.nextLine().charAt(0);
        switch (c) {
            case 'w':
            case 'W':
                return MoveCommand.up;
            case 'a':
            case 'A':
                return MoveCommand.left;
            case 's':
            case 'S':
                return MoveCommand.down;
            case 'd':
            case 'D':
                return MoveCommand.right;
            default:
                return MoveCommand.none;
        }
    }

    public void render(BoardView view) {
        for (int i = 0; i <= view.getSize().y - 1; i++) {
        for (int j = 0; j <= view.getSize().x - 1; j++) {
                switch (view.getEntityType(i, j)) {
                    case Wall:
                        System.out.print("W ");
                        break;
                    case GoodBeast:
                        System.out.print("G ");
                        break;
                    case BadBeast:
                        System.out.print("B ");
                        break;
                    case GoodPlant:
                        System.out.print("g ");
                        break;
                    case BadPlant:
                        System.out.print("b ");
                        break;
                    case MasterSquirrel:
                        System.out.print("M ");
                        break;
                    case MinniSquirrel:
                        System.out.print("m ");
                        break;
                    case HandoperatedMasterSquirrel:
                        System.out.print("H ");
                        break;
                    case None:
                        System.out.print("  ");
                        break;
                }
            }
            System.out.println();
        }
    }
}