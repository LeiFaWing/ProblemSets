package SpaceInvaders;

import java.util.ArrayList;

import apcs.Window;

public class SpaceInvaders {
	
	// position of stars
	static int[] starx = new int[200];
	static int[] stary = new int[200];
	
	public static void main(String[] args) {
		
		Window.size(500, 800);
		
		// boolean for player state
		boolean alive = true;
		
		// randomize x and y of stars
		for (int i = 0; i < starx.length; i++) {
			starx[i] = Window.rollDice(Window.width());
			stary[i] = Window.rollDice(Window.height());
		}
		
		// create player object
		Player p = new Player();
		
		// arraylist of player bullets
		ArrayList<PlayerBullet> pbs = new ArrayList<PlayerBullet>();
		
		// arraylist of enemies
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		
		// arraylist of enemy bullets
		ArrayList<EnemyBullet> ebs = new ArrayList<EnemyBullet>();
		
		// add enemies to enemy list
		for (int i = 0; i < 5; i++) {
			enemies.add(new Enemy());
		}
		
		while(true) {
			drawBackground();
			p.draw();
			p.move();
			
			// check if player is shooting
			if (p.shoot()) {
				// add bullet to player bullet list
				pbs.add(new PlayerBullet(p.x, p.y));
			}
			
			// enemy stuff
			for (int i = 0; i < enemies.size(); i++) {
				enemies.get(i).draw();
				enemies.get(i).move();
				
				if (enemies.get(i).shoot()) {
					ebs.add(new EnemyBullet(enemies.get(i).x, enemies.get(i).y));
				}
			}
			
			// player bullet stuff
			for (int i = 0; i < pbs.size(); i++) {
				pbs.get(i).draw();
				pbs.get(i).move();
				
				if (pbs.get(i).y < -pbs.get(i).height / 2) {
					pbs.remove(i);
					i--;
				}
			}
			
			// enemy bullet stuff
			for (int i = 0; i < ebs.size(); i++) {
				ebs.get(i).draw();
				ebs.get(i).move();
				
				if (ebs.get(i).y > Window.height() + ebs.get(i).height / 2) {
					ebs.remove(i);
					i--;
				}
			}
			
			// check enemy bullet collision with player
			for (int i = 0; i < ebs.size(); i++) {
				if (ebs.get(i).checkCollision(p)) {
					ebs.remove(i);
					i--;
					alive = false;
				}
			}
			
			// check player bullet collision with enemies
			for (int i = 0; i < pbs.size(); i++) {
				enemyLoop: for (int j = 0; j < enemies.size(); j++) {
					if (pbs.get(i).checkCollision(enemies.get(j))) {
						pbs.remove(i);
						enemies.remove(j);
						i--;
						break enemyLoop;
					}
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
