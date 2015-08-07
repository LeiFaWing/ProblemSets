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
		
		int score1 = Data.read("score1");
		int score2 = Data.read("score2");
		int max = 3;
		int winner = Data.read("winner");

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
		//Window.sleep(20000);
		
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
			
			if (b.redScores()) {
				score1++;
				Data.write("score1", score1);
				b.reset();
				Data.write("ballx", b.x);
				Data.write("bally", b.y);
				p.reset();
			}
			
			if (b.blueScores()) {
				score2++;
				Data.write("score2", score2);
				b.reset();
				Data.write("ballx", b.x);
				Data.write("bally", b.y);
				p.reset();
			}
			
			score1 = Data.read("score1");
			score2 = Data.read("score2");
			
			if (score1 >= max) {
				winner = 1;
				Data.write("winner", winner);
			}
			
			if (score2 >= max) {
				winner = 2;
				Data.write("winner", winner);
			}
			
			winner = Data.read("winner");
			
			if (winner == 1) {
				Window.out.color(255, 0, 0);
				Window.out.print("RED TEAM WINS", 250, 250);
				Data.write("winner", 0);
				Data.write("score1", 0);
				Data.write("score2", 0);
				Window.frame(2000);
				System.exit(0);
			}
			
			if (winner == 2) {
				Window.out.color(0, 0, 255);
				Window.out.print("BLUE TEAM WINS", 250, 250);
				Data.write("winner", 0);
				Data.write("score1", 0);
				Data.write("score2", 0);
				Window.frame(2000);
				System.exit(0);
			}
			
			Window.out.color("black");
			Window.out.font("arial", 30);
			Window.out.print("RED: " + score1, 10, 30);
			Window.out.print("BLUE: " + score2, Window.width() - 200, 30);
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



