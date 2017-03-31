
public class EntitySet {
	final static Entity[] entitySet = new Entity[11];
	static MasterSquirrel masterSquirrel = new MasterSquirrel();

	public static void main(String[] args) {

		addEntity(masterSquirrel);
		GoodBeast gb1 = new GoodBeast(0,1);
		addEntity(gb1);
		GoodBeast gb2 = new GoodBeast(4, 4);
		addEntity(gb2);
		BadBeast bb1 = new BadBeast(3, 3);
		addEntity(bb1);
		BadBeast bb2 = new BadBeast(2, 2);
		addEntity(bb2);
		GoodPlant gp1 = new GoodPlant(1, 0);
		addEntity(gp1);
		GoodPlant gp2 = new GoodPlant(4, 6);
		addEntity(gp2);
		BadPlant bp1 = new BadPlant(6, 6);
		addEntity(bp1);
		BadPlant bp2 = new BadPlant(9, 9);
		addEntity(bp2);
		Wall w1 = new Wall(7, 7);
		addEntity(w1);
		Wall w2 = new Wall(8, 8);
		addEntity(w2);
		System.out.println(toString(entitySet));
		deleteEntity(bp2);
		addEntity(bp2);
		System.out.println(toString(entitySet));
		allStep();
		System.out.println(toString(entitySet));
	}

	public static void addEntity(Entity entity) {
		int count = 0;
		while (count <= entitySet.length - 1) {
			if (entitySet[count] == null) {
				entitySet[count] = entity;
				break;
			}
			count++;
		}

	}

	public static void deleteEntity(Entity test) {
		for (int i = 0; i <= entitySet.length - 1; i++) {
			if (entitySet[i] == test) {
				entitySet[i] = null;
			}
		}
	}

	public static String toString(Entity[] entitySet) {
		String s = "";
		for (int i = 0; i <= entitySet.length - 1; i++) {
			s = s + entitySet[i].toString() + "\n";
		}

		return s;
	}

	public static void allStep() {
		for (int i = 0; i <= entitySet.length - 1; i++) {
			Entity.nextStep(entitySet[i]);
			
		}
		stepTest();

	}

	public void stepTest() {
		for (int i = 0; i <= entitySet.length - 1; i++) {
			if (entitySet[i] == masterSquirrel) {
			} else if (entitySet[i].x == masterSquirrel.x && entitySet[i].y == masterSquirrel.y) {
				Entity.updateEnergy(masterSquirrel,entitySet[i].energy);
				deleteEntity(entitySet[i]);
			}
		}
	}
}
