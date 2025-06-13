import java.util.Scanner;

interface Shape{
   void disp();
   void calc();
}

class Circle implements Shape{
  private double radius;
  public Circle(double radius){
  this.radius=radius;
}

public void disp(){
     System.out.println("This is a Circle.");
}


public void calc(){
  double volume=(4.0/3)*Math.PI*Math.pow(radius,3);
  System.out.println("Volume of Sphere: " + volume);
}
}
class Rectangle implements Shape {  
    private double length, width, height;  

public Rectangle(double length,double width, double height){
   this.length=length;
   this.width=width;
   this.height=height;   
}


public void disp(){
       System.out.println("This is a Rectangle.");
}

public void calc(){
      double volume=length*width*height;
      System.out.println("Volume of Cuboid: " + volume);
}


}
public class shapeDemo{
public static void main(String args[]){
Scanner scanner=new Scanner(System.in);
System.out.println("Choose a shape: 1. Circle 2. Rectangle");
int choice = scanner.nextInt();
Shape shape; 
switch(choice){
  case 1:
      System.out.print("Enter radius of the circle: ");
      double radius =scanner.nextDouble();
      shape=new Circle(radius);
      break;
 case  2:
       System.out.print("Enter length, width, and height of the rectangle: ");
       double length =scanner.nextDouble();
       double width = scanner.nextDouble();
       double height = scanner.nextDouble();
       shape = new Rectangle(length, width, height); 
       break;
 default:
                System.out.println("Invalid choice!");
                scanner.close();
                return;
       }
        shape.disp(); 
        shape.calc(); 
        scanner.close();
    }

  }
