
import apcs.Window;

public class ReviewStuff {

	public static void main(String[] args) {
		
		int width = 900;
		int height = 400;
		
		// change the size of the screen
		Window.size(width, height);
		
		// Set the coordinates for the circle
		int x = Window.width() / 2;
		int y = Window.height() / 2;
		int xspeed = 5;
		int yspeed = 5;
		
		while (true) {
			// draw the background
			Window.out.background("red");
			
			// set the color and draw a circle
			Window.out.color("blue");
			Window.out.circle(x, y, 25);
			
			// change the coordinates of the circle
			if (Window.key.pressed("left")) {
				x = x - xspeed;
			}
			if (Window.key.pressed("right")) {
				x = x + xspeed;
			}
			if (Window.key.pressed("down")) {
				y = y + yspeed;
			}
			if (Window.key.pressed("up")) {
				y = y - yspeed;
			}
			
			//y = Window.rollDice(Window.height());
			
			// goes out right side of screen
			if (x > Window.width() + 25) {
				x = -25;
				y = Window.height() - y;
			}
			
			// left side of screen
			if (x < -25) {
				x = Window.width() + 25;
				y = Window.height() - y;
			}
			
			// bottom side of screen
			if (y > Window.height() + 25) {
				y = -25;
				x = Window.width() - x;
			}
			
			// top side of screen
			if (y < -25) {
				y = Window.height() + 25;
				x = Window.width() - x;
			}
			
			Window.frame();
		}
	}
}
