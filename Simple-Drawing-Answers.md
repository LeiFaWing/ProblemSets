## Drawing Answers

1.) A circle moves across the screen from left to right

2.)

```java
public class AdvancedDraw {
  public static void main (String[] args) {
    
    int x = -50;
    
    while (true)
    {
      Window.out.background("white");
			Window.out.color("black");
			Window.out.circle(x, Window.height()/2, 50);
			x += 10;
			
			Window.frame();
    }
    
  }
}
```
