public class ConsoleSinglePlayer extends Game {
    public HandOperatedMasterSquirrel player = new HandOperatedMasterSquirrel(1);
    public XY squirrelMove=new XY(0,0);
    public ConsoleSinglePlayer() {
        super(new State(new Board()));
        getState().getBoard().createHandOperated(player);
        getState().getBoard().addOtherEntitys();
        update();

    }

    protected void processInput() {
        MoveCommand mc = ui.getCommand();
        switch (mc) {
            case up:
                this.squirrelMove = new XY(-1, 0);
                break;
            case right:
                this.squirrelMove = new XY(0, 1);
                break;
            case down:
                this.squirrelMove = new XY(1, 0);
                break;
            case left:
                this.squirrelMove = new XY(0, -1);
                break;
            case none:
                this.squirrelMove = new XY(0, 0);
        }
        player.nextStep(getState().getContext(),squirrelMove);
        update();
    }


}
