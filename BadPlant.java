
public class BadPlant extends Entity {
	final static int ENERGY = -100;

	public BadPlant(int id, XY xy) {
		super(id, ENERGY, xy);
	}


	public EntityType getEntityType(){
		return EntityType.BadPlant;
	}
	public void nextStep(EntityContext context){
	}

}
