package de.hsa.games.fastsquirrel.core;

import de.hsa.games.fastsquirrel.State;
import de.hsa.games.fastsquirrel.UI;
import de.hsa.games.fastsquirrel.console.ConsoleUI;

abstract public class Game {
    private State gameState;
    private BoardView view;
    private FlattenedBoard flattenedBoard;

    public UI ui = new ConsoleUI();

    public Game(State state){
    this.gameState=state;
    this.flattenedBoard=gameState.flattenedBoard();
    this.view=flattenedBoard;
    }
    public void run(){
        while (true){
            render();
            processInput();
            update();
        }
    }
    protected void render(){
        ui.render(view);
    }
    protected void processInput(){

    }
    protected void update(){
        gameState.update();
        flattenedBoard=gameState.flattenedBoard();
        view=flattenedBoard;

    }
    public State getState(){
        return gameState;
    }



}
