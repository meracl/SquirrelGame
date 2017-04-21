
public class GoodPlant extends Entity {
	final static int ENERGY = 100;

	public GoodPlant(int id, XY xy) {
		super(id, ENERGY, xy);
	}


	public EntityType getEntityType(){
		return EntityType.GoodPlant;
	}
	public void nextStep(EntityContext context){
	}

}
