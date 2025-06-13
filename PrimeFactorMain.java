import mathoperations.Primefactors;
import java.util.Scanner;

public class PrimeFactorMain {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter a number: ");
    int num = sc.nextInt();

    Primefactors.findPrimeFactors(num);
}
}
