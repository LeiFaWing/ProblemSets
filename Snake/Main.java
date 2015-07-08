package snake;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import apcs.Window;

public class Main {
	
	static Snake head = new Snake();
	static Snake head2 = new Snake(250, 250);
	static Snake newHead2 = new Snake(250, 250);
	static long newHead2x = 250;
	static long newHead2y = 250;
	static Food f = new Food();
	static long foodx = 100;
	static long foody = 100;
	static boolean update = false;
	
	public static void main (String[] args) {
		Window.size(800, 800);
		
		Firebase server = new Firebase("https://multiplayersnake.firebaseio.com");
		
		server.child("foodx").addValueEventListener(new ValueEventListener() {

			@Override
			public void onCancelled(FirebaseError arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onDataChange(DataSnapshot d) {
				update = true;
				foodx = (Long) d.getValue();
				update = false;
			}
			
		});
		
		server.child("foody").addValueEventListener(new ValueEventListener() {

			@Override
			public void onCancelled(FirebaseError arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onDataChange(DataSnapshot d) {
				update = true;
				foody = (Long) d.getValue();
				update = false;
			}
			
		});
		
		server.child("head2x").addValueEventListener(new ValueEventListener() {

			@Override
			public void onCancelled(FirebaseError arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onDataChange(DataSnapshot data) {
				// TODO Auto-generated method stub
				update = true;
				newHead2x = (long) data.getValue();
				update = false;
			}
			
		});
		
		server.child("head2y").addValueEventListener(new ValueEventListener() {

			@Override
			public void onCancelled(FirebaseError arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onDataChange(DataSnapshot data) {
				// TODO Auto-generated method stub
				update = true;
				newHead2y = (long) data.getValue();
				update = false;
			}
			
		});
		
		
		while (true) {
			Window.out.background("black");
			if (!update) {
				head2.x = (int) newHead2x;
				head2.y = (int) newHead2y;
				f.x = (int) foodx;
				f.y = (int) foody;
			}
			
			f.draw();
			
			head2.draw();
			head2.changeDirection();
			head2.move();
			head.draw();
			head.changeDirection();
			head.move();
			
			server.child("head1x").setValue(head.x);
			server.child("head1y").setValue(head.y);
			
			if (head.checkBoundaries()) {
				head = new Snake();
			}
			
			if (head.checkItself(head)) {
				head = new Snake();
			}
			
			if (head.checkFood(f)) {
				head.grow();
				f.reset();
				server.child("foodx").setValue(f.x);
				server.child("foody").setValue(f.y);
			}
			
			if (head2.checkBoundaries()) {
				head2 = new Snake();
			}
			
			if (head2.checkItself(head2)) {
				head2 = new Snake();
			}
			
			if (head2.checkFood(f)) {
				head2.grow();
				f.reset();
				server.child("foodx").setValue(f.x);
				server.child("foody").setValue(f.y);
			}
			
			Window.frame();
		}
	}
}
