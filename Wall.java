
public class Wall extends Entity {
	final static int ENERGY = -10;

	public Wall(int id, XY xy) {
		super(id, ENERGY, xy);
	}

	public void nextStep() {

	}
	public EntityType getEntityType(){
		return EntityType.Wall;
	}

}
