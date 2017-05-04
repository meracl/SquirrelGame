package de.hsa.games.fastsquirrel.core;

import de.hsa.games.fastsquirrel.XY;

public class Character extends Entity {
    int move = 0;

    public Character(int id, int energy, XY xy) {
        super(id, energy, xy);
    }

    public int getMove() {
        return move;
    }

    public void addMove(int delta) {
        this.move += delta;
    }
    public void setMove(int i){
        this.move=i;
    }

}
