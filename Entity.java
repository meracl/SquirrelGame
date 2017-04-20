
abstract class Entity {
	private int id;
	private int energy;
	private XY xy;

	public Entity(int id, int energy, XY xy) {
		this.id = id;
		this.energy = energy;
		this.xy = xy;
	}

	public int getId() {
		return id;
	}

	public int getEnergy() {
		return energy;
	}

	public XY getXy() {
		return xy;
	}

	public void setXy(XY newxy) {
		this.xy = newxy;
	}

	public void updateEnergy(int delta) {
		energy = energy + delta;
	}

	public void nextStep() {
		XY newxy = XY.move(xy);
		if (Game.game.possibleMoveNoSq(newxy, id)) {
			xy = newxy;
		}
	}

	public String toString() {
		return this.getClass() + " mit ID: " + getId() + " Energy: " + getEnergy() + " Koordinaten " + xy;
	}

	public MinniSquirrel createMinni(int i) {
		return null;

	}

	public boolean equals(Entity entity) {
		if (this.id == entity.getId()) {
			return true;
		}
		return false;
	}

}
