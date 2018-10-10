package com.darkpocketscloudfull.cloud.entity;

import java.util.Random;

import com.darkpocketscloudfull.cloud.graphics.Screen;
import com.darkpocketscloudfull.cloud.level.Level;

public abstract class Entity {
	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random ( );
	
	public void update ( ) {
		
	}
	
	public void render ( Screen screen) {
		
	}
	
	public void removed ( ) {
		//Removed from level 
		removed = true;
	}
	
	public boolean isRemoved ( ) {
		return removed;
	}
	
	

}
