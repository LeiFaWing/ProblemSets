package day1;

import java.util.ArrayList;

import apcs.Window;

public class FroggerGame {

	static int x = 400;
	static int y = 450;
	static int cooldown = 5;
	static int carx = -100;
	static int cary = Window.rollDice(3) * 100 + 50;
	static int carWidth = Window.rollDice(3) * 25 + 50;
	
	static int score = 0;
	static int highscore = 0;
	static int deaths = 0;
	static ArrayList<Car> cars = new ArrayList<Car>();
	
	public static void main(String[] args) {
		Window.size(800, 500);
		
		Frog f = new Frog();

		
		for (int i = 0; i < 10; i++) {
			if (Window.rollDice(10) <= 5) {
				cars.add(new Car(-1));
			}
			else {
				cars.add(new Car(1));
			}
		}
		
		while (true) {
			drawBackground();
			f.draw();
			f.move();
			
			for (int i = 0; i < cars.size(); i++) {
				cars.get(i).draw();
				cars.get(i).move();
				
				if (cars.get(i).checkCollision(f)) {
					f.reset();
					deaths++;
					score = 0;
					if (cars.size() > 10) {
						cars.remove(cars.size() - 1);
					}
					//cars.get(i).reset();
				}
			}
			
			if (f.y < -f.radius) {
				score++;
				f.reset();
				if (Window.rollDice(10) <= 5) {
					cars.add(new Car(-1));
				}
				else {
					cars.add(new Car(1));
				}
			}
			
			if (score > highscore) {
				highscore = score;
			}

			Window.frame();
		}
	}

	private static void checkCollision() {
		if (Math.abs(x - carx) <= carWidth / 2 + 25 && Math.abs(y - cary) <= 40 + 25) {
			x = 400;
			y = 450;
			carx = -100;
			cary = Window.rollDice(3) * 100 + 50;
		}
	}

	private static void moveCar() {
		// moves car to the right
		carx += 10;
		
		// reset car position
		if (carx >= Window.width() + carWidth / 2) {
			carx = -100;
			cary = Window.rollDice(3) * 100 + 50;
		}
	}

	private static void drawCar() {
		Window.out.color("red");
		Window.out.rectangle(carx, cary, carWidth, 80);
	}

	private static void moveFrog() {
		if (Window.key.pressed("up") && cooldown >= 5) {
			y -= 100;
			cooldown = 0;
		}
		else if (Window.key.pressed("down") && cooldown >= 5) {
			y += 100;
			cooldown = 0;
		}
		else if (Window.key.pressed("right") && cooldown >= 5) {
			x += 50;
			cooldown = 0;
		}
		else if (Window.key.pressed("left") && cooldown >= 5) {
			x -= 50;
			cooldown = 0;
		}
	}

	private static void drawFrog() {
		Window.out.color("light green");
		Window.out.circle(x, y, 25);
	}

	private static void drawBackground() {
		// background
		Window.out.background("grey");
		
		// grass
		Window.out.color("dark green");
		Window.out.rectangle(Window.width() / 2, 50, Window.width(), 100);
		Window.out.rectangle(Window.width() / 2, Window.height() - 50, Window.width(), 100);
		
		// road lines
		Window.out.color("yellow");
		for (int i = 0; i < Window.width() / 100; i++) {
			Window.out.rectangle(50 + (i * 100), 200, 50, 10);
			Window.out.rectangle(50 + (i * 100), 300, 50, 10);
		}
		
		// score and deaths
		Window.out.color("white");
		Window.out.fontSize(30);
		Window.out.print("Score: " + score, 25, 450);
		Window.out.print("High Score: " + highscore, 500, 450);
		Window.out.print("Roadkill: " + deaths, 500, 25);
		Window.out.print("Cars: " + cars.size(), 25, 25);
	}
	

}
