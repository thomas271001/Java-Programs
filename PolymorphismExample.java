interface Shape{
    double calculateArea();
 }
 
 class Triangle implements Shape{
  private double base,height;
  public Triangle(double base,double height){
  this.base=base;
  this.height=height;
 }
 public double calculateArea(){
    return 0.5*base*height;
   }
 }
 public class PolymorphismExample{
    public static void main (String args[]){
       Shape Shape = new Triangle(10,5);
       System.out.println("Area of Triangle: " +Shape.calculateArea());
    }
 }
 