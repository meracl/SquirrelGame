package de.hsa.games.fastsquirrel.util.ui.consoletest;

public class Command {

    private CommandTypeInfo commandType;
    private Object[] params;

    public Command(CommandTypeInfo commandType, Object[] params) {
        this.commandType = commandType;
        this.params = params;
    }


    Object[] getParams() {
        return params;
    }

    CommandTypeInfo getCommandType(){
        return commandType;
    }
}
