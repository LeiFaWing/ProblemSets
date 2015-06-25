package flag;

public interface Thing {
	
	public void draw();
	public void move();
	public int checkCollision(Thing otherThing);
	public boolean isFlag();
	public void follow(int x, int y);
	public int getX();
	public int getY();
	public int getRadius();
	public int getWidth();
	public int getHeight();
}
