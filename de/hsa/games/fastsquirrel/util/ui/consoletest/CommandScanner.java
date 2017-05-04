package de.hsa.games.fastsquirrel.util.ui.consoletest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class CommandScanner {

    CommandTypeInfo[] commandTypeInfos=MyFavoriteCommandType.values();
    BufferedReader inputStream;
    PrintStream outputStream;

    public Command next() {
        String input=null;
        try {
            input = inputStream.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i=0;i<=commandTypeInfos.length-1;i++){
            String test = commandTypeInfos[i].getName();
            if(commandTypeInfos[i].getName().equals(input)) {
                return new Command(commandTypeInfos[i], commandTypeInfos[i].getParamTypes());
            }
        }
        return null;
    }

    public CommandScanner(CommandTypeInfo[] commandTypeInfo, BufferedReader inputStream) {
        this.commandTypeInfos = commandTypeInfo;
        this.inputStream = inputStream;
    }

}
