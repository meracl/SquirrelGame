
public class ConsoleUI implements UI{

  //  public MoveCommand getCommand(){

  //  }
    public void render(BoardView view){
      System.out.print(view.toString());
    }
}
