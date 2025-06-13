import java.util.Scanner;

class GenericMethodExample{
public static <T> void displayArray(T[] array){
System.out.print("Array Elements: ");
for(T element : array){
    System.out.print(element + " ");
}
  System.out.println("\nArray Length: " + array.length);
}
public static void main(String args[]){
Scanner scanner=new Scanner(System.in);
System.out.print("Enter the number of elements for Integer array: ");
int intSize=scanner.nextInt();
Integer[] intArray=new Integer[intSize];
System.out.println("Enter " + intSize + " Integer values:");
for(int i=0;i<intSize;i++){
intArray[i]=scanner.nextInt();
}
System.out.print("Enter the number of elements for String array: ");
int strSize=scanner.nextInt();
scanner.nextLine();
String[] strArray =new String[strSize];
System.out.println("Enter " + strSize + " Strings:");
for(int i=0;i<strSize;i++){
      strArray[i] = scanner.nextLine();
}
System.out.print("Enter the number of elements for Double array: ");
int doubleSize=scanner.nextInt();
Double[] doubleArray=new Double[doubleSize];
System.out.println("Enter " + doubleSize + " Double values:");
for(int i=0;i<doubleSize;i++){
doubleArray[i] = scanner.nextDouble();
}
       System.out.println("\nDisplaying Integer Array:");
        displayArray(intArray);
        System.out.println("\nDisplaying String Array:");
        displayArray(strArray);
        System.out.println("\nDisplaying Double Array:");
        displayArray(doubleArray);
        scanner.close();
    }
}
