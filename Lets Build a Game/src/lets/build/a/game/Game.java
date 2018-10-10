/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lets.build.a.game;

import java.awt.Canvas;

/**
 *
 * @author ThompsonB
 */
public class Game extends Canvas implements Runnable{
    
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    
    public Game(){
        new Window(WIDTH, HEIGHT, "let's Build a Game!", this);
    }
    
    public synchronized void start(){
        
    }
    
    @Override
    public void run(){
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Game();
    }
    
}
