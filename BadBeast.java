public class BadBeast extends Entity {
	final static int ENERGY = -150;

	public BadBeast(int id, XY xy) {
		super(id, ENERGY, xy);
	}

	public void updateEnergy(int delta) {
	}
	public EntityType getEntityType(){
		return EntityType.BadBeast;
	}
}
