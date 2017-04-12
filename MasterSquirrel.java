
public class MasterSquirrel extends Squirrel {

	public MasterSquirrel(int id, XY xy) {
		super(id, 1000, xy);
	}

	public void nextStep() {

	}

	public MinniSquirrel createMinni(int energy) {
		int id = Main.game.getnextId();
		this.updateEnergy(-energy);
		return new MinniSquirrel(id, energy, getXy(), getId());
	}

	public boolean isOwnMinni(MinniSquirrel ms) {
		if (ms.getPid() == this.getId()) {
			return true;
		} else
			return false;
	}
}
