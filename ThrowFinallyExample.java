import java.util.Scanner;
public class ThrowFinallyExample {
    public static void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or above.");
        }
        System.out.println("You are eligible for vote.");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    
        try {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();
            validateAge(age);  
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            sc.close();
            System.out.println("Program execution completed.");
        }
    }
}
