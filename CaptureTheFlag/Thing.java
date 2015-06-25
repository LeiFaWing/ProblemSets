package flag;

public interface Thing {
	
	public void draw();
	public void move();
	public boolean checkCollision(Thing otherThing);
	public boolean isFlag();
	public void follow();
	public int getX();
	public int getY();
	public int getRadius();
	public int getWidth();
	public int getHeight();
}
