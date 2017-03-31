
public class MasterSquirrel extends Entity {
	static int energy = 1000;
	final static int id = 5;

	public MasterSquirrel() {
		super(id, energy, 0, 0);
	}

	public String toString() {
		return "MasterSquirrel mit ID: " + getId() + " Energy: " + getEnergy() + " Koordinaten x: " + getX() + " y: "
				+ getY();
	}
}
