package SpaceInvaders;

import apcs.Window;

public class Bullet implements Thing {
	
	int x, y, speed, size;
	String color;
	boolean enemy;

	public Bullet(int x, int y, boolean enemy) {
		this.x = x;
		this.y = y;
		speed = 10;
		size = 10;
		color = "yellow";
		this.enemy = enemy;
	}
	
	@Override
	public void draw() {
		Window.out.color(color);
		Window.out.square(x, y, size);
	}

	@Override
	public void move() {
		if (isEnemy()) {
			y += speed;
		}
		else {
			y -= speed;
		}
	}

	@Override
	public boolean isTouching(Thing t) {
		if (isEnemy() != t.isEnemy()) {
			if (Math.abs(x - t.getX()) < size / 2 + t.getSize() / 2 
					&& Math.abs(y - t.getY()) < size / 2 + t.getSize() / 2) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean isEnemy() {
		return enemy;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean shoot() {
		return false;
	}

	@Override
	public boolean outside() {
		if (isEnemy()) {
			if (y > Window.height() + 50) {
				return true;
			}
		}
		else {
			if (y < -50) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean isEnemySpaceship() {
		// TODO Auto-generated method stub
		return false;
	}

}
