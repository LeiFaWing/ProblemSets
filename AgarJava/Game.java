package Agar;

import java.util.ArrayList;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import apcs.Window;



public class Game {

	static Firebase server = new Firebase("https://agarjava.firebaseio.com/");
	static int ballNumber = 0;
	static int cooldown = 25;
	static Player p;

	public static void main(String[] args) {
		Window.size(1000, 800);
		Window.setFrameRate(30);

		p = new Player("steve");

		ArrayList<Player> players = new ArrayList<Player>();

		ArrayList <Blob> blobs = new ArrayList <Blob> ();


		for (int i = 0 ; i < 2000 ; i++) {
			blobs.add(new Blob());
		}



		server.child("online").child("steve").setValue(true);
		server.child("online").child("steve").onDisconnect().setValue(false);

		

		server.child("online").addChildEventListener(new ChildEventListener() {

			@Override
			public void onCancelled(FirebaseError arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onChildAdded(DataSnapshot data, String _) {
				String name = data.getKey();
				players.add(new Player(name));
				if (name.equals(p.name)) {
					p = players.get(players.size() - 1);
				}
			}

			@Override
			public void onChildChanged(DataSnapshot data, String _) {
				String name = data.getKey();
				if ((Boolean) data.getValue()) {
					System.out.println(name + " is online");
				}
				else {
					System.out.println(name + " is not online");
					server.child(name).removeValue();
				}
			}

			@Override
			public void onChildMoved(DataSnapshot arg0, String arg1) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onChildRemoved(DataSnapshot data) {
				String name = data.getKey();
			}

		});




		while (true) {
			Window.out.background(220, 220, 220);
			drawGrid();

			for (int i = 0; i < players.size(); i++) {
				if (!players.get(i).name.equals(p.name)) {
					players.get(i).draw(p.x, p.y, p.scale);
				}

				if (p.checkCollision(players.get(i))) {
					if (p.radius > players.get(i).radius) {
						p.radius += players.get(i).radius / 4;
					}
					else if (p.radius < players.get(i).radius && players.get(i).radius < 3000){
						p.reset();
						p.setValues();
						server.child("online/steve").removeValue();
					}
				}
			}

			p.draw();

			if (p.radius > 100 && cooldown >= 25) {
				p.radius = (int) (p.radius - (p.radius * .01));
				cooldown = 0;
			}

			for (int i = 0 ; i < blobs.size() ; i++) {
				blobs.get(i).draw(p.x, p.y, p.scale);

				if (p.checkCollision(blobs.get(i))) {
					blobs.get(i).reset();
					blobs.get(i).setValues();
					p.radius += 1;
				}
			}

			p.move();

			if (blobs.size() < 5000) {
				blobs.add(new Blob());
			}


			p.setValues();

			cooldown++;

			Window.frame();
		}
	}
	
	public static void drawGrid() {
		for (int x = 0; x < 10000; x += 31) {
			for (int y = 0; y < 10000; y += 31) {
				if (Math.abs(x - p.x) <= (Window.width() / 2) * p.scale + 30 &&
						Math.abs(y - p.y) <= Window.height() * p.scale / 2 + 30) {
					Window.out.color("white");
					Window.out.square(Window.width() / 2 + (x - p.x) / p.scale, 
							Window.height() / 2 + (y - p.y) / p.scale, 30 / p.scale);
				}
			}
		}
	}

}
