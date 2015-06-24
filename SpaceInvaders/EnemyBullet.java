package SpaceInvaders;

import apcs.Window;

public class EnemyBullet {
	int x;
	int y;
	int width;
	int height;
	int speed;
	
	public EnemyBullet(int x, int y) {
		this.x = x;
		this.y = y;
		width = 5;
		height = 10;
		speed = 10;
	}
	
	public void draw() {
		Window.out.color("yellow");
		Window.out.rectangle(x, y, width, height);
	}
	
	public void move() {
		y += speed;
	}
	
	public boolean checkCollision(Player e) {
		if (Math.abs(x - e.x) <= width / 2 + e.radius &&
				Math.abs(y - e.y) <= height / 2 + e.radius) 
		{
			return true;
		}
		
		return false;
	}
	
	public boolean checkCollision(PlayerBullet e) {
		if (Math.abs(x - e.x) <= width / 2 + e.width / 2 &&
				Math.abs(y - e.y) <= height / 2 + e.height / 2) 
		{
			return true;
		}
		
		return false;
	}
}
