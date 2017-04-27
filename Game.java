
abstract public class Game {
    private State gameState;
    private BoardView view;
    private FlattenedBoard flattenedBoard;

    UI ui = new ConsoleUI();

    public Game(State state){
    this.gameState=state;
    this.flattenedBoard=gameState.flattenedBoard();
    this.view=flattenedBoard;
    }
    public void run(){
        while (true){
            render();
            processInput();
            update();
        }
    }
    protected void render(){
        ui.render(view);
    }
    protected void processInput(){

    }
    protected void update(){
        gameState.update();
        flattenedBoard=gameState.flattenedBoard();
        view=flattenedBoard;

    }
    State getState(){
        return gameState;
    }



}
