
public class FlattenedBoard implements EntityContext, BoardView {
    private Board board = new Board();
    private Entity[][] flatBoard = board.flatten();

    public XY getSize() {
        return board.getSize();
    }

    public void tryMove(MinniSquirrel minniSquirrel, XY moveDirection) {
        XY newPos = new XY(XY.addXy(minniSquirrel.getXy(), moveDirection));
        minniSquirrel.updateEnergy(-1);
        Entity newPosEnt = flatBoard[newPos.x][newPos.y];
        if (newPosEnt == null) {
            minniSquirrel.setXy(newPos);
            return;
        }
        EntityType type = getEntityType(newPos);
        switch (type) {
            case GoodBeast:
                minniSquirrel.updateEnergy(GoodBeast.ENERGY);
                killAndReplace(newPosEnt);
                break;
            case BadBeast:
                minniSquirrel.updateEnergy(BadBeast.ENERGY);
                BadBeast beast = (BadBeast) newPosEnt;
                beast.addABite();
                if (beast.getBites() == 7) {
                    killAndReplace(beast);
                }
                break;
            case BadPlant:
                minniSquirrel.updateEnergy(BadPlant.ENERGY);
                killAndReplace(newPosEnt);
                break;
            case GoodPlant:
                minniSquirrel.updateEnergy(GoodPlant.ENERGY);
                killAndReplace(newPosEnt);
                break;
            case Wall:
                minniSquirrel.updateEnergy(Wall.ENERGY);
                return;
            case MinniSquirrel:
                MinniSquirrel minniOther = (MinniSquirrel) newPosEnt;
                if (minniSquirrel.getPid() == minniOther.getPid()) {
                    return;
                } else {
                    kill(minniSquirrel);
                    kill(minniOther);
                }
                break;
            case MasterSquirrel:
                if (minniSquirrel.getPid() == newPosEnt.getId()) {
                    newPosEnt.updateEnergy(minniSquirrel.getEnergy());
                }
                kill(minniSquirrel);


        }

    }

    public void tryMove(GoodBeast goodBeast, XY moveDirection) {
        if (goodBeast.getMove() % 4 == 0) {
            XY vec = board.distanceGood(goodBeast.getXy(), moveDirection);
            XY newPos = new XY(XY.addXy(goodBeast.getXy(), vec));
            Entity newPosEnt = flatBoard[newPos.x][newPos.y];
            if (newPosEnt == null) {
                goodBeast.setXy(newPos);
                return;
            }
            EntityType type = getEntityType(newPos);
            switch (type) {
                case GoodBeast:
                    break;
                case BadBeast:
                    break;
                case BadPlant:
                    break;
                case GoodPlant:
                    break;
                case Wall:
                    return;
                case MinniSquirrel:
                    newPosEnt.updateEnergy(goodBeast.getEnergy());
                    kill(goodBeast);
                    break;
                case MasterSquirrel:
                    newPosEnt.updateEnergy(goodBeast.getEnergy());
                    kill(goodBeast);

            }
        }
    }

    public void tryMove(BadBeast badBeast, XY moveDirection) {
        if (badBeast.getMove() % 4 == 0) {
            XY vec = board.distanceBad(badBeast.getXy(), moveDirection);
            XY newPos = new XY(XY.addXy(badBeast.getXy(), vec));
            Entity newPosEnt = flatBoard[newPos.x][newPos.y];
            if (newPosEnt == null) {
                badBeast.setXy(newPos);
                return;
            }
            EntityType type = getEntityType(newPos);
            switch (type) {
                case GoodBeast:
                    break;
                case BadBeast:
                    break;
                case BadPlant:
                    break;
                case GoodPlant:
                    break;
                case Wall:
                    return;
                case MinniSquirrel:
                    newPosEnt.updateEnergy(BadBeast.ENERGY);
                    badBeast.addABite();
                    if (badBeast.getBites() == 7) {
                        killAndReplace(badBeast);
                    }
                    break;
                case MasterSquirrel:
                    newPosEnt.updateEnergy(BadBeast.ENERGY);
                    badBeast.addABite();
                    if (badBeast.getBites() == 7) {
                        killAndReplace(badBeast);
                    }
            }
            }
    }

    public void tryMove(MasterSquirrel mastersquirrel, XY moveDirection) {

    }

    public PlayerEntity nearestPlayerEntity() {
        return null;
    }


    public void kill(Entity entity) {
        board.deleteEntity(entity.getId());
    }

    public void killAndReplace(Entity entity) {
        board.deleteEntity(entity.getId());
        switch (entity.getEntityType()) {
            case BadPlant:
                board.createBadPlant();
                break;
            case BadBeast:
                board.createBadBeast();
                break;
            case GoodBeast:
                board.createGoodBeast();
                break;
            case GoodPlant:
                board.createGoodPlant();
                break;
        }

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
        for (int i = 0; i <= board.getSizeX() - 1; i++) {
            for (int j = 0; j <= board.getSizeY() - 1; j++) {
                if (flatBoard[i][j] == null) {
                    s = s + "  ";
                } else {
                    s = s + resolveMarkers(flatBoard[i][j]);
                }
            }
            s = s + "\r\n";
        }
        return s;
    }

    public String resolveMarkers(Entity entity) {
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
