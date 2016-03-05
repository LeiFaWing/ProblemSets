package SpaceInvaders;

public interface Thing {

	public void draw();
	public void move();
	public boolean isTouching(Thing t);
	public boolean isEnemy();
	public int getX();
	public int getY();
	public void setX(int x);
	public void setY(int y);
	public int getSize();
	public boolean shoot();
	public boolean outside();
	public boolean isEnemySpaceship();
}
