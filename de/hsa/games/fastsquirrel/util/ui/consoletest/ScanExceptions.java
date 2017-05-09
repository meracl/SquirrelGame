package de.hsa.games.fastsquirrel.util.ui.consoletest;


import java.io.IOException;

public class ScanExceptions extends Exception{
    ScanExceptions(IOException e) {
        System.out.println("IOE");
    }
    ScanExceptions(IndexOutOfBoundsException e) {
        System.out.println("missing input!");
    }

    ScanExceptions(NullPointerException e) {
        System.out.println("no input!");

    }


}
