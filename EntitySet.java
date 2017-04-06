
public class EntitySet {
	private static Entity[] entitySet = new Entity[11];

	public static Entity[] createEntitys() {
		int i = 1;
		addEntity(new HandOperatedMasterSquirrel(i++), entitySet);
		GoodBeast gb1 = new GoodBeast(i++, new XY(9, 9));
		addEntity(gb1, entitySet);
		GoodBeast gb2 = new GoodBeast(i++, new XY(4, 4));
		addEntity(gb2, entitySet);
		BadBeast bb1 = new BadBeast(i++, new XY(3, 3));
		addEntity(bb1, entitySet);
		BadBeast bb2 = new BadBeast(i++, new XY(2, 2));
		addEntity(bb2, entitySet);
		GoodPlant gp1 = new GoodPlant(i++, new XY(1, 0));
		addEntity(gp1, entitySet);
		GoodPlant gp2 = new GoodPlant(i++, new XY(0, 1));
		addEntity(gp2, entitySet);
		BadPlant bp1 = new BadPlant(i++, new XY(1, 1));
		addEntity(bp1, entitySet);
		BadPlant bp2 = new BadPlant(i++, new XY(0, 2));
		addEntity(bp2, entitySet);
		Wall w1 = new Wall(i++, new XY(2, 0));
		addEntity(w1, entitySet);
		Wall w2 = new Wall(i++, new XY(2, 2));
		addEntity(w2, entitySet);
		System.out.println(toString(entitySet));
		return entitySet;
	}

	public static void addEntity(Entity entity, Entity[] entitySet) {
		int count = 0;
		while (count <= entitySet.length - 1) {
			if (entitySet[count] == null) {
				entitySet[count] = entity;
				break;
			}
			count++;
		}

	}

	public static void deleteEntity(int j) {
		entitySet[j] = null;
	}

	public static String toString(Entity[] entitySet) {
		String s = "";
		for (int i = 0; i <= entitySet.length - 1; i++) {
			if (entitySet[i] == null) {

			} else
				s = s + entitySet[i].toString() + "\n";
		}

		return s;
	}

	public static void runAll() {
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

	public static boolean possibleMove(int x, int y, int id) {
		for (int i = 0; i <= entitySet.length - 1; i++) {
			if (entitySet[i] != null) {
				if ((entitySet[i].getXy().x == x) && (entitySet[i].getXy().y == y) && (entitySet[i].getId() != id)) {
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

	public static int findId(int id) {
		for (int i = 0; i <= entitySet.length; i++) {
			if (entitySet[i].getId() == id)
				return i;
		}
		return 0;
	}
}
