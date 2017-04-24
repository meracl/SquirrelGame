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
        System.out.print(view.toString());
    }
}
