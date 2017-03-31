
public class Wall extends Entity {
	final static int energy = -10;
	final static int id = 4;

	public Wall(int x, int y) {
		super(id, energy, x, y);
	}

	public String toString() {
		return "Wall mit ID: " + getId() + " Energy: " + getEnergy() + " Koordinaten x: " + getX() + " y: " + getY();
	}
}
