public class Board {
    public static BoardConfig BC = new BoardConfig();
    public Entity[] board;
    private int ID = 1;


    public Board() {
        this.board = new Entity[BC.getSize().x * BC.getSize().y];
        addSurrounding();
        addOtherEntitys();
    }

    private void addOtherEntitys() {
        for (int i = 1; i <= BC.getBadBeastCount(); i++) {
            addEntity(new BadBeast(ID, randomPos()));
        }
        for (int i = 1; i <= BC.getGoodBeastCount(); i++) {
            addEntity(new GoodBeast(ID, randomPos()));
        }
        for (int i = 1; i <= BC.getBadPlantCount(); i++) {
            addEntity(new BadPlant(ID, randomPos()));
        }
        for (int i = 1; i <= BC.getGoodPlantCount(); i++) {
            addEntity(new GoodPlant(ID, randomPos()));
        }

    }

    private void addSurrounding() {
        for (int i = 0; i <= BC.getSize().x - 1; i++) {
            for (int j = 0; j <= BC.getSize().y - 1; j++) {
                if (i == 0 | i == BC.getSize().x - 1 | j == 0 | j == BC.getSize().y - 1) {
                    addEntity(new Wall(ID++, new XY(i, j)));
                }
            }
        }
    }

    public void addEntity(Entity entity) {
        int count = 0;
        while (count <= board.length - 1) {
            if (board[count] == null) {
                board[count] = entity;
                break;
            }
            count++;
        }

    }

    public Entity[][] flatten() {
        Entity[][] flatBoard = new Entity[BC.getSize().x][BC.getSize().y];
            for (int i = 0; i <= board.length - 1; i++) {
                if(board[i]!=null){
                int x = board[i].getXy().x;
                int y = board[i].getXy().y;
                flatBoard[x][y] = board[i];
            }
        }
        return flatBoard;
    }

    private XY randomPos() {
        int x;
        int y;
        do {
            x = (int) (Math.random() * (BC.getSizeX()));
            y = (int) (Math.random() * (BC.getSizeY()));

        } while (possibleSet(x, y) == false);

        return new XY(x, y);
    }

    public XY getSize() {
        return BC.getSize();
    }
    public int getSizeX() {
        return BC.getSizeX();
    }
    public int getSizeY() {
        return BC.getSizeY();
    }

    public boolean possibleSet(int x, int y) {
        for (int i = 0; i <= board.length - 1; i++) {
            if (board[i] != null) {
                if ((board[i].getXy().x == x) && (board[i].getXy().y == y)) {
                    return false;
                }
            }
        }
        return true;
    }
}
