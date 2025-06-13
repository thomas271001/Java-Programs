import java.util.Scanner;
class NumberWrapper{
      double value;
      NumberWrapper(double value){
      this.value=value;
}
}

public class SquareRootByReference {
     static void findsquareRoot(NumberWrapper num){
     num.value=Math.sqrt(num.value);
     }
     public static void main(String args[]){
     Scanner sc=new Scanner(System.in);
     System.out.println("Enter a number");
     double input=sc.nextDouble();
     NumberWrapper number=new NumberWrapper(input);
     System.out.println("Before Function call:Number =" +number.value);
     sc.close();
}
}
