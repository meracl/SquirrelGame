
public class GoodPlant extends Entity {
	final static int ENERGY = 100;

	public GoodPlant(int id, XY xy) {
		super(id, ENERGY, xy);
	}

	public String toString() {
		return "GoodPlant mit ID: " + getId() + " Energy: " + getEnergy() + " Koordinaten x: " + getX() + " y: "
				+ getY();
	}
}
