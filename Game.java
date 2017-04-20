
public class Game {
    State gameState;
    public Game(State state){
    this.gameState=state;
    }
    public void run(){
        while (true){
            render();
            processInput();
            update();
        }
    }
    protected void render(){
    }
    protected void processInput(){

    }
    protected void update(){

    }
}
