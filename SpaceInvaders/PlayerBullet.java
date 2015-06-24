package SpaceInvaders;

import apcs.Window;

public class PlayerBullet {
	int x;
	int y;
	int width;
	int height;
	int speed;
	
	public PlayerBullet(int x, int y) {
		this.x = x;
		this.y = y;
		width = 5;
		height = 10;
		speed = 10;
	}
	
	public void draw() {
		Window.out.color("red");
		Window.out.rectangle(x, y, width, height);
	}
	
	public void move() {
		y -= speed;
	}
	
	public boolean checkCollision(Enemy e) {
		if (Math.abs(x - e.x) <= width / 2 + e.side / 2 &&
				Math.abs(y - e.y) <= height / 2 + e.side / 2) 
		{
			return true;
		}
		
		return false;
	}
	
	public boolean checkCollision(EnemyBullet e) {
		if (Math.abs(x - e.x) <= width / 2 + e.width / 2 &&
				Math.abs(y - e.y) <= height / 2 + e.height / 2) 
		{
			return true;
		}
		
		return false;
	}
}
