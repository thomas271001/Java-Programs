import java.io.*;
import java.util.Scanner;
class PrimeNumberException  extends Exception{
      public PrimeNumberException(String message){
      super(message);
}
}
 class PrimeNumberCheck{
       static boolean isPrime(int num){
       if(num<2){
         return false;}
       for(int i=2;i<=Math.sqrt(num);i++){
           if(num%i==0) return false;
}
return true;
}
public static void main(String args[]){
Scanner sc= new Scanner(System.in);
try{
   System.out.print("Enter a number: ");
   int num = sc.nextInt();
if(isPrime(num)){
throw new PrimeNumberException("Prime number encountered: " + num);
}
System.out.println(num + " is not a prime number."); 
}
catch(PrimeNumberException e){
 System.out.println("Exception: " + e.getMessage());}
finally{
       sc.close();
}
}
}
