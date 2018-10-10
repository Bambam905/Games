package com.darkpocketscloudfull.cloud.entity.mob;

import com.darkpocketscloudfull.cloud.entity.Entity;
import com.darkpocketscloudfull.cloud.graphics.Sprite;

public abstract class Mob extends Entity {
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	
	public void moving ( ) {
		
	}
	
	public void update ( ) {
		
	}
	
	private boolean collision ( ) {
		return false; 	
	}
	
	public void render ( ) {
		
	}

}
