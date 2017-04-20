public class Board {
    public Board(){

    }
    public Entity[][] flatten(){
        Entity[][] flatBoard=new Entity[][];
        for (int i =0;i<=board.length-1;i++) {
            int x=board[i].getXy().x;
            int y = board[i].getXY().y;
            flatBoard[x][y]=board[i];
        }
        return flatBoard;
    }
}
