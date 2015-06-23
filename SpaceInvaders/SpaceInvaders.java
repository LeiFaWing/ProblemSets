package SpaceInvaders;

import apcs.Window;

public class SpaceInvaders {
	
	// position of stars
	static int[] starx = new int[200];
	static int[] stary = new int[200];
	
	public static void main(String[] args) {
		
		Window.size(500, 800);
		// randomize x and y of stars
		for (int i = 0; i < starx.length; i++) {
			starx[i] = Window.rollDice(Window.width());
			stary[i] = Window.rollDice(Window.height());
		}
		
		// create player object
		Player p = new Player();
		
		while(true) {
			drawBackground();
			p.draw();
			p.move();
			
			Window.frame();
		}
	}
	
	
	public static void drawBackground() {
		Window.out.background("black");
		// draw stars
		for (int i = 0; i < 200; i++) {
			Window.out.color("white");
//			Window.out.circle(Window.rollDice(Window.width()),
//					Window.rollDice(Window.height()), 1);
			Window.out.circle(starx[i], stary[i], Window.rollDice(3));
		}
	}

}
