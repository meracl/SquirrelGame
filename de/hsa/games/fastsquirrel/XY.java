package de.hsa.games.fastsquirrel;

final public class XY {
    public final int x;
    public final int y;

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

    public static XY addXy(XY xy1, XY xy2) {
        int newx = xy1.x + xy2.x;
        int newy = xy1.y + xy2.y;
        return new XY(newx, newy);
    }

    public static XY randomMove(XY xy) {
        XY vec = randomVec();
        return addXy(xy, vec);
    }

    public static XY randomVec() {
        int i = (int) (Math.random() * 3) - 1;
        int j = (int) (Math.random() * 3) - 1;
        return new XY(i, j);
    }

    public boolean equals(XY xy) {
        if (this.x == xy.x && this.y == xy.y) {
            return true;
        }
        return false;
    }
}


