package day2;

import apcs.Window;

public class RareCoin extends Coin{
	
	int cooldown;
	int xspeed;
	
	public RareCoin() {
		speed = super.speed * 4;
		radius = super.radius / 2;
		xspeed = Window.rollDice(7) + 7;
		cooldown = Window.rollDice(10) + 10;
	}
	
	@Override
	public void draw() {
		Window.out.randomColor();
		Window.out.circle(x, y, radius);
	}
	
	@Override
	public void move() {
		if (cooldown < 15) {
			x += xspeed;
		}
		else if (cooldown < 30){
			x -= xspeed;
		}
		
		if (cooldown > 45) {
			cooldown = 0;
		}
		
		y += speed;
		cooldown++;
	}
}
