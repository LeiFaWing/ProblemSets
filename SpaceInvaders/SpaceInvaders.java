package SpaceInvaders;

import java.util.ArrayList;

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
		
		// arraylist of player bullets
		ArrayList<PlayerBullet> pbs = new ArrayList<PlayerBullet>();
		
		while(true) {
			drawBackground();
			p.draw();
			p.move();
			
			if (p.shoot()) {
				pbs.add(new PlayerBullet(p.x, p.y));
			}
			
			for (int i = 0; i < pbs.size(); i++) {
				pbs.get(i).draw();
				pbs.get(i).move();
				
				if (pbs.get(i).y < -pbs.get(i).height / 2) {
					pbs.remove(i);
					i--;
				}
			}
			
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
