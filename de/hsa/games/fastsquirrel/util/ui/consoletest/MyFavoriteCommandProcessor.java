package de.hsa.games.fastsquirrel.util.ui.consoletest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class MyFavoriteCommandProcessor {


    public void process() {
        PrintStream outputStream = System.out;
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        CommandScanner commandScanner = new CommandScanner(MyFavoriteCommandType.values(), inputReader);

        while (true) { // the loop over all commands with one input line for every command
            Command command = commandScanner.next();

            Object[] params = command.getParams();

            MyFavoriteCommandType commandType = (MyFavoriteCommandType) command.getCommandType();

            switch (commandType) {
                case EXIT:
                    System.exit(0);
                case HELP:
                    help();
                    break;
                case ADDI:
            }

        }
    }

    private static void help() {
        System.out.println("Du willst Hilfe");
    }

    public static void main(String[] args) {
        MyFavoriteCommandProcessor process = new MyFavoriteCommandProcessor();
        process.process();
    }
}
