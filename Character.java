public class Character extends Entity{
    int move=0;
    public Character(int id,int energy,XY xy){
        super(id, energy, xy);
    }

    public int getMove(){
        return move;
    }
    public void setMove(){
        this.move=move;
    }

}
