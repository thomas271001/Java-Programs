import java.util.Scanner;
public class ReverseStringLoop{
     public static void main(String args[]){
      Scanner sc=new Scanner(System.in);
      System.out.print("Enter a string: ");
      char[] str=sc.nextLine().toCharArray();
      System.out.print("Reversed String: ");
      for(int i=str.length-1;i>=0;i--){
        System.out.print(str[i]);
}
        System.out.println();
        sc.close();
}
}
