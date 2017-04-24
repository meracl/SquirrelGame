


public class HandOperatedMasterSquirrel extends MasterSquirrel {
    public static XY xy = new XY(1,1);

    HandOperatedMasterSquirrel(int id) {
        super(id, xy);
    }

    public void nextStep(EntityContext context) {
        context.tryMove(this,Game.squirrelMove);
    }

    public EntityType getEntityType(){
        return EntityType.HandoperatedMasterSquirrel;
    }


}




