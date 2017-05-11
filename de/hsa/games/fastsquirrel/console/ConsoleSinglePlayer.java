package de.hsa.games.fastsquirrel.console;

import de.hsa.games.fastsquirrel.State;
import de.hsa.games.fastsquirrel.XY;
import de.hsa.games.fastsquirrel.core.Board;
import de.hsa.games.fastsquirrel.core.Game;
import de.hsa.games.fastsquirrel.core.HandOperatedMasterSquirrel;

import java.lang.reflect.Method;

public class ConsoleSinglePlayer extends Game {
    private HandOperatedMasterSquirrel player = new HandOperatedMasterSquirrel(1);
    private XY squirrelMove = new XY(0, 0);

    private State state;
    private Board board;


    public ConsoleSinglePlayer() {
        super(new State(new Board()));
        this.state = getState();
        this.board = state.getBoard();
        board.createHandOperated(player);
        board.addOtherEntitys();
        update();

    }

    protected void processInput() {
        Command command;
        Object[] params;
        Method method;
        try {
            command = ui.getCommand();


        } catch (ScanExceptions e) {
            command = null;
        }
        if (command != null) {
            params = command.getParams();
            try {
                Class[] classArray = getAllClasses(params);
                GameCommandType commandType = (GameCommandType) command.getCommandType();
                method = this.getClass().getDeclaredMethod(commandType.getName(), classArray);
                method.invoke(this, params);
            } catch (Exception ignored) {
            }
        }
    }

    @SuppressWarnings("unused")
    void n(Integer energy) {
        player.updateEnergy(-energy);
        XY xy;

        do {
            xy = new XY(XY.addXy(player.getXy(), XY.randomVec()));
        } while (!board.possibleSet(xy.x, xy.y));
        board.createMinni(player.getId(), energy, xy);
    }

    @SuppressWarnings("unused")
    private void w() {      //up
        this.squirrelMove = new XY(-1, 0);
        player.nextStep(getState().getContext(), squirrelMove);
        updateAfterMaster();

    }

    @SuppressWarnings("unused")
    private void a() {      //left
        this.squirrelMove = new XY(0, -1);
        player.nextStep(getState().getContext(), squirrelMove);
        updateAfterMaster();

    }

    @SuppressWarnings("unused")
    private void s() {      //down
        this.squirrelMove = new XY(1, 0);
        player.nextStep(getState().getContext(), squirrelMove);
        updateAfterMaster();

    }

    @SuppressWarnings("unused")
    private void d() {      //right
        this.squirrelMove = new XY(0, 1);
        player.nextStep(getState().getContext(), squirrelMove);
        updateAfterMaster();

    }

    @SuppressWarnings("unused")
    private void masterEnergy() {
        System.out.println("Your Energy: " + player.getEnergy());
    }

    @SuppressWarnings("unused")
    private void all() {
        System.out.println(getState().getBoard().toString());
    }

    @SuppressWarnings("unused")
    private static void help() {
        CommandTypeInfo[] commandTypeInfos = GameCommandType.values();
        System.out.println("These are the usable commands:");
        for (int i = 0; i <= commandTypeInfos.length - 1; i++) {
            System.out.println(commandTypeInfos[i].getName() + " " + commandTypeInfos[i].getHelpText());
        }
    }

    private Class[] getAllClasses(Object[] params) {
        if (params != null) {
            Class[] classArray = new Class[params.length];
            for (int i = 0; i <= classArray.length - 1; i++) {
                classArray[i] = params[i].getClass();
            }
            return classArray;
        } else
            return null;
    }
}
