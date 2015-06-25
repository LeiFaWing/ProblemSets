package flag;

import apcs.Window;

public class Flag implements Thing{

	int x;
	int y;
	int flag;
	String color;
	int width;
	int height;
	
	public Flag(int flag) {
		this.flag = flag;
		if (flag == 1) {
			x = 100;
			color = "blue";
		}
		else {
			x = Window.width() - 100;
			color = "red";
		}
		y = Window.height() / 2;
		width = 10;
		height = 20;
	}
	
	@Override
	public void draw() {
		Window.out.color(color);
		Window.out.rectangle(x, y, width, height);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int checkCollision(Thing otherThing) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isFlag() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void follow(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public int getRadius() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		return flag;
	}

}
