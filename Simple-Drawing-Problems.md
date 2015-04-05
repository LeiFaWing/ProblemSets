## Drawing Problem Set

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

1.) What happens when we run the code above?

2.) Modify the code so that the circle moves back to its starting position after it leaves the window.

3.) Modify the code so that the circle bounces off the edges of the window.

4.) Modify the code so that the circle moves in a circular motion
