public class State {
    Board boardState;
    private EntityContext context = new FlattenedBoard();

    public State(Board board) {
        this.boardState = board;
    }

    public void update() {
        boardState.doAllMoves(context);
    }


    public FlattenedBoard flattenedBoard() {
        return null;
    }
}
