package SpaceInvaders;

import apcs.Window;

public class Star {

	int r, g, b;
	int x, y;
	
	public Star() {
		x = Window.rollDice(Window.width());
		y = Window.rollDice(Window.height());
		r = Window.rollDice(256) - 1;
		g = Window.rollDice(256) - 1;
		b = Window.rollDice(256) - 1;
	}
	
	public void draw() {
		Window.out.color(r, g, b);
		Window.out.circle(x, y, Window.rollDice(5));
	}
}
