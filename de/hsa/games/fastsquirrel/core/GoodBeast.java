package de.hsa.games.fastsquirrel.core;

import de.hsa.games.fastsquirrel.EntityType;
import de.hsa.games.fastsquirrel.XY;
import de.hsa.games.fastsquirrel.core.Character;
import de.hsa.games.fastsquirrel.core.EntityContext;

public class GoodBeast extends Character {
	final static int ENERGY = 200;

	public GoodBeast(int id, XY xy) {
		super(id, ENERGY, xy);
	}

	public void updateEnergy(int delta) {
	}
	public EntityType getEntityType(){
		return EntityType.GoodBeast;
	}
	public void nextStep(EntityContext context){
		context.tryMove(this, XY.randomVec());
	}
}
