package Avoider;

import java.util.ArrayList;

import apcs.Window;

public class Game {

	public static void main(String[] args) {

		Window.size(700, 700);

		int time = 1;

		Player p = new Player("steve");

		ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

		for (int i = 0; i < 5; i++) {
			obstacles.add(new Obstacle());
		}

		while (true) {
			Window.out.background("black");
			
			Window.out.fontSize(40);
			Window.out.color("lime green");
			Window.out.print("Score: " + time, 20, 40);
			Window.out.print("Health: " + p.health, 20, 80);

			p.draw();
			p.move();

			for (int i = 0; i < obstacles.size(); i++) {
				obstacles.get(i).draw();
				obstacles.get(i).move();

				if (obstacles.get(i).outside()) {
					obstacles.remove(i);
				}
			}
			
			for (int i = 0; i < obstacles.size(); i++) {
				if (p.collision(obstacles.get(i))) {
					p.health--;
					obstacles.remove(i);
				}
			}

			if (time % 100 == 0) {
				for (int i = 0; i < time / 50; i++) {
					obstacles.add(new Obstacle());
				}
			}
			
			if (p.health < 0) {
				System.exit(0);
			}

			time++;

			Window.frame();
		}
	}
}
