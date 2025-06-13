import mathoperations.Combinations;
import java.util.Scanner;

public class NCRMain{
      public static void main(String[] args) {
      Scanner sc= new Scanner(System.in);
       System.out.print("Enter n: ");
       int n=sc.nextInt();
       System.out.print("Enter r: ");
       int r=sc.nextInt();
       if(r>n){
            System.out.println("r cannot be greater than n.");
       }else{
        System.out.println("nCr = "+Combinations.nCr(n,r));
       }
}
}
