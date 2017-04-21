
public class FlattenedBoard implements EntityContext, BoardView {
    Board board = new Board();
    public Entity[][] flatBoard = board.flatten();

    public XY getSize() {
        return board.getSize();
    }

    public void tryMove(MinniSquirrel minniSquirrel, XY moveDirection) {

    }

    public void tryMove(GoodBeast goodBeast, XY moveDirection) {

    }

    public void tryMove(BadBeast badBeast, XY moveDirection) {

    }

    public void tryMove(MasterSquirrel mastersquirrel, XY moveDirection) {

    }

    public PlayerEntity nearestPlayerEntity() {
        return null;
    }


    public void kill(Entity entity) {

    }

    public void killAndReplace(Entity entity) {

    }

    public EntityType getEntityType(XY xy) {
        EntityType type = getEntityType(xy.x, xy.y);
        return type;
    }

    public EntityType getEntityType(int x, int y) {
        EntityType type = flatBoard[x][y].getEntityType();
        return type;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i <= board.getSizeX()-1; i++) {
            for (int j = 0; j <= board.getSizeY()-1; j++) {
                if (flatBoard[i][j] == null) {
                    s = s + "  ";
                } else {
                    s = s + printMarker(flatBoard[i][j]);
                }
            }
            s=s+"\r\n";
        }
        return s;
    }

    public String printMarker(Entity entity) {
        switch (entity.getEntityType()) {
            case Wall:
                return "W ";
            case GoodBeast:
                return "G ";
            case BadBeast:
                return "B ";
            case GoodPlant:
                return "g ";
            case BadPlant:
                return "b ";
            case MasterSquirrel:
                return "M ";
            case MinniSquirrel:
                return "m ";
            default:
                return "O ";
        }

    }

}
