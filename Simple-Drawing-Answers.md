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
