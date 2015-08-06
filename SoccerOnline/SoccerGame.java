package soccer;

import java.util.ArrayList;

import apcs.Data;
import apcs.Window;

public class SoccerGame {

	public static void main(String[] args) {

		Window.size(1000, 600);
		Window.setFrameRate(30);


		Data.connect("socceronline");

		String[] names = { "steve", "vaishavi", "natasha" };

		String myName = "steve";

		// create yourself
		Player p = new Player(1, myName);

		// write your data to server
		Data.write(myName + "x", p.x);
		Data.write(myName + "y", p.y);
		Data.write(myName + "team", p.team);

		// create ball
		Ball b = new Ball();

		// write ball data to server
		//for (int i = 0; i < 500; i++) {
			Data.write("ballx", b.x);
			Data.write("bally", b.y);
		//}
		
		System.out.println(Data.read("ballx") + " " + Data.read("bally"));

		ArrayList<Player> players = new ArrayList<Player>();

		for (int i = 0; i < names.length; i++) {
			// add everybody but yourself into the arraylist
			if (!names[i].equals(p.name)) {
				int team = Data.read(names[i] + "team");
				players.add(new Player(team, names[i]));
			}
		}


		while (true) {
			drawBackground();

			p.draw();
			p.move();

			// always write your position to the server
			Data.write(myName + "x", p.x);
			Data.write(myName + "y", p.y);
			Data.write(myName + "team", p.team);

			for (int i = 0; i < players.size(); i++) {
				// get the players data from the server
				String name = players.get(i).name;
				int x = Data.read(name + "x");
				int y = Data.read(name + "y");
				int team = Data.read(name + "team");


				// set the server data to the player
				players.get(i).x = x;
				players.get(i).y = y;
				players.get(i).team = team;

				players.get(i).draw();
			}

			// move and draw the ball

			b.x = Data.read("ballx");
			b.y = Data.read("bally");
			System.out.println(b.x + " " + b.y);

			b.draw();


			// if player hits ball
			if (p.checkCollsion(b)) {
				b.dx = (b.x - p.x) * 3;
				b.dy = (b.y - p.y) * 3;
				b.move();
				Data.write("ballx", b.x);
				Data.write("bally", b.y);
			}

			if (b.checkBoundaries()) {
				b.move();
				Data.write("ballx", b.x);
				Data.write("bally", b.y);
			}

			Window.frame();
		}
	}

	public static void drawBackground() {
		Window.out.background("green");
		// draws the white lines in the middle of the screen
		for (int y = 25; y < Window.height(); y += 50) {
			Window.out.color("white");
			Window.out.rectangle(Window.width() / 2, y, 10, 25);
		}

		// draws the center circle
		Window.out.color("white");
		Window.out.circle(Window.width() / 2, Window.height() / 2, 100);
		Window.out.color("green");
		Window.out.circle(Window.width() / 2, Window.height() / 2, 90);

		// draw the goals
		Window.out.color("white");
		Window.out.rectangle(0, Window.height() / 2, 50, 150);
		Window.out.rectangle(Window.width(), Window.height() / 2, 50, 150);
	}

}



