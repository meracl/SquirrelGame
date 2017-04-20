abstract class Entity {
    private int id;
    private int energy;
    private XY xy;

    public Entity(int id, int energy, XY xy) {
        this.id = id;
        this.energy = energy;
        this.xy = xy;
    }

    int getId() {
        return id;
    }

    int getEnergy() {
        return energy;
    }

    XY getXy() {
        return xy;
    }
    void setXy(XY newxy) {
        this.xy=newxy;
    }

    void updateEnergy(int delta) {
        energy = energy + delta;
    }

    void nextStep() {
        move();
        //EntitySet.collusion(id);
    }

    public String toString() {
        return this.getClass() + " mit ID: " + getId() + " Energy: " + getEnergy() + " Koordinaten " + xy;
    }

    public void move() {
        int x = xy.x + randomVek();
        int y = xy.y + randomVek();
        this.xy = new XY(x, y);
    }

    public static int randomVek() {
        int i = (int) (Math.random() * 3) - 1;
        return i;
    }
}