package Simulation;

import java.util.ArrayList;

import apcs.Window;

public class Survival {

	static ArrayList<Circle> circles;
	static int numberOfCircles;
	
	public static void main(String[] args) {
		
		setup();
		
		while (true) {
			Window.out.background("white");
			for (Circle c: circles) {
				c.draw();
				c.move();
				for (Circle a : circles) {
					if (c != a && c.checkCollision(a)) {
						c.dx = Window.rollDice(21) - 11;
						c.dy = Window.rollDice(21) - 11;
						a.dx = Window.rollDice(21) - 11;
						a.dy = Window.rollDice(21) - 11;
						c.r = a.r;
						c.g = a.g;
						c.b = a.b;
					}
				}
			}
			
			Window.frame();
		}
		
		
	}
	
	public static void setup() {
		Window.size(1600, 800);
		numberOfCircles = 200;
		circles = new ArrayList<Circle>();
		
		for (int i = 0; i < numberOfCircles; i++) {
			circles.add(new Circle());
		}
	}

}
