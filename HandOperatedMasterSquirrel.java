import java.util.Scanner;

public class HandOperatedMasterSquirrel {
	public static XY squirrelStep(XY xy) {
		Scanner step = new Scanner(System.in);
		char dir = step.next(".").charAt(0);
		switch (dir) {
		case 'w':
			xy.y--;
			break;
		case 'a':
			xy.x--;
			break;
		case 's':
			xy.y++;
			break;
		case 'd':
			xy.x++;
			break;
		default:
			System.out.println("keine gültige Richtung");
		}
		return xy;
	}
}
