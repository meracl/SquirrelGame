
public class Game {
    private State gameState;
    private BoardView view;
    public static XY squirrelMove;

    UI ui = new ConsoleUI();

    public Game(State state){
    this.gameState=state;
    this.view=gameState.flattenedBoard();
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
        MoveCommand mc=ui.getCommand();
        switch (mc){
            case up:
                this.squirrelMove=new XY(-1,0);
                break;
            case right:
                this.squirrelMove=new XY(0,1);
                break;
            case down:
                this.squirrelMove=new XY (1,0);
                break;
            case left:
                this.squirrelMove=new XY(0,-1);
                break;
            case none:
                this.squirrelMove=new XY(0,0);
        }

    }
    protected void update(){
        gameState.update(squirrelMove);
      this.view=gameState.flattenedBoard();

    }


}
