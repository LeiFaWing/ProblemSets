## Drawing Problem Set

Use the following code to answer questions 1 to 3 :

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

2.) Modify the code above so that the circle moves back to its starting position after it leaves the window.

3.) Modify the code above so that the circle bounces back and forth between the edges

Use the following code to answer question 4

```java
public class ClickAndDraw {
  public static void main (String[] args) {
    Window.out.background("white");
    
    while(true) {
      if (Window.mouse.clicked()) {
        Window.out.color("red");
        Window.out.circle(Window.mouse.getX(), Window.mouse.getY(), 25);
      }
    }
  }
}
```

4. Modify the code above so that you can only draw within the black box.
