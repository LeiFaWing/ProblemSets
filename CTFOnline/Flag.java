package CTFOnline;

import apcs.Window;

public class Flag implements Thing{
	
	int x, y, width, height, team;
	String color, name;
	
	public Flag(int team, String name) {
		this.name = name;
		this.team = team;
		if (team == 1) {
			x = 50;
			color = "blue";
		}
		else {
			x = Window.width() - 50;
			color = "red";
		}
		y = Window.height() / 2;
		width = 30;
		height = 25;
	}

	@Override
	public void draw() {
		Window.out.color(color);
		Window.out.rectangle(x + width / 2, y - height * 2 / 3, width, height);
		Window.out.color("black");
		Window.out.rectangle(x, y, width / 10, height * 2);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isFlag() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int checkCollision(Thing t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTeam() {
		// TODO Auto-generated method stub
		return team;
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
	public void reset() {
		if (team == 1) {
			x = 50;
		}
		else {
			x = Window.width() - 50;
		}
		y = Window.height() / 2;
	}

	@Override
	public void follow(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		this.y = y;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setTeam(int team) {
		// TODO Auto-generated method stub
		this.team = team;
	}

}







