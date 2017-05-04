package de.hsa.games.fastsquirrel.core;

import de.hsa.games.fastsquirrel.EntityType;
import de.hsa.games.fastsquirrel.XY;
import de.hsa.games.fastsquirrel.core.Entity;
import de.hsa.games.fastsquirrel.core.EntityContext;

public class GoodPlant extends Entity {
	final static int ENERGY = 100;

	public GoodPlant(int id, XY xy) {
		super(id, ENERGY, xy);
	}


	public EntityType getEntityType(){
		return EntityType.GoodPlant;
	}
	public void nextStep(EntityContext context){
	}

}
