
public class EntitySet {
	public static Entity[] createEntitys() {
		Entity[] entitySet = new Entity[10];
		int i = 1;
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

	public static void deleteEntity(Entity test, Entity[] entitySet) {
		for (int i = 0; i <= entitySet.length - 1; i++) {
			if (entitySet[i] == test) {
				entitySet[i] = null;
			}
		}
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

}
