
public class PlayerEntity extends Entity {

	public PlayerEntity(int id, int energy, XY xy) {
		super(id, energy, xy);
	}

	public EntityType getEntityType(){
		return EntityType.PlayerEntity;
	}

}
