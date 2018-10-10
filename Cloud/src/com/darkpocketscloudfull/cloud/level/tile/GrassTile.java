package com.darkpocketscloudfull.cloud.level.tile;

import com.darkpocketscloudfull.cloud.graphics.Screen;
import com.darkpocketscloudfull.cloud.graphics.Sprite;

public class GrassTile extends Tile {

	public GrassTile(Sprite sprite) {
		super(sprite);
	}
    
	public void render (int x, int y, Screen screen ) {
		// Do rendering stuff stuff here pls!
		screen.renderTile(x << 4,  y << 4,  this);
	}
	
	
	
	
} 
