package Agar;

import java.util.ArrayList;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import apcs.Window;

public class Game {

	public static void main(String[] args) {
		Window.size(800, 600);
		Window.setFrameRate(30);

		Firebase server = new Firebase("https://agarjava.firebaseio.com/");
		
		ArrayList<Player> players = new ArrayList<Player>();
		
		server.child("online").child("steve").setValue(true);
		server.child("online").child("steve").onDisconnect().setValue(false);
		
		Player p = new Player("steve");
		
		server.child("online").addChildEventListener(new ChildEventListener() {

			@Override
			public void onCancelled(FirebaseError arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onChildAdded(DataSnapshot data, String _) {
				String name = data.getKey();
				players.add(new Player(name));
			}

			@Override
			public void onChildChanged(DataSnapshot data, String _) {
				String name = data.getKey();
				if ((Boolean) data.getValue()) {
					System.out.println(name + " is online");
				}
				else {
					System.out.println(name + " is not online");
				}
			}

			@Override
			public void onChildMoved(DataSnapshot arg0, String arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onChildRemoved(DataSnapshot arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		ArrayList <Blob> blobs = new ArrayList <Blob> ();


		for (int i = 0 ; i < 1000 ; i++) {
			blobs.add(new Blob());
		}


		while (true) {
			Window.out.background("white");

			p.draw();

			for (int i = 0 ; i < blobs.size() ; i++) {
				blobs.get(i).draw(p.x, p.y);
			}

			if (p.x > 9600) {
				Window.out.color("black");
				Window.out.square(10800 - p.x, 400, 800);
			}

			p.move();

			Window.frame();
		}
	}

}
