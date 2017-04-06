final public class XY {
	public int x;
	public int y;

	public XY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public XY(XY xy) {
		this.x = xy.x;
		this.y = xy.y;
	}

	public String toString() {
		return "x: " + this.x + " y: " + this.y;
	}


}
