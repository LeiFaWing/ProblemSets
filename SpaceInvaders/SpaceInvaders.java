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
		boolean start = false;
		boolean gameover = false;
		int lives = 3;
		int score = 0;
		int highscore = 0;
		int fontsize = 40;
		
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
		
		int y = 50;
		int x = 0;
		// add enemies to enemy list
		for (int i = 0; i < 50; i++) {
			if (i % 10 == 0 && i != 0) {
				y += 50;
				x = 0;
			}
			enemies.add(new Enemy(x * 25 + 25, y));
			x++;
		}
		
		while(true) {
			
			while (start == false) {
				drawBackground();
				fontsize = 40;
				Window.out.font("arial", fontsize);
				Window.out.color("Blue");
				Window.out.print("Space Invader", Window.width() / 2 - fontsize * 3 
						, Window.height() / 3);
				fontsize = 25;
				Window.out.fontSize(fontsize);
				Window.out.color("Blue");
				Window.out.print("Press fire to start", Window.width() / 2 - fontsize * 4
						, Window.height() / 2);
				
				if (Window.key.pressed("space")) {
					start = !start;
				}
				
				Window.frame();
			}
			
			drawBackground();
			fontsize = 20;
			Window.out.font("arial", fontsize);
			Window.out.color(0, 255, 0);
			Window.out.print("Score: " + score, 20, 40);
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
					lives--;
					if (lives <= 0) {
						alive = false;
					}
				}
			}
			
			// check player bullet collision with enemies
			for (int i = 0; i < pbs.size(); i++) {
				enemyLoop: for (int j = 0; j < enemies.size(); j++) {
					if (pbs.get(i).checkCollision(enemies.get(j))) {
						pbs.remove(i);
						enemies.remove(j);
						i--;
						score++;
						break enemyLoop;
					}
				}
			}
			
			// check player bullet collision with enemy bullet
			for (int i = 0; i < pbs.size(); i++) {
				for (int j = 0; j < ebs.size(); j++) {
					if (pbs.get(i).checkCollision(ebs.get(j))) {
						pbs.remove(i);
						ebs.remove(j);
						i--;
						break;
					}
				}
			}
			
			if (alive == false) {
				if (score > highscore) {
					highscore = score;
				}
				gameover = true;
			}
			
			// show win screen after enemies are destroyed
			if (enemies.size() <= 0) {
				//drawBackground();
				fontsize = 50;
				Window.out.font("arial", fontsize);
				Window.out.color("purple");
				Window.out.print("You Win", Window.width() / 2 - fontsize * 3 
						, Window.height() / 3);
				fontsize = 40;
				Window.out.fontSize(fontsize);
				Window.out.print("Score: " + score, Window.width() / 2 - fontsize * 3 
						, Window.height() / 2);
				Window.frame(3000);
				pbs.clear();
				ebs.clear();
				enemies.clear();
				y = 50;
				x = 0;
				// add enemies to enemy list
				for (int i = 0; i < 50; i++) {
					if (i % 10 == 0 && i != 0) {
						y += 50;
						x = 0;
					}
					enemies.add(new Enemy(x * 25 + 25, y));
					x++;
				}
				lives = 3;
				alive = true;
				score = 0;
				p.reset();
				start = !start;
			}
			
			// show gameover screen when no lives are left
			if (gameover == true) {
				Window.out.color("red");
				fontsize = 40;
				Window.out.font("arial", fontsize);
				Window.out.print("Game Over", Window.width() / 2 - fontsize * 3
						, Window.height() / 3);
				fontsize = 30;
				Window.out.fontSize(fontsize);
				Window.out.print("Score: " + score, Window.width() / 2 - fontsize * 3 
						, Window.height() / 2);
				Window.frame(3000);
				pbs.clear();
				ebs.clear();
				enemies.clear();
				// add enemies to enemy list
				y = 50;
				x = 0;
				// add enemies to enemy list
				for (int i = 0; i < 50; i++) {
					if (i % 10 == 0 && i != 0) {
						y += 50;
						x = 0;
					}
					enemies.add(new Enemy(x * 25 + 25, y));
					x++;
				}
				lives = 3;
				alive = true;
				score = 0;
				p.reset();
				gameover = !gameover;
				start = !start;
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
