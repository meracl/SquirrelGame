package de.hsa.games.fastsquirrel.console;

import de.hsa.games.fastsquirrel.State;
import de.hsa.games.fastsquirrel.XY;
import de.hsa.games.fastsquirrel.core.Board;
import de.hsa.games.fastsquirrel.core.Game;
import de.hsa.games.fastsquirrel.core.HandOperatedMasterSquirrel;

public class ConsoleSinglePlayer extends Game {
    public HandOperatedMasterSquirrel player = new HandOperatedMasterSquirrel(1);
    public XY squirrelMove = new XY(0, 0);

    public ConsoleSinglePlayer() {
        super(new State(new Board()));
        getState().getBoard().createHandOperated(player);
        getState().getBoard().addOtherEntitys();
        update();

    }

    protected void processInput() {
        Command command = ui.getCommand();
        Object[] params = command.getParams();
        GameCommandType commandType = (GameCommandType) command.getCommandType();
        switch (commandType) {
            case UP:
                this.squirrelMove = new XY(-1, 0);
                player.nextStep(getState().getContext(), squirrelMove);
                update();
                break;
            case RIGHT:
                this.squirrelMove = new XY(0, 1);
                player.nextStep(getState().getContext(), squirrelMove);
                update();
                break;
            case DOWN:
                this.squirrelMove = new XY(1, 0);
                player.nextStep(getState().getContext(), squirrelMove);
                update();
                break;
            case LEFT:
                this.squirrelMove = new XY(0, -1);
                player.nextStep(getState().getContext(), squirrelMove);
                update();
                break;
            case HELP:
                help();
                break;
            case ALL:
                all();
                break;
            case EXIT:
                System.exit(0);
            case MASTER_ENERGY:
                masterEnergy();
                break;
            case SPAWN_MINI:
                spawnMini(params);
                break;
        }

    }

    private void spawnMini(Object[] params) {
        int energy=(int)params[0];
        player.updateEnergy(energy);
        XY xy = new XY(XY.addXy(player.getXy(),new XY(0,1)));
        getState().getBoard().createMinni(player.getId(),energy,xy);
    }

    private void masterEnergy() {
        System.out.println("Your Energy: "+player.getEnergy());
    }

    private void all() {
        System.out.println(getState().getBoard().toString());
    }

    private static void help() {
        CommandTypeInfo[] commandTypeInfos = GameCommandType.values();
        System.out.println("These are the usable commands:");
        for (int i=0;i<=commandTypeInfos.length-1;i++){
            System.out.println(commandTypeInfos[i].getName()+" "+commandTypeInfos[i].getHelpText());
        }
    }

}
