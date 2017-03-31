import java.util.Scanner;

abstract class Entity {
	int id;
	int energy;
	int x;
	int y;

	public Entity(int id, int energy, int x, int y) {
		this.id = id;
		this.energy = energy;
		this.x = x;
		this.y = y;
	}

	static void nextStep(Entity entity) {
		if (entity != null) {
			int id = entity.id;
			int dir = 0;
			if (id == 5) {
				Scanner step = new Scanner(System.in);
				dir = step.nextInt();
			} else if ((id == 0) | (id == 1) | (id == 6)) {
				dir = (int) (Math.random() * 9);
			}
			switch (dir) {
			case 1:
				XY.moveDownLeft(entity);
				break;
			case 2:
				XY.moveDown(entity);
				break;
			case 3:
				XY.moveDownRight(entity);
				break;
			case 4:
				XY.moveLeft(entity);
				break;
			case 6:
				XY.moveRight(entity);
				break;
			case 7:
				XY.moveUpLeft(entity);
				break;
			case 8:
				XY.moveUp(entity);
				break;
			case 9:
				XY.moveUpRight(entity);
			}
		}
	}

	int getId() {
		return id;
	}

	int getEnergy() {
		return energy;
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

	void setEnergy(int x) {
		energy = x;
	}

}
