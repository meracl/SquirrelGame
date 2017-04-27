public class State {
    private Board boardState;


    public State(Board board) {
        this.boardState = board;
    }

    public void update() {
        boardState.doAllMoves(flattenedBoard());
    }


    public FlattenedBoard flattenedBoard() {
        return new FlattenedBoard(boardState);
    }
    Board getBoard(){
        return boardState;
    }

    EntityContext getContext(){
        return flattenedBoard();
    }
}
