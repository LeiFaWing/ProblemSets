## Drawing Answers

1.) A circle moves across the middle of the screen from left to right

2.)

```java
public class AdvancedDraw {
	public static void main(String[] args) {
		
		int x = -50;
		
		while (true) {
			Window.out.background("white");
			Window.out.color("black");
			Window.out.circle(x, Window.height()/2, 50);
			x += 10;
			
			if (x > Window.width()) {
				x = -50;
			}
			
			Window.frame();
		}
	}
}
```

3.)

```java
public class AdvancedDraw {
	public static void main(String[] args) {
		int x = -50;
		boolean right = true;
		
		while (true) {
			Window.out.background("white");
			Window.out.color("black");
			Window.out.circle(x, Window.height()/2, 50);
			
			if (x == 0) {
				right = true;
			}
			else if (x == Window.width()) {
				right = false;
			}
			
			if (right) {
				x += 10;
			}
			else {
				x -= 10;
			}
			
			Window.frame();
		}
	}
}
```

4.)

```java
public class ClickAndDraw {
	public static void main (String[] args) {
		Window.out.background("white");
		
		Window.out.color("black");
		Window.out.rectangle(250, 100, 250, 25);
		Window.out.rectangle(250, 400, 250, 25);
		Window.out.rectangle(115, 250, 25, 325);
		Window.out.rectangle(385, 250, 25, 325);
		
		while(true) {
			if (Window.mouse.clicked()) {
				if (Window.mouse.getX() < 350 && Window.mouse.getX() > 150 && 
					Window.mouse.getY() < 365 && Window.mouse.getY() > 135) {
					
					Window.out.color("red");
					Window.out.circle(Window.mouse.getX(), Window.mouse.getY(), 25);
				}
			}
		}
	}
}
```
