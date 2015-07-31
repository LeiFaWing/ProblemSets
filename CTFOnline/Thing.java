package CTFOnline;

public interface Thing {
	
	public void draw();
	public void move();
	public boolean isFlag();
	public int checkCollision(Thing t);
	public int getTeam();
	public int getX();
	public int getY();
	public int getRadius();
	public int getWidth();
	public int getHeight();
	public void reset();
	public void follow(int x, int y);
	public void setX(int x);
	public void setY(int y);
	public String getName();
	public void setTeam(int team);

}
