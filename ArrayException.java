import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;


public class ArrayException{
public static void main(String args[]){
    System.out.println("Enter number of elements in an array");
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] numbers=new int[n];
    try{
      System.out.println("Enter " +n+ "numbers");
      for(int i=0;i<n;i++){
        numbers[i]=sc.nextInt();
    }
    
    System.out.println("Extra Number : " +numbers[n]);
    }
    catch(InputMismatchException e){
    System.out.println("Invalid input!");
    }catch(ArrayIndexOutOfBoundsException e){
     System.out.println("Error: Array index out of bounds!");
     }
     catch(Exception e){
     System.out.println("General Exception: " + e.getMessage());
     }finally{
     sc.close();
     System.out.println("Scanner closed.");
     }
}
}
