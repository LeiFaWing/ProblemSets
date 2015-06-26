package day2;

import apcs.Window;

public class Player {
	
	int x;
	int y;
	int width;
	int height;
	
	public Player() {
		x = Window.width() / 2;
		y = Window.height() - 100;
		width = 50;
		height = 20;
	}
	
	public void draw() {
		Window.out.color("blue");
		Window.out.rectangle(x, y, width, height);
	}
	
	public void move() {
		x = Window.mouse.getX();
	}
}






