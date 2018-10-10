package com.darkpocketscloudfull.cloud;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.darkpocketscloudfull.cloud.graphics.Screen;
import com.darkpocketscloudfull.cloud.input.Keyboard;
import com.darkpocketscloudfull.cloud.level.Level;
import com.darkpocketscloudfull.cloud.level.RandomLevel;

public class Cloud extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	
	//game window and size
    public static int width = 300;
    public static int height = 168;
    public static int scale = 3;
   public static String title = "Cloud";
    
   private Thread thread;
   private JFrame frame;
   private Keyboard key;
   private Level level;
   private boolean running = false; 
   
    private Screen screen;
    
    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int [ ] pixels = ((DataBufferInt)image.getRaster( ) .getDataBuffer ( )) .getData ( ) ;
    
    public Cloud ( ) {
    	Dimension size = new Dimension (width * scale, height * scale);
    	setPreferredSize (size);
    	
    	screen = new Screen (width, height );
    	frame = new JFrame ( );
    	key = new Keyboard ( );
    	level = new RandomLevel ( 64, 64 ); 
    	
    	addKeyListener ( key );
    }
    
    public synchronized void start () {
    	running = true;
    	thread = new Thread (this, "Display") ;
    	thread.start () ;
    }
    public synchronized void stop () {
    	running = false;
    	try {
    	thread.join ();
    } catch  (InterruptedException e) {
    	e.printStackTrace ();
    }
    }
    
    public void run () {
    	long lastTime = System.nanoTime ( );
    	long timer = System.currentTimeMillis( );
    	final double ns = 1000000000.0 / 60.0;
    	double delta = 0;
    	int frames = 0;
    	int updates = 0;
    	requestFocus();
    	while (running) {
    		long now = System.nanoTime ( );
    		delta += (now - lastTime) / ns;
    		lastTime = now;
    		while (delta >= 1) {
    			update ();
    			updates ++;
    			delta --;
    		}
    	
    		render ( );
    		frames ++;
    		
    		if (System.currentTimeMillis( ) - timer > 1000) {
    			timer += 1000;
    			frame.setTitle (title + "  |  " + updates + " ups, " + frames + " fps");
    			updates = 0;
    			frames = 0;
    		}
    	}
    	stop ( );
    }
    
    int x = 0, y = 0;
    
    public void update ( ) {
    	key.update ( );
  
        if ( key.up )  y--;
    	if ( key.down )  y++;
    	if ( key.left ) x--;
    	if ( key.right ) x ++; 
    }
     
    public void render ( ) {
    	BufferStrategy bs = getBufferStrategy ( );
    	if (bs == null){
    		createBufferStrategy ( 3 ) ;
    		return;
    	}
    	
    	screen.clear ( );
    	level.render( x, y, screen);
    	
    	for (int i = 0 ; i < pixels.length; i++ ) {
    		pixels[ i ] = screen.pixels[ i ];
    	}
    	
    	Graphics g = bs.getDrawGraphics ( ) ; 
    	//This is where your graphics lay

    	g.drawImage(image,  0,  0,  getWidth( ), getHeight( ), null);
    	g.dispose ( ) ;  //removes current graphics to make room for new graphics
    	bs.show ( ) ;
    }
    
    public static void main (String[ ] args) {
    	Cloud cloud = new Cloud ();
    	cloud.frame.setResizable (false);
    	cloud.frame.setTitle(Cloud.title);
    	cloud.frame.add(cloud);
    	cloud.frame.pack( );
    	cloud.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	cloud.frame.setLocationRelativeTo(null);
    	cloud.frame.setVisible(true);
    	
    	cloud.start ( );
    }
}

