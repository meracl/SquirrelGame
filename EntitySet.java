
public class EntitySet {
	public Entity[] entitySet = new Entity[23];
	private int i = 1;

	public Entity[] createEntitys() {

		addEntity(new HandOperatedMasterSquirrel(i++));
		GoodBeast gb1 = new GoodBeast(i++, new XY(1, 1));
		addEntity(gb1);
		GoodBeast gb2 = new GoodBeast(i++, new XY(4, 4));
		addEntity(gb2);
		BadBeast bb1 = new BadBeast(i++, new XY(3, 3));
		addEntity(bb1);
		BadBeast bb2 = new BadBeast(i++, new XY(2, 3));
		addEntity(bb2);
		GoodPlant gp1 = new GoodPlant(i++, new XY(7, 4));
		addEntity(gp1);
		GoodPlant gp2 = new GoodPlant(i++, new XY(3, 4));
		addEntity(gp2);
		BadPlant bp1 = new BadPlant(i++, new XY(1, 25));
		addEntity(bp1);
		BadPlant bp2 = new BadPlant(i++, new XY(5, 6));
		addEntity(bp2);
		addEntity(new Wall(i++, new XY(0, 0)));
		addEntity(new Wall(i++, new XY(0, 1)));
		addEntity(new Wall(i++, new XY(0, 2)));
		addEntity(new Wall(i++, new XY(1, 0)));
		addEntity(new Wall(i++, new XY(2, 0)));
		addEntity(new Wall(i++, new XY(2, 1)));
		addEntity(new Wall(i++, new XY(1, 2)));
		addEntity(new Wall(i++, new XY(2, 2)));
		System.out.println(toString(entitySet));

		return entitySet;
	}

	public static void addEntity(Entity entity) {
		int count = 0;
		while (count <= Main.game.entitySet.length - 1) {
			if (Main.game.entitySet[count] == null) {
				Main.game.entitySet[count] = entity;
				break;
			}
			count++;
		}

	}

	public void deleteEntity(int j) {
		entitySet[j] = null;
	}

	public String toString(Entity[] entitySet) {
		String s = "";
		for (int i = 0; i <= entitySet.length - 1; i++) {
			if (entitySet[i] == null) {

			} else
				s = s + entitySet[i].toString() + "\n";
		}

		return s;
	}

	public void run() {
		int msloc = 0;
		for (int i = 0; i <= entitySet.length - 1; i++) {
			if (!(entitySet[i] instanceof HandOperatedMasterSquirrel)) {
				if (entitySet[i] != null)
					entitySet[i].nextStep();
			} else
				msloc = i;
		}
		entitySet[msloc].nextStep();
		System.out.println(toString(entitySet));
	}

	public boolean possibleMoveSq(XY xy, int id) {
		for (int i = 0; i <= entitySet.length - 1; i++) {
			if (entitySet[i] != null) {
				if (entitySet[i].getXy().equals(xy) && !(entitySet[i].equals(entitySet[findId(id)]))) {
					entitySet[findId(id)].updateEnergy(entitySet[i].getEnergy());
					if (entitySet[i] instanceof Wall) {
						return false;
					}
					deleteEntity(i);
					break;
				}
			}
		}
		return true;
	}

	public boolean possibleMoveNoSq(XY xy, int id) {
		for (int i = 0; i <= entitySet.length - 1; i++) {
			if (entitySet[i] != null) {
				if (entitySet[i].getXy().equals(xy) && !(entitySet[i].equals(entitySet[findId(id)]))) {
					if (entitySet[i] instanceof Wall) {
						return false;
					}
					break;
				}
			}
		}
		return true;
	}

	public int findId(int id) {
		for (int i = 0; i <= entitySet.length; i++) {
			if (entitySet[i] != null)
				if (entitySet[i].getId() == id)
					return i;
		}
		return 0;
	}

	public int getnextId() {
		return i++;
	}
}
