
public class MasterSquirrel extends Entity {
	private static XY xy = new XY(0, 0);

	public MasterSquirrel(int id) {
		super(id, 1000, xy);
	}

	void nextStep() {
		this.xy = HandOperatedMasterSquirrel.squirrelStep(xy);
	}
}
