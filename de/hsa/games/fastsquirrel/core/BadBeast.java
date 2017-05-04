package de.hsa.games.fastsquirrel.core;

import de.hsa.games.fastsquirrel.EntityType;
import de.hsa.games.fastsquirrel.XY;

public class BadBeast extends Character {
	final static int ENERGY = -150;
	private int bites=0;

	public BadBeast(int id, XY xy) {
		super(id, ENERGY, xy);

	}

	public void updateEnergy(int delta) {
	}
	public EntityType getEntityType(){
		return EntityType.BadBeast;
	}
	public void nextStep(EntityContext context){
		context.tryMove(this, XY.randomVec());
	}
	public int getBites(){
	    return bites;
    }
    public void addABite(){
	    bites++;
    }

}
