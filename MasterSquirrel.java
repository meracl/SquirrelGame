public class MasterSquirrel extends PlayerEntity {

    public MasterSquirrel(int id,XY xy) {
        super(id, 1000, xy);
    }

    public void nextStep(EntityContext context){
        context.tryMove(this,XY.randomVec());
    }
    public EntityType getEntityType(){
        return EntityType.MasterSquirrel;
    }
}
