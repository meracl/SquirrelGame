package de.hsa.games.fastsquirrel.core;

import de.hsa.games.fastsquirrel.EntityType;
import de.hsa.games.fastsquirrel.XY;

abstract class Entity {
    private int id;
    private int energy;
    private XY xy;

    protected Entity(int id, int energy, XY xy) {
        this.id = id;
        this.energy = energy;
        this.xy = xy;
    }

    public int getId() {
        return id;
    }

    public int getEnergy() {
        return energy;
    }

    public XY getXy() {
        return xy;
    }
    void setXy(XY newxy) {
        this.xy=newxy;
    }

    public void updateEnergy(int delta) {
        energy = energy + delta;
    }

    void nextStep(EntityContext context) {
    }

    public String toString() {
        return this.getEntityType() + " mit ID: " + getId() + " Energy: " + getEnergy() + " Koordinaten " + xy;
    }

    public static int randomVek() {
        int i = (int) (Math.random() * 3) - 1;
        return i;
    }
    public EntityType getEntityType(){
        return EntityType.Entity;
    }



}