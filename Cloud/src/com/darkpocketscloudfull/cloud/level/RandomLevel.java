package com.darkpocketscloudfull.cloud.level;

import java.util.Random;
import com.darkpocketscloudfull.cloud.level.Level;

public class RandomLevel extends Level {
	
	private static final Random random = new Random();

	public RandomLevel (int width, int height) {
		super (width, height);
		
	}
	
	protected void generateLevel ( ){
		for ( int y = 0; y < height; y++) {
			for ( int x = 0; x < width; x++) {
				tiles [x + y * width] = random.nextInt ( 4 );
			}
		}
	}

}
