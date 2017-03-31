final public class XY {

	static Entity moveRight(Entity entity) {
		entity.y++;
		return entity;
	}

	static Entity moveLeft(Entity entity) {
		entity.y--;
		return entity;
	}

	static Entity moveDown(Entity entity) {
		entity.x++;
		return entity;
	}

	static Entity moveUp(Entity entity) {
		entity.x--;
		return entity;
	}

	static Entity moveUpRight(Entity entity) {
		 entity.y++;
		 entity.x--;
		 return entity;
	}

	static Entity moveUpLeft(Entity entity) {
		entity.y--;
		entity.x--;
		return entity;
	}

	static Entity moveDownRight(Entity entity) {
		entity.y++;
		entity.x++;
		return entity;
	}

	static Entity moveDownLeft(Entity entity) {
		entity.y--;
		entity.x++;
		return entity;
	}
}
