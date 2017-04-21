
public class Game {
    private State gameState;
    private BoardView view=new FlattenedBoard();
    ConsoleUI cui = new ConsoleUI();

    public Game(State state){
    this.gameState=state;
    }
    public void run(){
  //      while (true){
            render();
            processInput();
            update();
  //      }
    }
    protected void render(){
        cui.render(view);
    }
    protected void processInput(){

    }
    protected void update(){
        gameState.update();

    }
}
