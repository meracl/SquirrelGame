public class MasterSquirrel extends PlayerEntity {

    public MasterSquirrel(int id,XY xy) {
        super(id, 1000, xy);
    }

    void nextStep() {

    }
    public EntityType getEntityType(){
        return EntityType.MasterSquirrel;
    }
}
