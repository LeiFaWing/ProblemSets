package day5;

import apcs.Window;

public class MultipleBalls {

	public static void main(String[] args) {
		Window.size(800, 800);
		Window.frame();

		int numberOfBalls = 500;
		
		// variables for all balls
		int[] ballx = new int[numberOfBalls];
		int[] bally = new int[numberOfBalls];
		int[] red = new int[numberOfBalls];
		int[] blue = new int[numberOfBalls];
		int[] green = new int[numberOfBalls];
		int[] xspeed = new int[numberOfBalls];
		int[] yspeed = new int[numberOfBalls];
		
		for (int i = 0; i < numberOfBalls; i++) {
			// randomize the position of the balls
			//ballx[i] = Window.rollDice(Window.width());
			//bally[i] = Window.rollDice(Window.height());
			// set x and y positions to middle of screen
			ballx[i] = Window.width() / 2;
			bally[i] = Window.height() / 2;
			// randomize the colors of the balls
			red[i] = Window.rollDice(256) - 1;
			blue[i] = Window.rollDice(256) - 1;
			green[i] = Window.rollDice(256) - 1;
			// randomize the speed of the balls
			xspeed[i] = Window.rollDice(21) - 11;
			yspeed[i] = Window.rollDice(21) - 11;
		}
		
		while (true) {
			Window.out.background("white");
			
			for (int i = 0; i < numberOfBalls; i++) {
				// draw each ball
				Window.out.color(red[i], green[i], blue[i]);
				Window.out.circle(ballx[i], bally[i], 20);
				
				// move each ball
				ballx[i] += xspeed[i];
				bally[i] += yspeed[i];
				
				// make the ball bounce of the edges of the screen
				if (ballx[i] < 20) {
					ballx[i] = 20;
					xspeed[i] = -xspeed[i];
				}
				if (bally[i] < 20) {
					bally[i] = 20;
					yspeed[i] = -yspeed[i];
				}
				if (ballx[i] > Window.width() - 20) {
					ballx[i] = Window.width() - 20;
					xspeed[i] = -xspeed[i];
				}
				if (bally[i] > Window.height() - 20) {
					bally[i] = Window.height() - 20;
					yspeed[i] = -yspeed[i];
				}
			}
			
			Window.frame();
		}
	}

}




