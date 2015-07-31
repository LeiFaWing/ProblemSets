package CTFOnline;

import java.util.ArrayList;

import apcs.Data;
import apcs.Window;

// http://pastebin.com/E1s25Fpk

public class CTFOnline {

	public static void main(String[] args) {
		Window.size(1200, 800);

		Data.connect("ctf");
		
		int win = 0;

		String[] names = { "steve", "brandon", "stephen", "nikhil", "vaishavi", "daniel" };

		String myName = "steve"; // put your own name

		Thing p = new Player(1, myName);

		// write your own position to the server
		Data.write(myName + "x", p.getX());
		Data.write(myName + "y", p.getY());
		Data.write(myName + "team", p.getTeam());

		ArrayList<Thing> things = new ArrayList<Thing>();

		// add players into the arraylist
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(myName) == false) {
				things.add(new Player(Data.read(names[i] + "team"), names[i]));
			}
		}

		Thing flag1 = new Flag(1, "flag1");
		Thing flag2 = new Flag(2, "flag2");

		// write the flags position to the server
		Data.write("flag1x", flag1.getX());
		Data.write("flag1y", flag1.getY());
		Data.write("flag2x", flag2.getX());
		Data.write("flag2y", flag2.getY());
		Data.write("flag1team", flag1.getTeam());
		Data.write("flag2team", flag2.getTeam());

		// add flags to arraylist
		things.add(flag1);
		things.add(flag2);

		while (true) {
			drawBackground();

			// this is you
			p.draw();
			p.move();


			// other players
			for (int i = 0; i < things.size(); i++) {
				int x = Data.read(things.get(i).getName() + "x");
				int y = Data.read(things.get(i).getName() + "y");
				int team = Data.read(things.get(i).getName() + "team");
				things.get(i).setX(x);
				things.get(i).setY(y);
				things.get(i).setTeam(team);

				things.get(i).draw();
				// check collision between other things
				// picked up the flag
				if (p.checkCollision(things.get(i)) == 1) {
					things.get(i).follow(p.getX(), p.getY());
					Data.write(things.get(i).getName() + "x", things.get(i).getX());
					Data.write(things.get(i).getName() + "y", things.get(i).getY());
				}
				// touched another player
				if (things.get(i).checkCollision(p) == 2) {
					p.reset();
				}
				// touched own flag
				if (p.checkCollision(things.get(i)) == 2 && things.get(i).isFlag()) {
					things.get(i).reset();
					Data.write(things.get(i).getName() + "x", things.get(i).getX());
					Data.write(things.get(i).getName() + "y", things.get(i).getY());
				}
				// win condition
				if (p.checkCollision(things.get(i)) == 3) {
					win = p.getTeam();
					Data.write("win", p.getTeam());
				}
			}
			
			win = Data.read("win");
			// there is a winner
			if (win == 1) {
				Window.out.color("white");
				Window.out.font("arial", 40);
				Window.out.print("BLUE TEAM WINS", 400, 300);
				Window.frame(2000);
				Data.write("win", 0);
				System.exit(0);
//				p.reset();
//				Data.write(myName + "x", p.getX());
//				Data.write(myName + "y", p.getY());
//				
//				things.get(things.size() - 2).reset();
//				things.get(things.size() - 1).reset();
//				int x = things.get(things.size() - 2).getX();
//				int y = things.get(things.size() - 2).getY();
//				Data.write("flag1x", x);
//				Data.write("flag1y", y);
//				x = things.get(things.size() - 1).getX();
//				y = things.get(things.size() - 1).getY();
//				Data.write("flag2x", x);
//				Data.write("flag2y", y);
			}
			else if (win == 2){
				Window.out.color("white");
				Window.out.font("arial", 40);
				Window.out.print("RED TEAM WINS", 400, 300);
				Window.frame(2000);
				Data.write("win", 0);
				System.exit(0);
//				p.reset();
//				Data.write(myName + "x", p.getX());
//				Data.write(myName + "y", p.getY());
//				
//				things.get(things.size() - 2).reset();
//				things.get(things.size() - 1).reset();
//				int x = things.get(things.size() - 2).getX();
//				int y = things.get(things.size() - 2).getY();
//				Data.write("flag1x", x);
//				Data.write("flag1y", y);
//				x = things.get(things.size() - 1).getX();
//				y = things.get(things.size() - 1).getY();
//				Data.write("flag2x", x);
//				Data.write("flag2y", y);
			}

			Data.write(myName + "x", p.getX());
			Data.write(myName + "y", p.getY());
			Data.write(myName + "team", p.getTeam());

			Window.frame();
		}

	}

	public static void drawBackground() {
		Window.out.background("green");
		// draw middle line
		Window.out.color("white");
		Window.out.rectangle(Window.width() / 2, Window.height() / 2, 10, Window.height());

		// draw circles for flag
		Window.out.color("white");
		Window.out.circle(50, Window.height() / 2, 40);
		Window.out.circle(Window.width() - 50, Window.height() / 2, 40);
		Window.out.color("green");
		Window.out.circle(50, Window.height() / 2, 35);
		Window.out.circle(Window.width() - 50, Window.height() / 2, 35);
	}

}





