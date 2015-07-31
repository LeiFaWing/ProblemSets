package CTFOnline;

import apcs.Window;

public class Player implements Thing{

	int x, y, radius, speed, team;
	String color, name;
	boolean hasFlag = false;

	public Player(int team, String name) {
		this.name = name;
		this.team = team;
		if (team == 1) {
			x = 100;
			color = "blue";
		}
		else if (team == 2) {
			x = Window.width() - 100;
			color = "red";
		}
		y = Window.height() / 2;
		radius = 20;
		speed = 15;
	}

	@Override
	public void draw() {
		if (team == 1) {
			color = "blue";
		}
		else if (team == 2) {
			color = "red";
		}
		Window.out.color(color);
		Window.out.circle(x, y, radius);
		Window.out.color("white");
		Window.out.print(name, x, y);
	}

	@Override
	public void move() {

		if (Window.key.pressed("w") && y > radius) {
			y -= speed;
		}
		if (Window.key.pressed("s") && y < Window.height() - radius){
			y += speed;
		}
		if (Window.key.pressed("a") && x > radius) {
			x -= speed;
		}
		if (Window.key.pressed("d") && x < Window.width() - radius) {
			x += speed;
		}

	}

	@Override
	public boolean isFlag() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int checkCollision(Thing t) {

		// check if you are touching the other team's flag
		if (t.isFlag() && t.getTeam() != team) {
			if (Math.abs(x - t.getX()) <= radius + t.getWidth() / 2 &&
					Math.abs(y - t.getY()) <= radius + t.getHeight() / 2) {
				hasFlag = true;
				return 1;
			}
		}
		// check if you are touching another player
		else if (!t.isFlag() && t.getTeam() != team) {
			// check if the other player is on your side of the field (left side)
			if (team == 1 && t.getX() < Window.width() / 2) {
				if (Math.abs(x - t.getX()) <= radius + t.getRadius() &&
						Math.abs(y - t.getY()) <= radius + t.getRadius()) {
					return 2;
				}
			}
			// check if the other player is on your side of the field (right side)
			if (team == 2 && t.getX() > Window.width() / 2) {
				if (Math.abs(x - t.getX()) <= radius + t.getRadius() &&
						Math.abs(y - t.getY()) <= radius + t.getRadius()) {
					return 2;
				}
			}
		}
		// check if player touched their own flag
		else if (t.isFlag() && t.getTeam() == team && !hasFlag) {
			if (Math.abs(x - t.getX()) <= radius + t.getWidth() / 2 &&
					Math.abs(y - t.getY()) <= radius + t.getHeight() / 2) {
				return 2;
			}
		}
		// check if player has opponent's flag and is touching their own flag
		else if (hasFlag && t.isFlag() && t.getTeam() == team) {
			if (Math.abs(x - t.getX()) <= radius + t.getWidth() / 2 &&
					Math.abs(y - t.getY()) <= radius + t.getHeight() / 2) {
				return 3;
			}
		}

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
		return radius;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void reset() {
		if (team == 1) {
			x = 100;
			color = "red";
		}
		else {
			x = Window.width() - 100;
			color = "red";
		}
		y = Window.height() / 2;
		hasFlag = false;
	}

	@Override
	public void follow(int x, int y) {
		// TODO Auto-generated method stub

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






