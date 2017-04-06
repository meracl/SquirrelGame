import java.util.Scanner;

public class HandOperatedMasterSquirrel extends MasterSquirrel {
	private static XY xy = new XY(0, 0);

	public HandOperatedMasterSquirrel(int id) {
		super(id, xy);
	}

	void nextStep() {
		XY newxy=new XY(xy);
		Scanner step = new Scanner(System.in);
		char dir = step.next(".").charAt(0);
		switch (dir) {
		case 'w':
			newxy.y--;
			break;
		case 'a':
			newxy.x--;
			break;
		case 's':
			newxy.y++;
			break;
		case 'd':
			newxy.x++;
			break;
		default:
			System.out.println("keine gültige Richtung");
		}
		boolean move = EntitySet.possibleMove(newxy.x,newxy.y,getId());
		if (move){
			this.xy.x=newxy.x;
			this.xy.y=newxy.y;
		}
		
	}
}
