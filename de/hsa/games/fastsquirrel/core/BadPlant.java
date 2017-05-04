package de.hsa.games.fastsquirrel.core;

import de.hsa.games.fastsquirrel.EntityType;
import de.hsa.games.fastsquirrel.XY;
import de.hsa.games.fastsquirrel.core.Entity;
import de.hsa.games.fastsquirrel.core.EntityContext;

public class BadPlant extends Entity {
	final static int ENERGY = -100;

	public BadPlant(int id, XY xy) {
		super(id, ENERGY, xy);
	}


	public EntityType getEntityType(){
		return EntityType.BadPlant;
	}
	public void nextStep(EntityContext context){
	}

}
