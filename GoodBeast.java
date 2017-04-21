
public class GoodBeast extends Character {
	final static int ENERGY = 200;

	public GoodBeast(int id, XY xy) {
		super(id, ENERGY, xy);
	}

	public void updateEnergy(int delta) {
	}
	public EntityType getEntityType(){
		return EntityType.GoodBeast;
	}
	public void nextStep(EntityContext context){
		context.tryMove(this,XY.randomVec());
	}
}
