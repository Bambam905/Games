package com.darkpocketscloudfull.cloud.level.tile;

import com.darkpocketscloudfull.cloud.graphics.Screen;
import com.darkpocketscloudfull.cloud.graphics.Sprite;

public class VoidTile extends Tile {

	public VoidTile(Sprite sprite) {
		super(sprite);
		
	}
	
	public void render (int x, int y, Screen screen ) {
		// Do rendering stuff stuff here!
		screen.renderTile(x << 4,  y << 4,  this);
	}
}
