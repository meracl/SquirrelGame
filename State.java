public class State {
    Board boardState;
    FlattenedBoard flattenedBoard;
    private EntityContext context;


    public State(Board board) {
        this.boardState = board;
        this.flattenedBoard=new FlattenedBoard(boardState);
        this.context=new FlattenedBoard(boardState);
    }

    public void update(XY squirrelMove) {
        boardState.doAllMoves(context);
        this.flattenedBoard=new FlattenedBoard(boardState);
    }


    public FlattenedBoard flattenedBoard() {
        return flattenedBoard;
    }
}
