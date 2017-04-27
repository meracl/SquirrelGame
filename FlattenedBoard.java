
public class FlattenedBoard implements EntityContext, BoardView {
    private Board board;
    private Entity[][] flatBoard;

    public FlattenedBoard(Board board1) {
        this.board = board1;
        this.flatBoard = board1.flatten();

    }


    public XY getSize() {
        return board.getSize();
    }

    public void tryMove(MinniSquirrel minniSquirrel, XY moveDirection) {
        if (minniSquirrel.getMove() <= 0) {
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
                    System.out.println("MinniSquirrel(ID: " + minniSquirrel.getId() + " Parent: " + minniSquirrel.getPid() + ") hat ein GoodBeast aufgesaugt.\r\nNeur Energie: " + minniSquirrel.getEnergy());
                    break;
                case BadBeast:
                    minniSquirrel.updateEnergy(BadBeast.ENERGY);
                    BadBeast beast = (BadBeast) newPosEnt;

                    System.out.println("MinniSquirrel(ID: " + minniSquirrel.getId() + " Parent: " + minniSquirrel.getPid() + ") wurde von einem BadBeast gebissen.\r\nNeur Energie: " + minniSquirrel.getEnergy());beast.addABite();
                    if (beast.getBites() == 7) {
                        System.out.println("Das BadBeast(ID: "+beast.getId()+") ist dabei gestorben.");
                        killAndReplace(beast);
                    }
                    break;
                case BadPlant:
                    minniSquirrel.updateEnergy(BadPlant.ENERGY);
                    System.out.println("MinniSquirrel(ID: " + minniSquirrel.getId() + " Parent: " + minniSquirrel.getPid() + ") hat eine BadPlant aufgesaugt.\r\nNeur Energie: " + minniSquirrel.getEnergy());
                    killAndReplace(newPosEnt);
                    break;
                case GoodPlant:
                    minniSquirrel.updateEnergy(GoodPlant.ENERGY);
                    System.out.println("MinniSquirrel(ID: " + minniSquirrel.getId() + " Parent: " + minniSquirrel.getPid() + ") hat eine GoodPlant aufgesaugt.\r\nNeur Energie: " + minniSquirrel.getEnergy());
                    killAndReplace(newPosEnt);
                    break;
                case Wall:
                    minniSquirrel.updateEnergy(Wall.ENERGY);
                    System.out.println("MinniSquirrel(ID: " + minniSquirrel.getId() + " Parent: " + minniSquirrel.getPid() + ") ist gegen eine Wand gelaufen.\r\nNeur Energie: " + minniSquirrel.getEnergy());
                    minniSquirrel.setMove(3);
                    return;
                case MinniSquirrel:
                    System.out.print("MinniSquirrel(ID: " + minniSquirrel.getId() + " Parent: " + minniSquirrel.getPid() + ") hat ein MinniSquirrel ");
                    MinniSquirrel minniOther = (MinniSquirrel) newPosEnt;
                    if (minniSquirrel.getPid() == minniOther.getPid()) {
                        System.out.println("vom eigenen Parent getroffen. Nichts passiert.");
                        return;
                    } else {
                        System.out.println("eines anderen Parents getroffen. Beide sterben.");
                        kill(minniSquirrel);
                        kill(minniOther);
                    }
                    break;
                case MasterSquirrel:
                    System.out.print("MinniSquirrel(ID: " + minniSquirrel.getId() + " Parent: " + minniSquirrel.getPid() + ") hat ");
                    if (minniSquirrel.getPid() == newPosEnt.getId()) {
                        System.out.println("das eigene Parent getroffen und wird aufgesaugt.");
                        newPosEnt.updateEnergy(minniSquirrel.getEnergy());
                    }else{
                        System.out.println("ein anderes Parent getroffen und stirbt.");
                    }
                    kill(minniSquirrel);

            }
            minniSquirrel.setXy(newPos);
        } else {
            minniSquirrel.addMove(-1);
        }


    }

    public void tryMove(GoodBeast goodBeast, XY moveDirection) {
        goodBeast.addMove(1);
        if (goodBeast.getMove() % 4 == 0) {
            PlayerEntity nearestSquirrel = nearestPlayerEntity(goodBeast.getXy());
            if (nearestSquirrel != null) {
                moveDirection = newDirectionAway(nearestSquirrel.getXy(), goodBeast.getXy());
            }
            XY newPos = new XY(XY.addXy(goodBeast.getXy(), moveDirection));
            Entity newPosEnt = flatBoard[newPos.x][newPos.y];
            if (newPosEnt == null) {
                goodBeast.setXy(newPos);
                return;
            }
            EntityType type = getEntityType(newPos);
            switch (type) {
                case GoodBeast:
                case BadBeast:
                case BadPlant:
                case GoodPlant:
                    break;
                case Wall:
                    return;
                case MinniSquirrel:
                    newPosEnt.updateEnergy(goodBeast.getEnergy());
                    killAndReplace(goodBeast);
                    break;
                case MasterSquirrel:
                    newPosEnt.updateEnergy(goodBeast.getEnergy());
                    killAndReplace(goodBeast);

            }
            goodBeast.setXy(newPos);
        }
    }

    public void tryMove(BadBeast badBeast, XY moveDirection) {
        badBeast.addMove(1);
        if (badBeast.getMove() % 4 == 0) {
            PlayerEntity nearestSquirrel = nearestPlayerEntity(badBeast.getXy());
            if (nearestSquirrel != null) {
                moveDirection = newDirectionTowards(nearestSquirrel.getXy(), badBeast.getXy());
            }
            XY newPos = new XY(XY.addXy(badBeast.getXy(), moveDirection));
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
            badBeast.setXy(newPos);
        }
    }

    public void tryMove(MasterSquirrel masterSquirrel, XY moveDirection) {

        if (masterSquirrel.getMove() <= 0) {
            XY newPos = new XY(XY.addXy(masterSquirrel.getXy(), moveDirection));
            Entity newPosEnt = flatBoard[newPos.x][newPos.y];
            if (newPosEnt == null) {
                masterSquirrel.setXy(newPos);
                System.out.println(masterSquirrel.toString());
                return;
            }
            EntityType type = getEntityType(newPos);
            switch (type) {
                case GoodBeast:
                    masterSquirrel.updateEnergy(GoodBeast.ENERGY);
                    killAndReplace(newPosEnt);
                    break;
                case BadBeast:
                    masterSquirrel.updateEnergy(BadBeast.ENERGY);
                    BadBeast beast = (BadBeast) newPosEnt;
                    beast.addABite();
                    if (beast.getBites() == 7) {
                        killAndReplace(beast);
                    }
                    break;
                case BadPlant:
                    masterSquirrel.updateEnergy(BadPlant.ENERGY);
                    killAndReplace(newPosEnt);
                    break;
                case GoodPlant:
                    masterSquirrel.updateEnergy(GoodPlant.ENERGY);
                    killAndReplace(newPosEnt);
                    break;
                case Wall:
                    masterSquirrel.updateEnergy(Wall.ENERGY);
                    masterSquirrel.setMove(3);
                    return;
                case MinniSquirrel:
                    MinniSquirrel minniSquirrel = (MinniSquirrel) newPosEnt;
                    if (masterSquirrel.getId() == minniSquirrel.getPid()) {
                        masterSquirrel.updateEnergy(minniSquirrel.getEnergy());
                        kill(minniSquirrel);
                    } else {
                        masterSquirrel.updateEnergy(150);
                        kill(minniSquirrel);
                    }
                    break;
                case MasterSquirrel:
                    return;

            }
            System.out.println(masterSquirrel.toString());
            masterSquirrel.setXy(newPos);
        } else {
            masterSquirrel.addMove(-1);
        }
    }

    public PlayerEntity nearestPlayerEntity(XY xy) {
        int distance = 7;
        int m = -1;
        for (int i = 0; i <= board.board.length - 1; i++) {
            if (board.board[i] != null) {
                if (board.board[i].getEntityType() == EntityType.PlayerEntity) {
                    int disx = xy.x - board.board[i].getXy().x;
                    int disy = xy.y - board.board[i].getXy().y;
                    int dis = Math.abs(disx) + Math.abs(disy);
                    if (dis < distance) {
                        distance = dis;
                        m = i;
                    }
                }
            }
        }
        if (m >= 0) {
            return (PlayerEntity) board.board[m];
        }
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
            case HandoperatedMasterSquirrel:
                return "H ";
            default:
                return "O ";
        }

    }

    public XY newDirectionTowards(XY xy1, XY xy2) {
        int dirx = shortenDirection(xy1.x - xy2.x);
        int diry = shortenDirection(xy1.y - xy2.y);
        return new XY(dirx, diry);

    }

    public XY newDirectionAway(XY xy1, XY xy2) {
        int dirx = -shortenDirection(xy1.x - xy2.x);
        int diry = -shortenDirection(xy1.y - xy2.y);
        return new XY(dirx, diry);

    }

    public int shortenDirection(int i) {
        if (i < 0)
            return -1;
        else if (i > 0)
            return 1;
        else
            return 0;
    }


}
